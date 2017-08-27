package com.hack.mobilistore.conection;

/**
 * Created by DIEGO on 27/08/2017.
 */


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Clase que hay que extender para conectarse a la BD y mandar querys y obtener los resultados
 */
public abstract class ConectarBD {
    final private AppCompatActivity activity;
    private String params, url;

    public ConectarBD(AppCompatActivity act, String params, String url){
        activity= act;
        this.url = url;
        this.params = params;
    }

    public final boolean conectarBD(){
        ConnectivityManager connMgr = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo == null || !networkInfo.isConnected()) {
            Toast aviso= Toast.makeText(activity,"hola", Toast.LENGTH_LONG);
            aviso.setDuration(Toast.LENGTH_LONG);
            aviso.setText("Error al conectarse a la red");
            aviso.show();
            return false;
        }

        new DownloadWebpageTask().execute(url);
        return true;
    }


    final private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        final protected String doInBackground(String... urls) {
            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Error interno: descargando urls.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        final protected void onPostExecute(String result) {
            Toast avis=new Toast(activity);
            Toast aviso= avis.makeText(activity,"hola", Toast.LENGTH_LONG);
            aviso.setDuration(Toast.LENGTH_LONG);

            if(result.equals("Error.")){
                aviso.setText("Error a intentar conectarse con el servidor.");
                aviso.show();
                accionConResult(null, -1);
                return;
            }else{
                accionConResult(result, 1);
            }

        }


        final private String downloadUrl(String myurl) throws IOException {
            InputStream is = null;
            // Only display the first 500 characters of the retrieved
            // web page content.
            int len = 500;

            try {
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");



                String data = URLEncoder.encode("json", "UTF-8")
                        + "=" + URLEncoder.encode(params, "UTF-8");//La clave de codificacion

                conn.setDoOutput(true);
                conn.setDoInput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write(data);
                wr.flush();

                // Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                System.out.println("The response is: " + response);
                is = conn.getInputStream();

                // Convert the InputStream into a string
                String contentAsString = readIt(is, 20000);// len); TODO: Cambiado porque hace que se tengan que cortar los valores, pero no se si funcione...
                return contentAsString;

                // Makes sure that the InputStream is closed after the app is
                // finished using it.
            } finally {
                if (is != null) {
                    is.close();
                }
            }

        }


        // Reads an InputStream and converts it to a String.
        final private String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
            Reader reader = null;
            reader = new InputStreamReader(stream, "UTF-8");
            char[] buffer = new char[len];
            reader.read(buffer);
            return new String(buffer);
        }


    }


    //Metodo que hay que override (sin necesidad de super()) en el que se pone que pasara con lo que regrese el query
    /**Estado 0=Todoo bajo control pero sin resultados, 1=Todoo bajo control con resultados, -1:Error
     Si sale 0 o -1, el arreglo sera null */
    abstract protected void accionConResult(String response, int estado);

}

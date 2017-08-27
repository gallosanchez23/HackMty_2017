package com.hack.mobilistore.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DIEGO on 27/08/2017.
 */

abstract class PreferencesUser {

    SharedPreferences sharedPreferences;
    private final Context context;

    PreferencesUser(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    public abstract void close();

}

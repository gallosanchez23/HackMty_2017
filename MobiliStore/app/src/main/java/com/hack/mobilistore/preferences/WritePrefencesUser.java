package com.hack.mobilistore.preferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DIEGO on 27/08/2017.
 */

public final class WritePrefencesUser extends PreferencesUser {
    private SharedPreferences.Editor editor;

    public WritePrefencesUser(Context context) {
        super(context);

        editor = sharedPreferences.edit();
    }


    public final void setUserID(String user) {
        editor.putString("UserID", user);
    }

    public final void setCompleteName(String completeName) {
        editor.putString("UserCompleteName", completeName);
    }

    public final void setUserField(String field, String value) {
        editor.putString(field, value);
    }

    @Override
    public void close() {
        editor.commit();
    }
}

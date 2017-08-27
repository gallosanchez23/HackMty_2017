package com.hack.mobilistore.preferences;

import android.content.Context;

/**
 * Created by DIEGO on 27/08/2017.
 */

public final class ReadPreferencesUser extends PreferencesUser {

    public ReadPreferencesUser(Context context) {
        super(context);
    }

    public final boolean isUserLoggedIn(){
        return !(getUserID().isEmpty() || getUserCompleteName().isEmpty());
    }

    public final String getUserID() {
        return sharedPreferences.getString("UserID", "");
    }

    public final String getUserCompleteName() {
        return sharedPreferences.getString("UserCompleteName", "");
    }

    public final String getUserField(String field) {
        return sharedPreferences.getString(field, "");
    }

    @Override
    public void close() {

    }
}

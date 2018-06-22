package com.unovasyon.unschool;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hiper on 22.06.2018.
 */

public class t extends AppCompatActivity {
    public static void print(String s1){
        Log.v("vvvvvvv",s1);
    }
    public static boolean empty(String v1) {
        return !(v1 != null && !v1.isEmpty() && !TextUtils.isEmpty(v1));
    }
    public static void go_to(Context ct,Class v1) {
        Intent myIntent = new Intent(ct, v1);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ct.startActivity(myIntent);
    }
    public static boolean isNetworkAvailable(Context ct) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) ct.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    static void hideSoftKeyBoard(View ct, View gt) {
        Context cc= ct.getContext();
        InputMethodManager imm = (InputMethodManager) cc.getSystemService(INPUT_METHOD_SERVICE);

        if(imm.isAcceptingText()) { // verify if the soft keyboard is open
            imm.hideSoftInputFromWindow(gt.getWindowToken(), 0);
        }
    }
    public static String json_get_val(String JSON, String ge) {
        String tar = "";
        String tar2 = "";
        JSONArray jsonArr = null;
        JSONObject jsonArray = null;

        try {
            jsonArray = new JSONObject(JSON);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        tar2 = jsonArray.optString(ge);
        if (empty(tar2) == false) {
            tar = tar2;
        }

        return tar;
    }
    public static void hata_yolla(final Context ct,String v1, final Class v2) {
        tost(ct,v1);

        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1100);
                    if (v2 != null) {
                        go_to(ct,v2);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // your code here
            }
        }.start();
    }
    public static void tost(Context ct,String v1) {
        Toast toastMessage = null;
        if (toastMessage!= null) {
            toastMessage.cancel();
        }
        toastMessage= Toast.makeText(ct, v1, Toast.LENGTH_LONG);
        toastMessage.show();
    }
    public static String getDump(Object o) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(o);
    }

    private static String[] push(String[] array, String push) {
        String[] longer = new String[array.length + 1];
        System.arraycopy(array, 0, longer, 0, array.length);
        longer[array.length] = push;
        return longer;
    }
    public static AlertDialog modal_ac(Context ct,String v1) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(ct);
        builder.setMessage(v1)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton("Geri", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    public static AlertDialog modal_exit(final Context ct,String v1, String v2, String v3) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(ct);
        builder.setMessage(v1)
                .setPositiveButton(v3, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton(v2, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        login_activity.login = -1;
                        login_activity.yet = -1;
                        tost(ct,"exit/quit");
                        go_to(ct,start_activity.class);
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}

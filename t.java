package com.unovasyon.unschool;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.function.Function;

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
        JSONObject JSONObject = null;

        try {

            JSONObject = new JSONObject(JSON);
            tar2 = JSONObject.optString(ge);

            if (empty(tar2) == false) {
                tar = tar2;
            }

        } catch (JSONException e) {
            e.printStackTrace();
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
    public static AlertDialog.Builder modal_ac(Context ct, String v1) {
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
        builder.create();
        builder.show();
        return builder;
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


    public static void control_login(final Context ct) {
        View rootView = ((Activity) ct).getWindow().getDecorView();
        String s1 = String.valueOf(login_activity.login);

        if (s1.equals("1") && isNetworkAvailable(ct)) {
            final Button b1 = (Button) rootView.findViewById(R.id.bar1);
            b1.setVisibility(View.VISIBLE);
            final Button b2 = (Button) rootView.findViewById(R.id.bar2);
            b2.setVisibility(View.VISIBLE);
            final Button bar_home=(Button) rootView.findViewById(R.id.bar_home);
            final Button bar32 = (Button) rootView.findViewById(R.id.bar32);
            final LinearLayout nav_id = (LinearLayout) rootView.findViewById(R.id.nav_id);
            final Button nav4 = (Button) rootView.findViewById(R.id.nav4);
            final Button nav1 = (Button) rootView.findViewById(R.id.nav1);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    t.modal_exit(v.getContext(),"Çıkmak exit?", "Çıkış", "İptal").show();
                }
            });
            nav4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nav_id.setVisibility(View.GONE);
                    t.modal_exit(v.getContext(),"Çıkmak exit?", "Çıkış", "İptal").show();
                }
            });
            nav1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nav_id.setVisibility(View.GONE);
                    t.go_to(ct,p_kurumsal_yonet.class);
                }
            });
            bar_home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nav_id.setVisibility(View.GONE);
                    t.go_to(ct,start_page.class);
                }
            });
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (nav_id.getVisibility() == View.VISIBLE) {
                        v.setAlpha((float) 1);
                        nav_id.setVisibility(View.GONE);
                    } else {
                        v.setAlpha((float) 0.5);
                        nav_id.setVisibility(View.VISIBLE);
                        nav_id.setTranslationX(-1000);
                        ObjectAnimator animation = ObjectAnimator.ofFloat(nav_id, "translationX", 00f);
                        animation.setDuration(290);
                        animation.start();
                    }
                }

            });
            bar32.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (nav_id.getVisibility() == View.VISIBLE) {
                        b1.setAlpha((float) 1);
                        nav_id.setVisibility(View.GONE); // Its visible
                    }
                }
            });
        }else{
            hata_yolla(ct,"restart",start_activity.class);
        }
    }

    public static void show(Context ct,int vc){
        //LinearLayout lay1=(LinearLayout) ct.findViewById(vc);
        View rootView = ((Activity) ct).getWindow().getDecorView().findViewById(vc);
        //View rootView = ct.findViewById(vc);
        rootView.setVisibility(View.VISIBLE);
    }

    public static void hide(Context ct,int vc){
        //View rootView = ct.findViewById(vc);
        View rootView = ((Activity) ct).getWindow().getDecorView().findViewById(vc);
        rootView.setVisibility(View.GONE);
    }

    public static Activity getActivity(Context context) {
        if (context == null) return null;
        if (context instanceof Activity) return (Activity) context;
        if (context instanceof ContextWrapper) return getActivity(((ContextWrapper)context).getBaseContext());
        return null;
    }

    public static ProgressDialog load(Context ct,String s1){
        ProgressDialog progress = ProgressDialog.show(ct, "", s1, true);
        progress.show();
        return progress;
    }

    public static String getinput(Context ct,int vc){
        String s1;
        Activity ac=(Activity) ct;
        View vv=ac.getWindow().getDecorView();
        TextInputEditText tx= vv.findViewById(vc);
        s1=tx.getText().toString();
        return s1;
    }

    public static double compareStrings(String stringA, String stringB) {
        return StringUtils.getJaroWinklerDistance(stringA, stringB);
    }
    private static int getparam_layout(String s1){
        int pa1 = -2;
        if(s1.equals("m")){
            pa1=LinearLayout.LayoutParams.MATCH_PARENT;
        }else if(s1.equals("w")){
            pa1=LinearLayout.LayoutParams.WRAP_CONTENT;
        }
        return pa1;
    }
    public static TextView add_text(Context ct,String tx,String s1,String s2){
        int p1 = getparam_layout(s1);
        int p2 = getparam_layout(s2);
        TextView gtx = new TextView(ct);
        gtx.setLayoutParams(new LinearLayout.LayoutParams(p1, p2));
        gtx.setText(tx);
        return (TextView) gtx;
    }

    public static LinearLayout add_linear(Context ct,String s1,String s2){
        int p1 = getparam_layout(s1);
        int p2 = getparam_layout(s2);
        LinearLayout gtx = new LinearLayout(ct);
        gtx.setLayoutParams(new LinearLayout.LayoutParams(p1, p2));
        return (LinearLayout) gtx;
    }



}

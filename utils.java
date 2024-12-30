package com.unovasyon.unschool;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.math.BigInteger;

/**
 * Created by hiper on 22.06.2018.
 */

public class t extends AppCompatActivity {
    public static Context glob_ct;
    public static Bitmap logo = null;
    public static void print(String s1){
        Log.v("vvvvvvv",s1);
    }
    public static void print_int(int s1){
        Log.v("vvvvvvv",String.valueOf(s1));
    }
    public static boolean empty(String v1) {
        return !(v1 != null && !v1.isEmpty() && !TextUtils.isEmpty(v1));
    }
    public static View find(Context ct,int id){
        View obj;
        View rootView = ((Activity) ct).getWindow().getDecorView();
        obj=(View) rootView.findViewById(id);
        obj.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        return obj;
    }
    public static void gpu(View v){
        v.setLayerType(View.LAYER_TYPE_HARDWARE,null);
    }
    public static void gpu_id(Context ct,int id){
        View obj;
        View rootView = ((Activity) ct).getWindow().getDecorView();
        obj=(View) rootView.findViewById(id);
        rootView.setLayerType(View.LAYER_TYPE_HARDWARE,null);
    }
    public static void go_to(Context ct,Class v1) {
        Intent myIntent = new Intent(ct, v1);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        int anm=R.anim.anm_left;
        Bundle options = ActivityOptionsCompat.makeCustomAnimation(ct,anm,anm).toBundle();
        ct.startActivity(myIntent, options);
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
    public static AlertDialog.Builder modal_(Context ct, String v1) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(ct);
        builder.setMessage(v1)
                .setNegativeButton("İptal", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it

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

    public static int getcolorRGB(int Red, int Green, int Blue){
        Red = (Red << 16) & 0x00FF0000; //Shift red 16-bits and mask out other stuff
        Green = (Green << 8) & 0x0000FF00; //Shift Green 8-bits and mask out other stuff
        Blue = Blue & 0x000000FF; //Mask out anything not blue.
        return 0xFF000000 | Red | Green | Blue; //0xFF000000 for 100% Alpha. Bitwise OR everything together.
    }
    public static int getRGBA(int r, int g, int b,int a){
        int alpha = (int)(a * 255.0f);
        return Color.argb(alpha, r, g, b);
    }

    public static void control_login(final Context ct) {
        View rootView = ((Activity) ct).getWindow().getDecorView();
        String s1 = String.valueOf(login_activity.login);
        String yet = String.valueOf(login_activity.yet);
        if (s1.equals("1") && isNetworkAvailable(ct)) {
            final Button b1 = (Button) rootView.findViewById(R.id.bar1);
            b1.setVisibility(View.VISIBLE);
            b1.setLayerType(View.LAYER_TYPE_HARDWARE,null);
            final Button b2 = (Button) rootView.findViewById(R.id.bar2);
            b2.setVisibility(View.VISIBLE);


            final Button bar_home=(Button) rootView.findViewById(R.id.bar_home);
            final Button bar32 = (Button) rootView.findViewById(R.id.bar32);
            final LinearLayout nav_id = (LinearLayout) rootView.findViewById(R.id.nav_id);
            final Button nav4 = (Button) rootView.findViewById(R.id.nav4);
            final Button nav1 = (Button) rootView.findViewById(R.id.nav1);
            if(yet.equals("8")){
                nav1.setVisibility(View.GONE);
            }
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
                        animation.setDuration(200);
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

    public static void vid_play(Context ct,String s1){

        ViewGroup rotv  = ((Activity) ct).getWindow().getDecorView().findViewById(android.R.id.content);
        String file="";
        String title="";
        JSONObject found = get_searchjson(start_activity.vid,s1,"id");
        if(found.length() > 0){
            try {
                file= found.getString("file");
                title= found.getString("name");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        int wid_mar=get_width(ct);
        LinearLayout layt,layt2,layt3,layt4,layt_modal;
        Button bt1;
        TextView tx1;

        layt_modal=add_linear(ct,"m","m",0);
        layt_modal.setPadding(0,0,0,0);
        layt_modal.setBackgroundColor(color("#232323"));
        layt_modal.setOrientation(LinearLayout.VERTICAL);
        layt_modal.setId(findUnusedId(ct));

        //title parent
        layt4=add_linear(ct,"m","w",0);
        layt4.setPadding(0,0,0,0);
        layt4.setOrientation(LinearLayout.HORIZONTAL);
        //layt4.setGravity(Gravity.RIGHT);


        //tx groub
        tx1=add_text(ct,"loading..",String.valueOf(wid_mar-(wid_mar/10)),"w");
        tx1.setTextSize(20);
        tx1.setTextColor(Color.GRAY);
        tx1.setGravity(Gravity.LEFT);
        tx1.setId((int) 23);
        layt3=add_linear(ct,"w","w",0);
        layt3.setOrientation(LinearLayout.HORIZONTAL);
        layt3.setGravity(Gravity.LEFT);

        layt3.addView(tx1);


        bt1=add_button(ct,"X",String.valueOf(wid_mar/10),String.valueOf(wid_mar/10),0);
        bt1.setPadding(5,5,5,5);
        bt1.setTextSize(21);
        bt1.setClickable(true);
        bt1.setTag(layt_modal.getId());
        bt1.setBackgroundColor(Color.WHITE);
        bt1.setTextColor(Color.RED);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int v1=(int) v.getTag();
                View rot=(View) getrootview(v.getContext());
                View vc = (View) rot.findViewById(v1);
                remove(vc);
                ViewGroup rotv = (ViewGroup) getRoot_Content(v.getContext());
                show_all(rotv);
                //hide(v.getContext(),s1);
            }
        });

        layt2=add_linear(ct,"w","w",0);
        layt2.setOrientation(LinearLayout.VERTICAL);
        layt2.setGravity(Gravity.RIGHT);


        layt2.addView(bt1);
        layt4.addView(layt3);
        layt4.addView(layt2);

        layt_modal.addView(layt4);

        //////////
        //// loading proges
        final LinearLayout lg=add_linear(ct,"m",String.valueOf(wid_mar/4),10);
        lg.setGravity(Gravity.CENTER);
        ImageView circle=new ImageView(ct);
        LinearLayout.LayoutParams prm=new LinearLayout.LayoutParams(getparam_layout(String.valueOf(wid_mar/4)),getparam_layout(String.valueOf(wid_mar/4)));
        circle.setLayoutParams(prm);
        circle.setBackgroundColor(Color.TRANSPARENT);
        circle.setScaleType(ImageView.ScaleType.FIT_CENTER);
        circle.setBackground(ct.getResources().getDrawable(R.drawable.loading));

        lg.addView(circle);


        layt_modal.addView(lg);

        String cr=start_activity.URL_STR + "data/play/video.php?&api=1&v="+file;

        //////////////////////////////  vid
        t.print(cr);
        final VideoView videoView;
        //videoView = (VideoView) findViewById(R.id.videoView);
        videoView= new VideoView(ct);
        layt_modal.addView(videoView);
        final Context glob_ct2=glob_ct;
        videoView.setVideoPath(cr);
        videoView.start();
        MediaController mc=new MediaController(ct);
        mc.setEnabled(true);
        mc.setVisibility(View.VISIBLE);
        videoView.setMediaController(mc);

        final View cc=tx1;
        final TextView tte=tx1;
        final String sf2title=title;


        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                 mediaPlayer.start();
                tte.setText(sf2title);
                lg.setVisibility(View.GONE);
            }
        });

        hide_all(rotv);
        rotv.addView(layt_modal);
    }
    public static int getActionBarHeight(Context ct) {
        int actionBarHeight = 0;
        //OR as stated by @Marina.Eariel
        TypedValue tv = new TypedValue();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.HONEYCOMB){
            if (ct.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,ct.getResources().getDisplayMetrics());
        }else if(ct.getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)){
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, ct.getResources().getDisplayMetrics());
        }
        return actionBarHeight;
    }
    public static JSONObject get_searchjson(JSONArray jsonArray,String find,String col){
        String str="";
        JSONObject stdname = null;
            //JSONArray ar=(JSONArray) new JSONArray(json);
            int mx=jsonArray.length();
            print("it:"+mx);
            for(int i=0;i<mx;i++){
                if(stdname == null) {
                    try {
                        JSONObject jobj = jsonArray.getJSONObject(i);
                        String id = jobj.getString(col);
                        //print("x:"+id);
                        if ( id.equals(find) )  // compare your id here
                        {
                            stdname = jobj;
                            //getString("name");.toString();
                        }

                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        return stdname;
    }
    public static long hexToLong(String hex) {
        return Long.parseLong(hex, 16);
    }
    public static int findUnusedId(Context ct) {
        int fID=0;
        View vr=getRoot_Content(ct);
        while( vr.findViewById(++fID) != null );
        return fID;
    }

    public static void hide_all(ViewGroup rotv){
        int mx=rotv.getChildCount();
        print_int(mx);
        for(int i=0;i<mx;i++){
            View child=rotv.getChildAt(i);
            //your processing....
            child.setVisibility(View.GONE);
        }
    }
    public static void show_all(ViewGroup rotv){
        int mx=rotv.getChildCount();
        print_int(mx);
        for(int i=0;i<mx;i++){
            View child=rotv.getChildAt(i);
            //your processing....
            child.setVisibility(View.VISIBLE);
        }
    }
    public static View getRoot_Content(Context ct){
        View rotv  = ((Activity) ct).getWindow().getDecorView().findViewById(android.R.id.content);
        return rotv;
    }
    public static View getrootview(Context ct){
        View rootView = ((Activity) ct).getWindow().getDecorView();
        return rootView;
    }
    public static void remove(View entry){
        ((ViewManager)entry.getParent()).removeView(entry);
    };
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

    public static int getparam_layout(String s1){
        int pa1 = -2;
        if(isStringInt(s1)){
            pa1=Integer.parseInt(s1);
        }else{
            if(s1.equals("m")){
                pa1=LinearLayout.LayoutParams.MATCH_PARENT;
            }else if(s1.equals("w")){
                pa1=LinearLayout.LayoutParams.WRAP_CONTENT;
            }
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

    public static TextView add_text2(Context ct,String tx,String s1,String s2,int gravity,int pad,int color){
        int p1 = getparam_layout(s1);
        int p2 = getparam_layout(s2);
        TextView gtx = new TextView(ct);
        gtx.setLayoutParams(new LinearLayout.LayoutParams(p1, p2,1f));
        gtx.setText(tx);
        gtx.setTextColor(color);
        gtx.setGravity(gravity);
        gtx.setPadding(pad,pad,pad,pad);
        return (TextView) gtx;
    }

    public static LinearLayout add_linear(Context ct,String s1,String s2,int mar){
        LinearLayout gtx = new LinearLayout(ct);
        int p1 = getparam_layout(s1);
        int p2 = getparam_layout(s2);
        LinearLayout.LayoutParams prm=new LinearLayout.LayoutParams(p1, p2);
        prm.setMargins(mar,mar,mar,mar);
        gtx.setLayoutParams(prm);

        return (LinearLayout) gtx;
    }
    public static TableLayout add_table(Context ct,String s1,String s2,int mar) {
        TableLayout gtx = new TableLayout(ct);
        int p1 = getparam_layout(s1);
        int p2 = getparam_layout(s2);
        TableLayout.LayoutParams prm = new TableLayout.LayoutParams(p1, p2);
        prm.setMargins(mar, mar, mar, mar);
        gtx.setLayoutParams(prm);
        gtx.setStretchAllColumns(true);
        gtx.setShrinkAllColumns(false);
        return (TableLayout) gtx;
    }
    public static TextView ad_celltext(TableRow tr,Context ct,String s1,int padd,int gr,Drawable border,int color){
        TextView gt;
        LinearLayout lt;

        gt=new TextView(ct);
        gt.setText(s1);
        gt.setGravity(gr);
        gt.setPadding(padd,padd,padd,padd);
        gt.setBackground(border);
        gt.setTextColor(color);

        tr.addView(gt);
        return gt;
    }
    public static TableRow add_table_row(Context ct, String s1, String s2, int mar) {
        TableRow gtx = new TableRow(ct);
        int p1 = getparam_layout(s1);
        int p2 = getparam_layout(s2);
        TableRow.LayoutParams prm = new TableRow.LayoutParams(p1, p2);
        prm.setMargins(mar, mar, mar, mar);
        gtx.setLayoutParams(prm);
        return (TableRow) gtx;
    }
    public static Button add_button(Context ct,String tx,String s1,String s2,int mar){
        Button bt= new Button(ct);
        int p1 = getparam_layout(s1);
        int p2 = getparam_layout(s2);

        LinearLayout.LayoutParams prm=new LinearLayout.LayoutParams(p1, p2);
        prm.setMargins(mar,mar,mar,mar);
        bt.setLayoutParams(prm);
        bt.setText(tx);

        return (Button) bt;
    }

    public static ImageButton add_imgbutton(Context ct,String url, String s1, String s2,int mar){
        ImageButton bt= new ImageButton(ct);
        int p1 = getparam_layout(s1);
        int p2 = getparam_layout(s2);
        LinearLayout.LayoutParams prm=new LinearLayout.LayoutParams(p1, p2);
        prm.setMargins(mar,mar,mar,mar);
        bt.setLayoutParams(prm);
        bt.setAdjustViewBounds(true);
        bt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        bt.setPadding(mar,mar,mar,mar);
        //bt.setBackground(ct.getResources().getDrawable(R.drawable.ic_menu_camera));
        new t.DownloadImageTask(bt).execute(url);

        return (ImageButton) bt;
    }

    public static ImageView add_img_url(Context ct,String url,String s1,String s2){
        ImageView img= new ImageView(ct);
        int p1 = getparam_layout(s1);
        int p2 = getparam_layout(s2);
        LinearLayout.LayoutParams prm=new LinearLayout.LayoutParams(p1, p2);
        img.setLayoutParams(prm);

        new t.DownloadImageTask(img).execute(url);

        return (ImageView) img;
    };

    public static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }
        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            if (mIcon11 != null) {
                return mIcon11;
            }else{
                return null;
            }
        }
        protected void onPostExecute(Bitmap result){
            bmImage.setImageBitmap(result);
            logo=result;
        }
    }

    public static int get_width(Context act){
        Activity actt= getActivity(act);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        actt.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    };

    public static int get_height(Context act){
        Activity actt= getActivity(act);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        actt.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    };

    public static int color(String s1){
        return Color.parseColor(s1);
    }

    public static class BooVariable {
        private boolean boo = false;
        private ChangeListener listener;

        public boolean isBoo() {
            return boo;
        }

        public void setBoo(boolean boo) {
            this.boo = boo;
            if (listener != null) listener.onChange();
        }

        public ChangeListener getListener() {
            return listener;
        }

        public void setListener(ChangeListener listener) {
            this.listener = listener;
        }

        public interface ChangeListener {
            void onChange();
        }
    }

}

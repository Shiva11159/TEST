package com.example.myapplication.ReusableLogics;

import static android.content.Context.MODE_PRIVATE;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.TeamSquadAdapter;
import com.example.myapplication.Datasets.TeamsInnings;
import com.example.myapplication.Datasets.TeamsSquad;
import com.example.myapplication.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Logics {

    public static ArrayList<String> arrayListTeamnames=new ArrayList<>();
    public  static ArrayList<String> arrayListNuggets=new ArrayList<>();
    public  static ArrayList<TeamsSquad> teamsSquadArrayList=new ArrayList<>();
    public static ArrayList<TeamsInnings> teamsInningsArrayList=new ArrayList<>();

//    arrayListTeamnames = new ArrayList<>();
//    arrayListNuggets = new ArrayList<>();
//    teamsSquadArrayList = new ArrayList<>();
//    Logics.teamsInningsArrayList = new ArrayList<>();

    //shivatumma 28 may 2023.

    // saving team info data into arraylist ..
    public static void saveTeaminfoData(Context context, String match, String date, String time, String toss, String venue, String umpire,String umpire3rd,String refree) {
        SharedPreferences.Editor sharedPreferences = context.getSharedPreferences(Const.teamInfo, MODE_PRIVATE).edit();
        sharedPreferences.putString(Const.match, match);
        sharedPreferences.putString(Const.date, date);
        sharedPreferences.putString(Const.time, time);
        sharedPreferences.putString(Const.toss, toss);
        sharedPreferences.putString(Const.venue, venue);
        sharedPreferences.putString(Const.umpire, umpire);
        sharedPreferences.putString(Const.umpire3rd, umpire3rd);
        sharedPreferences.putString(Const.refree, refree);
        sharedPreferences.apply();
    }


    // retriving and set data into textview ...
    public static ArrayList<String> getTeaminfoData(Context context) {

        ArrayList<String> teaminfoArraylist = new ArrayList<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences(Const.teamInfo, MODE_PRIVATE);
        String match = sharedPreferences.getString(Const.match, null);
        String date = sharedPreferences.getString(Const.date, null);
        String time = sharedPreferences.getString(Const.time, null);
        String toss = sharedPreferences.getString(Const.toss, null);
        String venue = sharedPreferences.getString(Const.venue, null);
        String umpire = sharedPreferences.getString(Const.umpire, null);
        String umpire3rd = sharedPreferences.getString(Const.umpire3rd, null);
        String refree = sharedPreferences.getString(Const.refree, null);

        teaminfoArraylist.add(match);
        teaminfoArraylist.add(date);
        teaminfoArraylist.add(time);
        teaminfoArraylist.add(toss);
        teaminfoArraylist.add(venue);
        teaminfoArraylist.add(umpire);
        teaminfoArraylist.add(umpire3rd);
        teaminfoArraylist.add(refree);

        return teaminfoArraylist;
    }


    public static void saveLogsArrayList(ArrayList<TeamsSquad> list, Context activity,String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }
    public static void saveLogsArrayList1(ArrayList<TeamsInnings> list, Context activity, String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(key, json);
        editor.apply();     // This line is IMPORTANT !!!
    }

    public static ArrayList<TeamsSquad> getLogsArrayList(Context activity,String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<TeamsSquad>>() {}.getType();
        return gson.fromJson(json, type);
    }
    public static ArrayList<TeamsInnings> getLogsArrayList1(Context activity,String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        Gson gson = new Gson();
        String json = prefs.getString(key, null);
        Type type = new TypeToken<ArrayList<TeamsInnings>>() {}.getType();
        return gson.fromJson(json, type);
    }
    public static void clearLogsArrayList(ArrayList<TeamsSquad>arrayList,Context activity,String key){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = prefs.edit();
        editor.remove(key);
        editor.apply();     // This line is IMPORTANT !!!
        arrayList.clear();
    }

   static SpannableStringBuilder builder = new SpannableStringBuilder();
    public static SpannableStringBuilder spannableString(String string,int i){
        builder.clear();
        SpannableString redSpannable= new SpannableString(string);
        if (i==0){
            redSpannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, string.length(), 0);
        }else {
            redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, string.length(), 0);
        }
        builder.append(redSpannable);
        return builder;

    }


    public static String getVersionInfo(Context context) {
        String versionName = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Log.d("versionName", "getVersionInfo: " + versionName);
        return versionName;

    }

    public static void runAnimation(RecyclerView recyclerView, TeamSquadAdapter teamSquadAdapter,Context context) {
        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, R.anim.left_to_right);
        recyclerView.setLayoutAnimation(controller);
        teamSquadAdapter.notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}

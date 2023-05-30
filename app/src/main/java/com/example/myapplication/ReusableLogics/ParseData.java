package com.example.myapplication.ReusableLogics;

import static com.example.myapplication.ReusableLogics.Logics.arrayListTeamnames;
import static com.example.myapplication.ReusableLogics.Logics.teamsInningsArrayList;
import static com.example.myapplication.ReusableLogics.Logics.teamsSquadArrayList;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.Datasets.TeamsInnings;
import com.example.myapplication.Datasets.TeamsSquad;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseData {

    public static void parseJsonTeams(JSONObject Teams, Context context, ArrayList<TeamsSquad>teamsSquadArrayList, TextView textView1,TextView textview2) {
        //Teams tag..
        try {
            //
            JSONArray array = Teams.names(); // contains all the keys inside Data
            // now loop the array
            teamsSquadArrayList.clear();
            Logics.arrayListTeamnames.clear();
            for (int i = 0; i < array.length(); i++) {
                String key = array.getString(i); //
                JSONObject obj = Teams.getJSONObject(key); //  contains the JSONObject of the key

                Const.Name_Full = obj.getString("Name_Full"); //IND
                String Name_Short = obj.getString("Name_Short");

                Logics.arrayListTeamnames.add(Name_Short);

                Log.e("arrayListTeamnames", arrayListTeamnames.toString());
                JSONObject Players = obj.getJSONObject("Players"); //size 11 .
                JSONArray array2 = Players.names(); // contains all the keys inside Data

                for (int j = 0; j < array2.length(); j++) {
                    Const.key1 = array2.getString(j); // 42 or 365 for your players code
                    JSONObject obj1 = Players.getJSONObject(Const.key1); //  contains the JSONObject of the key 42 or 365

                    Const.Position = obj1.getString("Position");
                    Const.NameFull = obj1.getString("Name_Full");

                    if (obj1.has("Iscaptain")) {
                        Const.Iscaptain = obj1.getString("Iscaptain");
                    } else {
                        Const.Iscaptain = "";
                    }

                    if (obj1.has("Iskeeper")) {
                        Const.Iskeeper = obj1.getString("Iskeeper");
                    } else {
                        Const.Iskeeper = "";
                    }

                    JSONObject battingObj = obj1.getJSONObject("Batting");

                    Const.Stylebat = battingObj.getString("Style");
                    Const.Averagebat = battingObj.getString("Average");
                    Const.Strikeratebat = battingObj.getString("Strikerate");
                    Const.Runsbat = battingObj.getString("Runs");

//
                    JSONObject bowlingObj = obj1.getJSONObject("Bowling");
                    Log.e("bowlingObj " + Const.Position, String.valueOf(bowlingObj));

                    Const.Stylebowl = bowlingObj.getString("Style");
                    Const.Averagebowl = bowlingObj.getString("Average");
                    Const.Economyrate = bowlingObj.getString("Economyrate");
                    Const.Wickets = bowlingObj.getString("Wickets");

                    TeamsSquad modelTeamsSquad = new TeamsSquad(Name_Short, Const.key1, Const.Position, Const.NameFull, Const.Iscaptain, Const.Iskeeper, Const.Stylebat, Const.Averagebat, Const.Strikeratebat, Const.Runsbat, Const.Stylebowl, Const.Averagebowl, Const.Economyrate, Const.Wickets);
                    teamsSquadArrayList.add(modelTeamsSquad);
                }

            }

            Logics.saveLogsArrayList(teamsSquadArrayList, context, Const.teamsSquad);

            // matches name.

            textView1.setText(Logics.arrayListTeamnames.get(0));
            textview2.setText(Logics.arrayListTeamnames.get(1));


        } catch (Exception e) {
            Log.e("Team Excptn", e.getMessage());
        }

    }

    public static void parseJsonNuggets(JSONArray Nuggets) {
        try {
            for (int i = 0; i < Nuggets.length(); i++) {
                String value = Nuggets.get(i).toString();
                Log.e("value", value);

                Logics.arrayListNuggets.add(value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void parseJsonInnings(JSONArray innings,Context context) {
        try {

            teamsInningsArrayList.clear();
            for (int j = 0; j < innings.length(); j++) {

                JSONObject jsonObject1 = innings.getJSONObject(j);

                JSONArray Batsmen = jsonObject1.getJSONArray("Batsmen"); // ouside innings runs balls 4s 6s -shiva2

                for (int i = 0; i < Batsmen.length(); i++) {
                    JSONObject object = Batsmen.getJSONObject(i);
                    Log.e("objectobject "+i, String.valueOf(object));
                    String Batsman = object.getString("Batsman");// batsman code
                    String Runs = object.getString("Runs");
                    String Balls = object.getString("Balls");
                    String Fours = object.getString("Fours");
                    String Sixes = object.getString("Sixes");
                    String Dots = object.getString("Dots");
                    String Strikerate = object.getString("Strikerate");
                    String Dismissal = object.getString("Dismissal");
                    String Howout = object.getString("Howout");
                    String Bowler = object.getString("Bowler");
                    String Fielder = object.getString("Fielder");

                    Log.e("Fielder ",Fielder );
                    TeamsInnings teamsInnings=new TeamsInnings(Batsman,Runs,Balls,Fours,Sixes,Dots,Strikerate,Dismissal,Howout,Bowler,Fielder);
                    teamsInningsArrayList.add(teamsInnings);
                }

                Logics.saveLogsArrayList1(teamsInningsArrayList,context, Const.teamsInnings);

            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("exception",e.getMessage() );
        }
    }

}

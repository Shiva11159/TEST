package com.example.myapplication.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Datasets.TeamsSquad;
import com.example.myapplication.Interfaces.CallBack;
import com.example.myapplication.R;
import com.example.myapplication.ReusableLogics.Logics;

import java.util.ArrayList;


public class TeamSquadAdapter extends RecyclerView.Adapter<TeamSquadAdapter.ViewHolder> {

    ArrayList<TeamsSquad> teamsSquadArrayList;
    Context context;

    String strballstyle="";
    CallBack callBack;

    LinearLayout linearlayout;

    public TeamSquadAdapter(ArrayList<TeamsSquad> clientlistDataArrayList, Context context, CallBack callBack) {
        this.teamsSquadArrayList = clientlistDataArrayList;
        this.context = context;
        this.callBack=callBack;

    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutteamssquad, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        try {
            holder.txtSquadName.setText(teamsSquadArrayList.get(position).getNameFull()); // player name ..eg rohit.
            holder.txtteamname.setText(teamsSquadArrayList.get(position).getName_Full()); //IND PAK - eg:>>>

            if (teamsSquadArrayList.get(position).getIscaptain().contains("true")){
                holder.txtSquadtype.setText(Logics.spannableString("(C)",0), TextView.BufferType.SPANNABLE);
            }else if (teamsSquadArrayList.get(position).getIskeeper().contains("true")){
                holder.txtSquadtype.setText(Logics.spannableString("(WK)",1), TextView.BufferType.SPANNABLE);
            }else {
                holder.txtSquadtype.setText("");
            }

            holder.linearlayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        callBack.getplayercode(battingstylmethod(teamsSquadArrayList,position),ballstylemethod(teamsSquadArrayList,position),teamsSquadArrayList.get(position).getNameFull());
                    }catch (Exception e){
                        Log.e("team squad", e.getMessage());
                    }

                }
            });
        } catch (Exception e) {
            Log.e("team squad excpetion", e.getMessage());
        }

    }

    private String battingstylmethod(ArrayList<TeamsSquad>arrayList,int position) {
        String strBatting="";
        // batting.
        if (teamsSquadArrayList.get(position).getStylebat().contains("RHB")){
            strBatting="right-handed";
        }else
        if (teamsSquadArrayList.get(position).getStylebat().contains("LHB")){
            strBatting="left-handed";
        }
        return strBatting;
    }

    private String ballstylemethod(ArrayList<TeamsSquad> teamsSquadArrayList, int position) {

        if (teamsSquadArrayList.get(position).getStylebowl().contains("RF")|| (teamsSquadArrayList.get(position).getStylebowl().contains("RAF"))){
            strballstyle="Right-arm fast";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("RFM")||(teamsSquadArrayList.get(position).getStylebowl().contains("RAFM"))){
            strballstyle="Right-arm fast-medium";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("RMF")||(teamsSquadArrayList.get(position).getStylebowl().contains("RAMF"))){
            strballstyle="Right-arm medium-fast";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("RAM")||(teamsSquadArrayList.get(position).getStylebowl().contains("RM"))){
            strballstyle="Right-arm medium";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("RAMS")||(teamsSquadArrayList.get(position).getStylebowl().contains("RMS"))){
            strballstyle="Right-arm medium-slow";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("RSM")||(teamsSquadArrayList.get(position).getStylebowl().contains("RASM"))){
            strballstyle="Right-arm slow-medium";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("RS")|| (teamsSquadArrayList.get(position).getStylebowl().contains("RAS"))){
            strballstyle="Right-arm slow";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("LF")||(teamsSquadArrayList.get(position).getStylebowl().contains("LAF"))){
            strballstyle="Left-arm fast";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("LFM")||(teamsSquadArrayList.get(position).getStylebowl().contains("LAFM"))){
            strballstyle="Left-arm fast-medium";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("LMF")||(teamsSquadArrayList.get(position).getStylebowl().contains("LAMF"))){
            strballstyle="Left-arm medium-fast";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("LM")||(teamsSquadArrayList.get(position).getStylebowl().contains("LAM"))){
            strballstyle="Left-arm medium";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("LMS")||(teamsSquadArrayList.get(position).getStylebowl().contains("LAMS"))){
            strballstyle="Left-arm medium-slow";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("LSM")||(teamsSquadArrayList.get(position).getStylebowl().contains("LASM"))){
            strballstyle="Left-arm slow-medium";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("LS")||teamsSquadArrayList.get(position).getStylebowl().contains("LAS")){
            strballstyle="Left-arm slow";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("OB")){
            strballstyle="Off break";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("LB")){
            strballstyle="Leg break";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("LBG")){
            strballstyle="Leg break googly";
        }else if (teamsSquadArrayList.get(position).getStylebowl().contains("")){
            strballstyle="--";
        }

        return strballstyle;
    }

    @Override
    public int getItemCount() {
        return teamsSquadArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtSquadName;
        TextView txtSquadtype;
        TextView txtteamname;

        LinearLayout linearlayout;
        public ViewHolder(View itemView) {
            super(itemView);
            try {
                txtSquadName =itemView.findViewById(R.id.txtSquadName);
                txtSquadtype =  itemView.findViewById(R.id.txtSquadtype);
                txtteamname =  itemView.findViewById(R.id.txtteamname);
                linearlayout = itemView.findViewById(R.id.linearlayout);
            } catch (Exception e) {
                Log.e("team squad excpetion", e.getMessage());
            }
        }
    }


}
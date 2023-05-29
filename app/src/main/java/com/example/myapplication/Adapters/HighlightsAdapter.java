package com.example.myapplication.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Datasets.TeamUpdates;
import com.example.myapplication.Datasets.TeamsSquad;
import com.example.myapplication.Interfaces.CallBack;
import com.example.myapplication.R;
import com.example.myapplication.ReusableLogics.Logics;

import java.util.ArrayList;

public class HighlightsAdapter extends RecyclerView.Adapter<HighlightsAdapter.ViewHolder> {

    ArrayList<TeamUpdates> teamUpdatesArrayList;
    Context context;

    String strballstyle="";
    CallBack callBack;

    LinearLayout linearlayout;

    public HighlightsAdapter(ArrayList<TeamUpdates> teamUpdatesArrayList, Context context) {
        this.teamUpdatesArrayList = teamUpdatesArrayList;
        this.context = context;
    }

    @NonNull

    @Override
    public HighlightsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutteamsupdates, null);
        HighlightsAdapter.ViewHolder viewHolder = new HighlightsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull HighlightsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        try {
            holder.txtupdates.setText(" * "+teamUpdatesArrayList.get(position).getValues());

        } catch (Exception e) {
            Log.e("team squad excpetion", e.getMessage());
        }

    }


    @Override
    public int getItemCount() {
        return teamUpdatesArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtupdates;
        LinearLayout linearlayout;
        public ViewHolder(View itemView) {
            super(itemView);
            try {
                txtupdates =itemView.findViewById(R.id.txtupdates);
                linearlayout = itemView.findViewById(R.id.linearlayout);
            } catch (Exception e) {
                Log.e("team squad excpetion", e.getMessage());
            }
        }
    }
}

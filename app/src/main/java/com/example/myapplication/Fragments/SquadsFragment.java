package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.TeamSquadAdapter;
import com.example.myapplication.Datasets.TeamsInnings;
import com.example.myapplication.Datasets.TeamsSquad;
import com.example.myapplication.Interfaces.CallBack;
import com.example.myapplication.R;
import com.example.myapplication.ReusableLogics.Const;
import com.example.myapplication.ReusableLogics.Logics;
import com.example.myapplication.playerstyleDlg;

import java.util.ArrayList;


public class SquadsFragment extends Fragment implements CallBack {
    View view;
    ArrayList<TeamsSquad>teamsSquadArrayList;
    ArrayList<TeamsInnings>teamsInningArrayList;
    RecyclerView recyclview;
    TeamSquadAdapter teamSquadAdapter;
    CallBack callBack;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.squadfragment, container, false);
        teamsSquadArrayList=Logics.getLogsArrayList(getActivity(), Const.teamsSquad);

        recyclview=view.findViewById(R.id.recyclview);

        callBack=(CallBack)this;
        teamSquadAdapter = new TeamSquadAdapter(teamsSquadArrayList, getActivity(),callBack);
        recyclview.setVisibility(View.VISIBLE);
        recyclview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclview.setAdapter(teamSquadAdapter);
//        Log.e("onCreateView: ", String.valueOf(teamsInningArrayList.size()));


        Logics.runAnimation(recyclview,teamSquadAdapter,getActivity());

        return view;
    }

    @Override
    public void getplayercode(String battingstyle,String ballingstyle,String teamname) {
        try {
            playerstyleDlg scoreCardDlg= playerstyleDlg.newInstance(getActivity(),battingstyle,ballingstyle,teamname);
            scoreCardDlg.show(getActivity().getSupportFragmentManager(), "Dialog Fragment");
        }catch (Exception e){
            Log.e( "exception scorecard: ",e.getMessage());
        }
    }
}




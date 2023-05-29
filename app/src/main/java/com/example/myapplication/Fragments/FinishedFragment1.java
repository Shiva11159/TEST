package com.example.myapplication.Fragments;

import static com.example.myapplication.ReusableLogics.Logics.arrayListNuggets;
import static com.example.myapplication.ReusableLogics.Logics.teamsSquadArrayList;
import static com.example.myapplication.ReusableLogics.ParseData.parseJsonInnings;
import static com.example.myapplication.ReusableLogics.ParseData.parseJsonNuggets;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapters.HighlightsAdapter;
import com.example.myapplication.Datasets.TeamUpdates;
import com.example.myapplication.Datasets.TeamsInnings;
import com.example.myapplication.Datasets.TeamsSquad;
import com.example.myapplication.Interfaces.CallBack;
import com.example.myapplication.MainActivity2;
import com.example.myapplication.NetworkCall.RequestInterface;
import com.example.myapplication.NetworkCall.RetrofitClientInstance;
import com.example.myapplication.R;
import com.example.myapplication.ReusableLogics.Const;
import com.example.myapplication.ReusableLogics.Logics;
import com.example.myapplication.ReusableLogics.ParseData;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FinishedFragment1 extends Fragment {
    String err = "";
    View view;
    ProgressBar progressBar;
    TextView txt_location1, txt_result, txt_league, txt_team1, txt_team2,txthightlight;
    CardView cardview,cardviewhighlight;

    Call<JsonObject> call;
    static int i = 0;

    RecyclerView recyclview;

    HighlightsAdapter highlightsAdapter;

    ArrayList<TeamUpdates> teamUpdatesArrayList;

    public static FinishedFragment newInstance(int ii) {
        FinishedFragment fragment = new FinishedFragment();
        i = ii;
        return fragment;
    }


//    public FinishedFragment() {
//
//    }

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
        view = inflater.inflate(R.layout.finishedfragment1, container, false);

        init_();
        NetworkCall();

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                intent.putExtra("team1", Logics.arrayListTeamnames.get(0));
                intent.putExtra("team2", Logics.arrayListTeamnames.get(1));
                getActivity().startActivity(intent);
            }
        });

        return view;
    }

    private void init_() {

        progressBar = view.findViewById(R.id.progressBar);
        recyclview = view.findViewById(R.id.recyclview);
        txthightlight = view.findViewById(R.id.txthighlight);
        cardviewhighlight = view.findViewById(R.id.cardviewhighlight);

        txt_location1 = view.findViewById(R.id.txtlocation1);
        txt_result = view.findViewById(R.id.txtresult);
        txt_league = view.findViewById(R.id.txtLeague);
        txt_team1 = view.findViewById(R.id.txtTeam1);
        txt_team2 = view.findViewById(R.id.txTeam2);
        cardview = view.findViewById(R.id.cardview1);
        cardview.setVisibility(View.GONE);

    }

    void NetworkCall() {
        progressBar.setVisibility(View.VISIBLE);
        cardviewhighlight.setVisibility(View.GONE);
        txthightlight.setVisibility(View.GONE);

        RequestInterface request = RetrofitClientInstance.getRetrofitInstance().create(RequestInterface.class);

        call = request.getNewIndDataIndNZ();

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.e("onResponse: ", String.valueOf(response.body()));
                try {

                    if (response.isSuccessful()) {
                        try {
                            progressBar.setVisibility(View.GONE);
                            cardviewhighlight.setVisibility(View.VISIBLE);
                            txthightlight.setVisibility(View.VISIBLE);
                            cardview.setVisibility(View.VISIBLE);
                            String resp = response.body().toString();
                            JSONObject jsonObject = new JSONObject(resp);
                            JSONObject matchdetailObj = jsonObject.getJSONObject("Matchdetail");

                            JSONObject matchObj = matchdetailObj.getJSONObject("Match");
                            String League = matchObj.getString("League");
                            String Type = matchObj.getString("Type");
                            String Date = matchObj.getString("Date");
                            String Time = matchObj.getString("Time");

                            JSONObject venueObj = matchdetailObj.getJSONObject("Venue");
                            String Nameven = venueObj.getString("Name");

                            txt_location1.setText(Nameven);
                            txt_league.setText(League);

                            JSONObject officials = matchdetailObj.getJSONObject("Officials");

                            String Umpires = officials.getString("Umpires");
                            String Referee = officials.getString("Referee");

                            String Result = matchdetailObj.getString("Result");
                            txt_result.setText(Result);

                            JSONArray Nuggets = jsonObject.getJSONArray("Nuggets");
                            JSONArray Innings = jsonObject.getJSONArray("Innings");
                            JSONObject Teams = jsonObject.getJSONObject("Teams");

                            Log.e("Nuggets", Nuggets.toString());
                            // notes tag .
                            Logics.arrayListNuggets.clear();
                            parseJsonNuggets(Nuggets);
                            parseJsonInnings(Innings, getActivity());
                            ParseData.parseJsonTeams(Teams, getActivity(), teamsSquadArrayList, txt_team1, txt_team2);
                            Logics.saveTeaminfoData(getActivity(), Type, Date, Time, arrayListNuggets.get(0), Nameven, Umpires, Umpires, Referee);

                            try {
                                if (arrayListNuggets.size() > 0) {
                                    Log.e("nugget: ", "data");

                                    Updates();
                                } else {
                                    Log.e("nugget: ", "nodata");
                                }
                            } catch (Exception exception) {
                                Log.e("exception", exception.getMessage());
                            }
                        } catch (Exception e) {
                            progressBar.setVisibility(View.GONE);
                            Log.e("exception", e.getMessage());
                        }
                    } else {
                        switch (response.code()) {
                            case 404:
//                            Toast.makeText(context, "not found", Toast.LENGTH_SHORT).show();
                                err = "Server Not Found";
                                break;
                            case 500:
//                            Toast.makeText(context, "server broken", Toast.LENGTH_SHORT).show();
                                err = "Server Unavailable";
                                break;
                            case 503:
//                            Toast.makeText(context, "server broken", Toast.LENGTH_SHORT).show();
                                err = "Server Overloaded try after sometime";
                                break;
                            default:
                                err = String.valueOf(response.code());
                                err = "Something went wrong try again.";
//                            Toast.makeText(context, "unknown error", Toast.LENGTH_SHORT).show();
                                break;
                        }

                        Toast.makeText(getActivity(), err, Toast.LENGTH_SHORT).show();
                    }

                } catch (Exception e) {
                    Log.e("exception", e.getMessage());
                }

            }


            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

                progressBar.setVisibility(View.GONE);
                Log.e("onResponse: ", String.valueOf(t.toString()));
            }
        });


    }

    private void Updates() {
        teamUpdatesArrayList = new ArrayList<>();
        teamUpdatesArrayList.clear();

        for (int i = 0; i < Logics.arrayListNuggets.size(); i++) {
            String updates = Logics.arrayListNuggets.get(i);
            TeamUpdates teamUpdates = new TeamUpdates(updates);
            teamUpdatesArrayList.add(teamUpdates);
        }

        highlightsAdapter = new HighlightsAdapter(teamUpdatesArrayList, getActivity());
        recyclview.setVisibility(View.VISIBLE);
        recyclview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclview.setAdapter(highlightsAdapter);

    }


}



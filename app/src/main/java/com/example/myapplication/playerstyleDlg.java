package com.example.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class playerstyleDlg extends DialogFragment {

    static playerstyleDlg gstDlg;
    static Activity ctx;
    static String playername_;
    static String battingstyle_;
    static String ballingstyle_;

    TextView txtclose, txtbowlingstyle, txtbattingstyle,txtplayername;

    public static playerstyleDlg newInstance(Activity context, String battingstyle, String ballingstyle, String playername) {
        gstDlg = new playerstyleDlg();
        ctx = context;
        battingstyle_ = battingstyle;
        ballingstyle_ = ballingstyle;
        playername_ = playername;
        return gstDlg;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        setStyle(DialogFragment.STYLE_NO_FRAME,
//                android.R.style.Theme_Material_Light);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_playerstyle, container, false);
        getDialog().setCanceledOnTouchOutside(false);

        txtclose = rootView.findViewById(R.id.txtclose);
        txtplayername = rootView.findViewById(R.id.txtplayername);
        txtbattingstyle = rootView.findViewById(R.id.txtbattingstyle);
        txtbowlingstyle = rootView.findViewById(R.id.txtbowlingstyle);

        txtbattingstyle.setText(battingstyle_);
        txtbowlingstyle.setText(ballingstyle_);
        txtplayername.setText(playername_);

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //style id

        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
        }
    }
}

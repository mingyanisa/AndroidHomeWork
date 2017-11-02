package com.example.admin.androidhomework.fragment;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.androidhomework.R;
import com.example.admin.androidhomework.activity.MainActivity;

import java.util.Date;

/**
 * Created by admin on 11/2/2017 AD.
 */

public class DetailFragment extends Fragment implements View.OnClickListener {
    Button btnclose;
    ImageView img;
    TextView descript;
    TextView header;
    int mode;
    public static final int FIRST_ORDER=1;
    public static final int RESISTANCE=2;


    public static DetailFragment newInstance(int mode){
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("mode",mode);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail,container,false);
        initInstance(rootView);
        return rootView;
    }
    private void initInstance(View rootView) {

        btnclose = (Button)rootView.findViewById(R.id.btnClose);
        descript = (TextView) rootView.findViewById(R.id.description);
        img = (ImageView)rootView.findViewById(R.id.img);
        header = (TextView) rootView.findViewById(R.id.header);
        btnclose.setOnClickListener(this);
        if(this.getArguments().getInt("mode")==FIRST_ORDER){
            setFirstOrder();
        }else {
            setResistance();
        }

    }
    public void setResistance(){
        descript.setText("The Resistance was a small military force founded by Leia Organa " +
                " to combat the First Order. The origins of the Resistance," +
                " which took inspiration from the Alliance to Restore the Republic, " +
                " dated to the end of the Galactic Civil War, when the New Republic passed " +
                " the Military Disarmament Act in the wake of the signing of the Galactic Concordance with the Galactic Empire.");

            img.setImageResource(R.drawable.rey);
        header.setText("The Resistance");
    }
    public void setFirstOrder(){
        descript.setText("The First Order was a political and military faction" +
                        "-ruled by Supreme Leader Snoke and allied with the Knights of Ren" +
                "-that came into existence as a result of the fall of the Galactic Empire.");

                img.setImageResource(R.drawable.phasma);
        header.setText("The First Order");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        if(view==btnclose){
            MainActivity.getInstance().detailClose(this);
        }
    }
}

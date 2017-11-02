package com.example.admin.androidhomework.fragment;

import android.animation.Animator;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.admin.androidhomework.R;
import com.example.admin.androidhomework.activity.MainActivity;

/**
 * Created by admin on 11/2/2017 AD.
 */

public class MainFragment extends Fragment implements View.OnClickListener {
    Button btnStart;
    ImageButton btnFirstOrder;
    ImageButton btnResistance;
    TextView result;
    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
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
        View rootView = inflater.inflate(R.layout.fragment_main,container,false);
        initInstance(rootView);
        return rootView;
    }

    private void initInstance(View rootView) {
    //FIND viewById here
        btnStart = (Button) rootView.findViewById(R.id.btnStart);
        btnFirstOrder = (ImageButton) rootView.findViewById(R.id.firstOrder);
        btnResistance = (ImageButton)rootView.findViewById(R.id.resistance);
        result = (TextView) rootView.findViewById(R.id.result);
        btnFirstOrder.setOnClickListener(this);
        btnResistance.setOnClickListener(this);
        btnStart.setOnClickListener(this);
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
        if (view == btnFirstOrder){
            MainActivity.getInstance().detailPopup(DetailFragment.FIRST_ORDER);
        }
        if (view ==btnResistance){
            MainActivity.getInstance().detailPopup(DetailFragment.RESISTANCE);
        }
        if(view==btnStart){
            int random = (int) ((Math.random()+1)*20);

            final int color[]={R.drawable.shape_round_rect_button_red,R.drawable.shape_round_rect_button_yellow};

            if(random%2==0){

                btnFirstOrder.setBackgroundResource(R.drawable.shape_round_rect_button_yellow);
                btnResistance.setBackgroundResource(R.drawable.shadow);
                result.setText("You are \n The First Order!");

                Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_fade_in);
                result.startAnimation(anim);
            }else{
                btnResistance.setBackgroundResource(R.drawable.shape_round_rect_button_yellow);
                btnFirstOrder.setBackgroundResource(R.drawable.shadow);

                result.setText("You are \n The Resistance!");

                Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.zoom_fade_in);
                result.startAnimation(anim);
            }

        }

    }
}


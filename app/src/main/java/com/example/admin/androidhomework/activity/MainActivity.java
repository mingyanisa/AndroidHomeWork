package com.example.admin.androidhomework.activity;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.androidhomework.R;
import com.example.admin.androidhomework.fragment.DetailFragment;
import com.example.admin.androidhomework.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
    public static MainActivity instance;
    public static MainActivity getInstance(){
        return instance;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_main);
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.zoom_fade_in,R.anim.zoom_fade_out)
                    .add(R.id.contentContainer, MainFragment.newInstance(),"MainFragment")
                    .commit();

        }
    }
    public void detailPopup(int mode){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.zoom_fade_in,R.anim.zoom_fade_out)
                .add(R.id.contentContainer, DetailFragment.newInstance(mode),"DetailFragment")
                .commit();

    }
public void detailClose(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .remove(fragment)
                .commit();

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


    }


}

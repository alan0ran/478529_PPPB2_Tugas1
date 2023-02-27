package com.example.a478529_pppb2_tugas1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private Boolean isFragmentDisplayed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openFragment();

        mButton = findViewById(R.id.open_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFragmentDisplayed){
                    displayFragment();
                } else {
                    closeFragment();
                }
            }
        });

    }
    public void openFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        MainFragment mainFragment = MainFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFragment, mainFragment).addToBackStack(null).commit();
    }
    public void displayFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        MainFragment mainFragment = (MainFragment) fragmentManager.findFragmentById(R.id.mainFragment);
        if (mainFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(mainFragment).commit();
        }

        SimpleFragment simpleFragment = SimpleFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.simpleFragment, simpleFragment).addToBackStack(null).commit();

        mButton.setText("Tutup Kelebihan");
        isFragmentDisplayed = true;

    }
    public void closeFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();

        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.simpleFragment);
        if (simpleFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(simpleFragment).commit();
        }

        MainFragment mainFragment = MainFragment.newInstance();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainFragment, mainFragment).addToBackStack(null).commit();

        mButton.setText("Lihat Kelebihan");
        isFragmentDisplayed = false;
    }
}
package com.example.a478529_pppb2_tugas1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }
    public static MainFragment newInstance(){
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.main_fragment, container, false);
        return rootView;
    }
}
package com.example.eslamwael74.instagramclone.Profile;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eslamwael74.instagramclone.R;

/**
 * Created by Eslam Wael on 7/22/2017.
 */

public class SignOutFragment extends Fragment {

    private static final String TAG = "SignOutFragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signout,container,false);

        return view;
    }
}

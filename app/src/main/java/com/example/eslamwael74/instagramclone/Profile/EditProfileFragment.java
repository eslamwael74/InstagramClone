package com.example.eslamwael74.instagramclone.Profile;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.eslamwael74.instagramclone.R;
import com.example.eslamwael74.instagramclone.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by Eslam Wael on 7/22/2017.
 */

public class EditProfileFragment extends Fragment {

    private static final String TAG = "EditProfileFragment";
    ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_edit_profile,container,false);

        ImageView backArrow = (ImageView) view.findViewById(R.id.backArraow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        ImageView saveChanges = (ImageView) view.findViewById(R.id.saveChanges);
        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_Photo);

        initImageLoader();
        setProfileImage();
        return view;
    }

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(getActivity());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());

    }

    private void setProfileImage(){

        Log.d(TAG, "setProfileImage");
        String imageURL = "fb-s-d-a.akamaihd.net/h-ak-fbx/v/t1.0-1/c89.30.416.416/s160x160/19225868_10207778185287378_837646207452452887_n.jpg?oh=a07465daa99ec50257512c8b3bd12f99&oe=59FC9E4C&__gda__=1509929747_28ddb92ec25c5489ea8bb450324ac934";
        UniversalImageLoader.setImage(imageURL, mProfilePhoto, null, "https://");
    }
}

package com.example.eslamwael74.instagramclone.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.eslamwael74.instagramclone.R;
import com.example.eslamwael74.instagramclone.Utils.BottomNavigationViewHelper;
import com.example.eslamwael74.instagramclone.Utils.GridImageAdapter;
import com.example.eslamwael74.instagramclone.Utils.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Eslam Wael on 6/26/2017.
 */

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    Toolbar toolbar;
    private ProgressBar mProgressBar;
    private ImageView mProfilePhoto;
    Context mContext = ProfileActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started.");

//        TextView textEditProfile = (TextView)findViewById(R.id.textEditProfile);
//        textEditProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ProfileActivity.this,EditProfileFragment.class);
//                getApplicationContext().startActivity(intent);
//
//            }
//        });

        setupBottomNavView();
        setupToolbar();
        initImageLoader();
        setupActivityWidgets();
        setProfileImage();
        tempGridSetup();
    }
    private void setupImageGrid(ArrayList<String> imgURLs){
        GridView gridView = (GridView)findViewById(R.id.gridView);

        GridImageAdapter adapter = new GridImageAdapter(mContext,R.layout.layout_grid_imageview,"",imgURLs);
        gridView.setAdapter(adapter);
    }
    private void tempGridSetup(){
        ArrayList<String>imgURLs = new ArrayList<>();
        imgURLs.add("https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg");
        imgURLs.add("https://i.redd.it/9bf67ygj710z.jpg");
        imgURLs.add("https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg");
        imgURLs.add("http://i.imgur.com/EwZRpvQ.jpg");
        imgURLs.add("http://i.imgur.com/JTb2pXP.jpg");
        imgURLs.add("https://i.redd.it/59kjlxxf720z.jpg");
        imgURLs.add("https://i.redd.it/pwduhknig00z.jpg");
        imgURLs.add("https://i.redd.it/clusqsm4oxzy.jpg");
        imgURLs.add("https://i.redd.it/svqvn7xs420z.jpg");
        imgURLs.add("http://i.imgur.com/j4AfH6P.jpg");
        imgURLs.add("https://i.redd.it/89cjkojkl10z.jpg");
        imgURLs.add("https://i.redd.it/aw7pv8jq4zzy.jpg");

        setupImageGrid(imgURLs);

    }
    private void setProfileImage(){

        Log.d(TAG, "setProfileImage");
        String imageURL = "fb-s-d-a.akamaihd.net/h-ak-fbx/v/t1.0-1/c89.30.416.416/s160x160/19225868_10207778185287378_837646207452452887_n.jpg?oh=a07465daa99ec50257512c8b3bd12f99&oe=59FC9E4C&__gda__=1509929747_28ddb92ec25c5489ea8bb450324ac934";
        UniversalImageLoader.setImage(imageURL, mProfilePhoto, null, "https://");

    }
    private void setupActivityWidgets(){

        mProgressBar = (ProgressBar)findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        mProfilePhoto = (ImageView) findViewById(R.id.profile_image);

    }

    private void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.profileToolbar);
        setSupportActionBar(toolbar);

        final ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: navigating to account settings");

                Intent intent = new Intent(ProfileActivity.this,AccountSettingsActivity.class);
                startActivity(intent);
            }
        });
    }



    //BottomNavigationViewSetup
    private void setupBottomNavView(){
        Log.d(TAG,"setupBottomNavView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNav);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(ProfileActivity.this,bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(ProfileActivity.this);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());

    }


}

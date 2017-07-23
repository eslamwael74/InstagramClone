package com.example.eslamwael74.instagramclone.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.support.v4.app.Fragment;
import com.example.eslamwael74.instagramclone.R;
import com.example.eslamwael74.instagramclone.Utils.SectionStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Eslam Wael on 7/2/2017.
 */

public class AccountSettingsActivity extends AppCompatActivity {

    Context mContext;
    private static final String TAG = "AccountSettingsActivity";
    private SectionStatePagerAdapter pagerAdapter;
    ViewPager viewPager;
    RelativeLayout relativeLayout;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);
        Log.d(TAG, "onCreate: started.");

        viewPager = (ViewPager) findViewById(R.id.container);
        relativeLayout = (RelativeLayout)findViewById(R.id.relLayout1);

        ImageView backArraow = (ImageView) findViewById(R.id.backArraow);
        backArraow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        setUpSettingsList();
        setUpFragments();

    }

    private void setUpFragments(){
        pagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile));//fragment:0
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.signout));//fragment:1

    }

    private void setViewPager(int fragmentNumber){
        relativeLayout.setVisibility(View.GONE);
        Log.d(TAG,"setViewPager");
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(fragmentNumber);
    }

    private void setUpSettingsList(){

        Log.d(TAG, "setupsettingsList: started.");

        ListView listView = (ListView)findViewById(R.id.lvAccSettings);
        ArrayList<String>Options = new ArrayList<>();
        Options.add(getString(R.string.edit_profile));
        Options.add(getString(R.string.signout));

        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.list_item_setting,Options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"onItemClick: Navigation to fragment" + position);
                setViewPager(position);
            }
        });

    }
}

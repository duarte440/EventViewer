package com.drr.eventview.drr.eventviewer;


import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;


import com.drr.eventview.drr.eventviewer.model.EventProvider;


public class eventos extends AppCompatActivity {

    private EventProvider mEventProvider;
    private EventListAdapter mAdapter;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    public static class RecyclerViewItemClickListener implements View.OnClickListener {

        private int itemId;
        public RecyclerViewItemClickListener(int itemId) {
            this.itemId = itemId;
        }

        @Override
        public void onClick(View view) {
            // Read more on how to start activities at https://developer.android.com/training/basics/firstapp/starting-activity.html
            Intent intent = new Intent(view.getContext(), detalhes.class);

            intent.putExtra(detalhes.event_ID, itemId);
            view.getContext().startActivity(intent);

        }
    }

    NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventos);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Read more about Recycler View at https://developer.android.com/guide/topics/ui/layout/recyclerview.html#java
        android.support.v7.widget.RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.event_list_recycler_view);
        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView = (RecyclerView) findViewById(R.id.event_list_recycler_view);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mlayoutManager);

        // specify an adapter and pass data-set
        mEventProvider = EventProvider.getInstance();
        mAdapter = new EventListAdapter(mEventProvider.getEvents());
        mRecyclerView.setAdapter(mAdapter);


        NavigationView nv = (NavigationView)findViewById(R.id.nv1);

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case(R.id.nav_logout):
                        Intent logout = new Intent(getApplicationContext(),Index.class);
                        startActivity(logout);
                        break;
                    case(R.id.nav_geolocalizacao):
                        Intent geo = new Intent(getApplicationContext(),Index.class);
                        startActivity(geo);
                        break;
                    case(R.id.nav_qrcode):
                        Intent qr = new Intent(getApplicationContext(),qrcode.class);
                        startActivity(qr);
                        break;
                    default:
                        Intent def = new Intent(getApplicationContext(),Index.class);
                        startActivity(def);
                }
                return true;
            }
        });

    }

   public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
        }
        return super.onOptionsItemSelected(item);
    }
}
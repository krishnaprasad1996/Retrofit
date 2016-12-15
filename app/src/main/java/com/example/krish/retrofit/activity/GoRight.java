package com.example.krish.retrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.krish.retrofit.R;
import com.example.krish.retrofit.adapter.MoviesAdapter;
import com.example.krish.retrofit.model.EventBusModel;
import com.example.krish.retrofit.model.Movie;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by krish on 12/15/2016.
 */
public class GoRight  extends AppCompatActivity {

    public RecyclerView recyclerView;
    private EventBus bus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.go_right);
         recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view_right);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onButtonClick(EventBusModel event){
        List<Movie> movieGroup=event.movieList;
        recyclerView.setAdapter(new MoviesAdapter(movieGroup, R.layout.list_item_movie, getApplicationContext()));
    }

    @Override
    public void onStart() {
        super.onStart();
        bus.register(this); // registering the bus
    }

    @Override
    public void onStop() {
        bus.unregister(this); // un-registering the bus
        super.onStop();
    }

}

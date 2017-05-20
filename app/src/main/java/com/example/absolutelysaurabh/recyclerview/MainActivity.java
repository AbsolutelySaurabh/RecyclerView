package com.example.absolutelysaurabh.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GreenAdapter.ListItemClickListener{

    private static final int NUM_LIST_ITEMS = 100;
    private GreenAdapter mAdapter;
    private RecyclerView mNumberList;
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberList = (RecyclerView) findViewById(R.id.rv_numbers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNumberList.setLayoutManager(layoutManager);

        //This allows recylerView to do some optimizations on the
        //UI mainly avoid invalidating the whole layout
        //when adapter contents change.
        mNumberList.setHasFixedSize(true);

        mAdapter = new GreenAdapter(NUM_LIST_ITEMS, this);

        //Connecting the GreenAdapter to the RecyclerView;
        mNumberList.setAdapter(mAdapter);

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {

        String toastMessage = "Item #"+clickedItemIndex + " clicked.";
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
    }
}

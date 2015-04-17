package com.antyzero.loaderdecorator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private RecyclerView recyclerView;

    private static final Random RANDOM = new Random( 23 );
    private static final int INIT_AMOUNT = 0;

    private static final List<Integer> data = new ArrayList<>( INIT_AMOUNT );
    private LoaderDecorator decor;
    private TextView textView;

    private static List<Integer> addData( List<Integer> integerList, int amount ) {

        for ( int i = 0; i < amount; i++ ) {
            integerList.add( RANDOM.nextInt() );
        }

        return integerList;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        textView = new TextView( this );
        textView.setText( "Loading data" );

        recyclerView = (RecyclerView) findViewById( R.id.recyclerView );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );

        final DefaultAdapter adapter = new DefaultAdapter( data );
        decor = new LoaderDecorator( textView );

        recyclerView.setAdapter( adapter );
        recyclerView.addItemDecoration( decor );

        if ( savedInstanceState == null ) {
            addData( data, INIT_AMOUNT );
            adapter.notifyDataSetChanged();
        }

        // Add some data every few seconds

        new Thread( new Runnable() {
            @Override
            public void run() {

                while ( true ) {

                    try {
                        Thread.sleep( 5000L );
                    } catch ( InterruptedException e ) {
                        e.printStackTrace();
                    }

                    addData( data, 1 );

                    runOnUiThread( new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    } );
                }
            }
        } ).start();
    }
}

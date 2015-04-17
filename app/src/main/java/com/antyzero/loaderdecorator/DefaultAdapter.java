package com.antyzero.loaderdecorator;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by iwopolanski on 14.04.15.
 */
public class DefaultAdapter extends RecyclerView.Adapter<DefaultAdapter.IntegerViewHolder> {

    private final List<Integer> list;

    public DefaultAdapter( List<Integer> list ) {
        this.list = list;
        setHasStableIds( true );
    }

    @Override
    public DefaultAdapter.IntegerViewHolder onCreateViewHolder( ViewGroup viewGroup, int i ) {
        View viewItem = LayoutInflater.from( viewGroup.getContext() ).inflate( R.layout.item_integer, viewGroup, false );
        return new IntegerViewHolder( viewItem );
    }

    @Override
    public void onBindViewHolder( IntegerViewHolder holder, int position ) {

        Random random = new Random( getItemId( position ) );

        holder.textView.setText( String.valueOf( list.get( position ) ) );
        //holder.textView.setBackgroundColor( Color.rgb( random.nextInt( 255 ), random.nextInt( 255 ), random.nextInt( 255 ) ) );
    }

    @Override
    public long getItemId( int position ) {
        return list.get( position ).hashCode();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static final class IntegerViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public IntegerViewHolder( View itemView ) {
            super( itemView );
            this.textView = (TextView) itemView;
        }
    }
}

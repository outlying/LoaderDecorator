package com.antyzero.loaderdecorator;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by iwopolanski on 14.04.15.
 */
public class DefaultAdapter extends RecyclerView.Adapter {

    private final List<Integer> list;

    public DefaultAdapter( List<Integer> list ) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i ) {
        return null;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder viewHolder, int i ) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

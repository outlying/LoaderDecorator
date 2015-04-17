package com.antyzero.loaderdecorator;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 *
 */
public class LoaderDecorator extends RecyclerView.ItemDecoration {

    @Override
    public void onDraw( Canvas c, RecyclerView parent, RecyclerView.State state ) {
        super.onDraw( c, parent, state );
    }

    @Override
    public void onDrawOver( Canvas c, RecyclerView parent, RecyclerView.State state ) {
        super.onDrawOver( c, parent, state );
    }

    @Override
    public void getItemOffsets( Rect outRect, View view, RecyclerView parent, RecyclerView.State state ) {
        super.getItemOffsets( outRect, view, parent, state );
    }
}

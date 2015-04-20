package com.antyzero.loaderdecorator;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 */
public class LoaderDecorator extends RecyclerView.ItemDecoration {

    private static final String TAG = "LoaderDecorator";

    private final View loader;
    private final LoaderRenderer renderer;

    public LoaderDecorator( @NonNull View loaderView ) {

        renderer = new LoaderRenderer();

        loader = loaderView;

        if ( loader.getLayoutParams() == null ) {
            loader.setLayoutParams( new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT ) );
        }

    }

    @Override
    public void onDrawOver( Canvas canvas, RecyclerView parent, RecyclerView.State state ) {
        super.onDrawOver( canvas, parent, state );

        if ( parent.getChildCount() <= 0 || parent.getAdapter().getItemCount() <= 0 ) {
            renderer.drawInCenter( parent, canvas, loader );
            return;
        }

        for ( int i = 0; i < parent.getChildCount(); i++ ) {

            View lastView = parent.getChildAt( i );

            int position = parent.getChildLayoutPosition( lastView );

            // Draw loader under last item sivible on list
            if ( position + 1 == parent.getAdapter().getItemCount() ) {
                renderer.drawBelow( parent, canvas, loader, lastView );
            }
        }
    }

    @Override
    public void getItemOffsets( Rect outRect, View view, RecyclerView parent, RecyclerView.State state ) {
        super.getItemOffsets( outRect, view, parent, state );

        Log.v( TAG, "" + outRect + " | L:" + parent.getChildLayoutPosition( view ) + " | C:" + parent.getAdapter().getItemCount() );

        // Last visible item
        if ( parent.getChildLayoutPosition( view ) + 1 == parent.getAdapter().getItemCount() ) {

            // Add extra margin to last item
            outRect.bottom = 200;

        }
    }
}

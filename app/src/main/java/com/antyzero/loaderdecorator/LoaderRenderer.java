package com.antyzero.loaderdecorator;

import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by iwopolanski on 17.04.15.
 */
public class LoaderRenderer {

    public LoaderRenderer() {
    }

    /**
     * Draw view in center of canvas
     *
     * @param parent
     * @param canvas
     * @param view
     */
    public void drawInCenter( RecyclerView parent, Canvas canvas, View view ) {
        canvas.save();

        int widthSpec = View.MeasureSpec.makeMeasureSpec( parent.getWidth(), View.MeasureSpec.EXACTLY );
        int heightSpec = View.MeasureSpec.makeMeasureSpec( parent.getHeight(), View.MeasureSpec.UNSPECIFIED );

        int childWidth = ViewGroup.getChildMeasureSpec( widthSpec,
                parent.getPaddingLeft() + parent.getPaddingRight(), view.getLayoutParams().width );
        int childHeight = ViewGroup.getChildMeasureSpec( heightSpec,
                parent.getPaddingTop() + parent.getPaddingBottom(), view.getLayoutParams().height );

        view.measure( childWidth, childHeight );
        view.layout( 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight() );

        canvas.translate(
                ( (float) canvas.getWidth() - view.getMeasuredWidth() ) / 2f,
                ( (float) canvas.getHeight() - view.getMeasuredHeight() ) / 2f );

        view.draw( canvas );

        canvas.restore();
    }

    public void drawBelow( RecyclerView parent, Canvas canvas, View loader, View lastView ) {


    }
}

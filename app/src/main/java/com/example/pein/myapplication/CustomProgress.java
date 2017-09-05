package com.example.pein.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by pein on 05.09.17.
 */

public class CustomProgress extends View {
    int OutRadius = 120;
    int InnerRadius = 110;

    int centerX = OutRadius;
    int centerY = OutRadius;

    Paint mainPaint;
    Paint pointPaint;

    public CustomProgress(Context context) {
        super(context);
        init(context, null);
    }

    public CustomProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        mainPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mainPaint.setColor(context.getResources().getColor(R.color.colorPrimary));
        mainPaint.setStyle(Paint.Style.STROKE);

        pointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pointPaint.setAntiAlias(true);
        pointPaint.setStrokeWidth((float)1.5);
        pointPaint.setStrokeJoin(Paint.Join.ROUND);
        pointPaint.setStrokeCap(Paint.Cap.ROUND);
        pointPaint.setAntiAlias(true);
        pointPaint.setDither(true);
        pointPaint.setColor(context.getResources().getColor(R.color.colorPrimary));
        mainPaint.setColor(context.getResources().getColor(R.color.colorPrimary));
        centerX += 25;
        centerY += 25;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getPaddingLeft() + getPaddingRight() + OutRadius * 2 + 50;
        int height = getPaddingBottom() + getPaddingTop() + OutRadius * 2 + 50;


        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawCircle(centerX, centerY, OutRadius, mainPaint);
        //canvas.drawCircle(centerX, centerY, InnerRadius, mainPaint);

        int prevY = 25;
        int prevX = centerX;

        int prevInnerY = 25 + OutRadius - InnerRadius;
        int prevInnerX = centerX;

        int degrees = 0;
        double x,y;

        double xInner, yInner;


        for (int i=0; i<120; i++) {
//            int x = (int) Math.cos(Math.toRadians(degrees)) * OutRadius + OutRadius;
//            int y = (int) Math.sin(Math.toRadians(degrees)) * OutRadius + OutRadius;

            x = (centerX + (prevX - centerX) * Math.cos(Math.toRadians(degrees)) - (prevY - centerY) * Math.sin(Math.toRadians(degrees)));
            y =  (centerY + (prevY - centerY) * Math.cos(Math.toRadians(degrees)) - (prevX - centerX) * Math.sin(Math.toRadians(degrees)));
           // canvas.drawCircle((float) x, (float) y, 1, pointPaint);

            xInner = (centerX + (prevInnerX - centerX) * Math.cos(Math.toRadians(degrees)) - (prevInnerY - centerY) * Math.sin(Math.toRadians(degrees)));
            yInner = (centerY + (prevInnerY - centerY) * Math.cos(Math.toRadians(degrees)) - (prevInnerX - centerX) * Math.sin(Math.toRadians(degrees)));


            canvas.drawLine((float) x, (float) y, (float) xInner, (float) yInner, pointPaint);

            degrees +=3;
        }
    }


}

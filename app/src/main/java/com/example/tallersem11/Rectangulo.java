package com.example.tallersem11;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Rectangulo {

    private float left, top, right, bottom;
    private int color;

    public Rectangulo(float left, float top, float right, float bottom, int color) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.color = color;
    }

    public void pintar(Canvas canvas) {
        //como el fill
        Paint p = new Paint();
        p.setColor(color);
        canvas.drawRect(left, top, right, bottom,  p);
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

package com.example.tallersem11;

import android.graphics.Canvas;
import android.graphics.Paint;

public class X {

    private float posX, posY;
    private int color;

    public X() {

    }

    public X(float posX, float posY, int color) {
        this.posX = posX;
        this.posY = posY;
        this.color = color;
    }

    public void pintar(Canvas canvas) {
        //como el fill
        Paint p = new Paint();
        p.setColor(color);
        p.setTextSize(200);
        canvas.drawText("X", posX, posY, p);
    }
}

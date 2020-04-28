package com.example.tallersem11;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Jugada {

    private String texto;
    private int turno;

    public Jugada() {
        this.texto = "El juega";
        this.turno = 1;
    }

    public void miTurno(Canvas canvas) {
        if(turno == 2) {
            Paint p = new Paint();
            p.setColor(Color.rgb(255,255,255));
            p.setTextSize(80);
            texto = "Tu juegas";
            canvas.drawText(texto, 400, 1600, p);
        }
    }

    public void espera(Canvas canvas) {
        if(turno == 1) {
            Paint p = new Paint();
            p.setColor(Color.rgb(255,255,255));
            p.setTextSize(80);
            canvas.drawText(texto, 400, 1600, p);
        }
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

}

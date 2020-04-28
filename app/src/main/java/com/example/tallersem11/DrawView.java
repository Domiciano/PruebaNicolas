package com.example.tallersem11;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class DrawView extends View {

    public DrawView(Context context) {
        super(context);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    //variables socket
    private DatagramSocket socket;
    private InetAddress eclipse;
    //variables globales
    private int width;
    private int height;
    private int framecount;
    //variables de la clase rectangulo y O y X
    private Rectangulo rect1,rect2,rect3,rect4,rect5,rect6,rect7,rect8,rect9;
    private ArrayList<O> oArray;
    private X x1, x2, x3, x4, x5, x6, x7, x8, x9;
    //variables de la clase jugada
    private Jugada jugar;
    //variable alert
    private JugadaAlert alert;

    //contro+o para sobreescribir metodos
    //metodo sucede cuando inicia la app, es para que busque el tam del dispositivo
    //equivalente a settings()
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        setup();
    }


    //equivalente al setup()
    public void setup() {
        //socket
        new Thread(
                () -> {
                    try {
                        eclipse = InetAddress.getByName("192.168.0.9");
                        socket = new DatagramSocket (5010);

                        while(true) {
                            byte[] buffer = new byte[100];
                            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                            socket.receive(packet);

                            String mensajeRecibido = new String(packet.getData());
                            Gson gson = new Gson();
                            alert = gson.fromJson(mensajeRecibido,JugadaAlert.class);

                        }

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (SocketException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();
        //inicializacion rectangulos
        rect1 = new Rectangulo(50,464, 360, 774, Color.rgb(252, 34, 101));
        rect2 = new Rectangulo(385,464, 695, 774, Color.rgb(86, 114, 255));
        rect3 = new Rectangulo(720,464, 1030, 774, Color.rgb(242, 242, 64));
        rect4 = new Rectangulo(50,802, 360, 1112, Color.rgb(143, 47, 244));
        rect5 = new Rectangulo(385,802, 695, 1112, Color.rgb(77, 244, 84));
        rect6 = new Rectangulo(720,802, 1030, 1112, Color.rgb(239, 72, 239));
        rect7 = new Rectangulo(50,1146, 360, 1456, Color.rgb(244, 197, 49));
        rect8 = new Rectangulo(385,1146, 695, 1456, Color.rgb(78, 244, 216));
        rect9 = new Rectangulo(720,1146, 1030, 1456, Color.rgb(244, 59, 59));
        //inicializo los arrays
        oArray = new ArrayList<O>();
        //inicializo las x
        x1 = new X(147, 685, Color.rgb(0,0,0));
        x2 = new X();
        x3 = new X();
        x4 = new X();
        x5 = new X();
        x6 = new X();
        x7 = new X();
        x8 = new X();
        x9 = new X();
        //incicializo la clase jugada
        jugar = new Jugada();
        //inicialiso alert


    }

    //equivalente al draw()
    @Override
    protected void onDraw(Canvas canvas) {
        framecount++;
        //pinto el fondo
        canvas.drawARGB(255,0,0,0);
        //pinto rectangulos
        rect1.pintar(canvas);
        rect2.pintar(canvas);
        rect3.pintar(canvas);
        rect4.pintar(canvas);
        rect5.pintar(canvas);
        rect6.pintar(canvas);
        rect7.pintar(canvas);
        rect8.pintar(canvas);
        rect9.pintar(canvas);
        //pintar texto jugada
        jugar.miTurno(canvas);
        jugar.espera(canvas);
        //pinto las x
        if(alert.getCasilla() == 1){
            x1.pintar(canvas);
            jugar.setTurno(2);
        }
        //pinto las 0
        for (int i = 0; i < oArray.size(); i++) {
            O o = oArray.get(i);
            o.pintar(canvas);
        }

        invalidate();
    }

    //es como el mousePressed()
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                //zonas sensibles
                //rect1
                if(jugar.getTurno() == 2){
                    if(event.getX() > 50 && event.getX() < 360 && event.getY() > 464 && event.getY() < 774 ) {
                        O o = new O(147, 685, Color.rgb(0, 0, 0));
                        oArray.add(o);
                        jugar.setTurno(1);
                    }
                }
                //rect2
                if(jugar.getTurno() == 2) {
                    if (event.getX() > 385 && event.getX() < 695 && event.getY() > 464 && event.getY() < 774) {
                        O o = new O(482, 685, Color.rgb(0, 0, 0));
                        oArray.add(o);
                        jugar.setTurno(1);
                    }
                }
                //rect3
                if(jugar.getTurno() == 2) {
                    if (event.getX() > 720 && event.getX() < 1030 && event.getY() > 464 && event.getY() < 774) {
                        O o = new O(817, 685, Color.rgb(0, 0, 0));
                        oArray.add(o);
                        jugar.setTurno(1);
                    }
                }
                //rect4
                if(jugar.getTurno() == 2) {
                    if (event.getX() > 50 && event.getX() < 360 && event.getY() > 802 && event.getY() < 1112) {
                        O o = new O(147, 1023, Color.rgb(0, 0, 0));
                        oArray.add(o);
                        jugar.setTurno(1);
                    }
                }
                //rect5
                if(jugar.getTurno() == 2) {
                    if (event.getX() > 385 && event.getX() < 695 && event.getY() > 802 && event.getY() < 1112) {
                        O o = new O(482, 1023, Color.rgb(0, 0, 0));
                        oArray.add(o);
                        jugar.setTurno(1);
                    }
                }
                //rect6
                if(jugar.getTurno() == 2) {
                    if (event.getX() > 720 && event.getX() < 1030 && event.getY() > 802 && event.getY() < 1112) {
                        O o = new O(817, 1023, Color.rgb(0, 0, 0));
                        oArray.add(o);
                        jugar.setTurno(1);
                    }
                }
                //rect7
                if(jugar.getTurno() == 2) {
                    if (event.getX() > 50 && event.getX() < 360 && event.getY() > 1146 && event.getY() < 1456) {
                        O o = new O(147, 1367, Color.rgb(0, 0, 0));
                        oArray.add(o);
                        jugar.setTurno(1);
                    }
                }
                //rect8
                if(jugar.getTurno() == 2) {
                    if (event.getX() > 385 && event.getX() < 695 && event.getY() > 1146 && event.getY() < 1456) {
                        O o = new O(482, 1367, Color.rgb(0, 0, 0));
                        oArray.add(o);
                        jugar.setTurno(1);
                    }
                }
                //rect9
                if(jugar.getTurno() == 2) {
                    if (event.getX() > 720 && event.getX() < 1030 && event.getY() > 1146 && event.getY() < 1456) {
                        O o = new O(817, 1367, Color.rgb(0, 0, 0));
                        oArray.add(o);
                        jugar.setTurno(1);
                    }
                }
                break;

        }
        return true;
    }

    public void enviarMensaje(String mensaje) {
        new Thread(
                () -> {
                    byte[] buffer = mensaje.getBytes();
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, eclipse, 5010);
                    try {
                        socket.send(packet);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
        ).start();
    }
}

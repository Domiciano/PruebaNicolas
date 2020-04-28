package com.example.tallersem11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

   /* private DatagramSocket socket;
    private InetAddress eclipse;
    private Button enviarBtn;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //enviarBtn = findViewById(R.id.enviarBtn);

       /* new Thread(
                () -> {
                    try {
                        eclipse = InetAddress.getByName("192.168.0.9");
                        socket = new DatagramSocket (5000);

                        while(true) {
                            byte[] buffer = new byte[100];
                            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                            socket.receive(packet);

                            String mensajeRecibido = new String(packet.getData());
                            Gson gson = new Gson();
                            JugadaAlert jugada = gson.fromJson(mensajeRecibido, JugadaAlert.class);


                            runOnUiThread(
                                    () -> {
                                        Toast.makeText(this,mensajeRecibido,Toast.LENGTH_LONG).show();
                                    }
                            );

                        }

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (SocketException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
        ).start();*/

    }

    /*public void enviarMensaje(String mensaje) {
        new Thread(
                () -> {
                    byte[] buffer = mensaje.getBytes();
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, eclipse, 5000);
                    try {
                        socket.send(packet);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
        ).start();
    }*/


}

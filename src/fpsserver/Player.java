/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpsserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Octalus
 */
public class Player {
    int id;
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    float x_position, y_position, z_position;
    public Player(Socket socket, int id) throws IOException {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.id = id;
    }
    
    public void setPosition(String position) {
        String[] split = position.split(":")[0].split(",");
        x_position = Float.parseFloat(split[0]);
        y_position = Float.parseFloat(split[1]);
        z_position = Float.parseFloat(split[2]);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpsserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Octalus
 */
public class FPSServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6667);
        int playerCount = 1;
        
        ArrayList<Player> players = new ArrayList<Player>();
        for(int i = 0; i < playerCount; i++) {
            players.add(new Player(serverSocket.accept(), i));
            System.out.println("A client connected");
        }
        
        System.out.println("All Clients Connected");
        
        while(true) {
        }
    }
    
}

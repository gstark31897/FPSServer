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
        Scanner input = new Scanner(System.in);
        System.out.println("How many players?");
        int playerCount = input.nextInt();
        input.close();
        
        ArrayList<Socket> players = new ArrayList<Socket>();
        ArrayList<PrintWriter> outs = new ArrayList<PrintWriter>();
        ArrayList<BufferedReader> ins = new ArrayList<BufferedReader>();
        for(int i = 0; i < playerCount; i++) {
            players.add(serverSocket.accept());
            outs.add(new PrintWriter(players.get(i).getOutputStream(), true));
            ins.add(new BufferedReader(new InputStreamReader(players.get(i).getInputStream())));
        }
        
        System.out.println("All Clients Connected");
    }
    
}

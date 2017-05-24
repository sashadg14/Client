package com.company; /**
 * Created by alex o n 23.04.2017.
 */
import com.company.View;
import com.company.controllers.RequestManager;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
    BufferedReader in = null;
    PrintWriter out = null;
    Socket fromserver = null;
    View view;
    String ip;
    int port;
    public Client(){

   /* if (args.length==0) {
      System.out.println("use: client hostname");
      System.exit(-1);
    }*/
        //System.out.println("Connecting to... "+args[0]);

        view= new View(this);

        /*while (true) {
            if((fuser = inu.readLine())!=null);
                    //addStudent(in, out);
            if (fuser.equalsIgnoreCase("close")) break;
            if (fuser.equalsIgnoreCase("exit")) break;
        }
        out.close();
        in.close();
        inu.close();
        fromserver.close();*/
    }

    @Override
    public void run() {
        try {
        fromserver = new Socket(ip,port);
        in= new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
            out= new PrintWriter(fromserver.getOutputStream(),true);
            RequestManager requestManager = new RequestManager(in,out);
            view.setRequestManager(requestManager);
            JOptionPane.showMessageDialog(new JFrame(), "Подключено");
        } catch (ConnectException c){
            JOptionPane.showMessageDialog(new JFrame(), "Ошибка подключения");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

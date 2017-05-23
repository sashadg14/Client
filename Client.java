/**
 * Created by alex o n 23.04.2017.
 */
import com.company.View;
import com.company.controllers.RequestManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        RequestManager requestManager = new RequestManager(in,out);
        View view = new View(requestManager);
        Socket fromserver = null;

   /* if (args.length==0) {
      System.out.println("use: client hostname");
      System.exit(-1);
    }*/

        //System.out.println("Connecting to... "+args[0]);

        fromserver = new Socket("localhost",4444);
        in= new BufferedReader(new
                InputStreamReader(fromserver.getInputStream()));
        out= new PrintWriter(fromserver.getOutputStream(),true);
        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));


        String fuser = null,fserver;

        while (true) {
            if((fuser = inu.readLine())!=null);
                    //addStudent(in, out);
            if (fuser.equalsIgnoreCase("close")) break;
            if (fuser.equalsIgnoreCase("exit")) break;
        }
        out.close();
        in.close();
        inu.close();
        fromserver.close();
    }
    void readFromFile(){

    }
}

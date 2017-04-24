/**
 * Created by alex o n 23.04.2017.
 */
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Client side");

        Socket fromserver = null;

   /* if (args.length==0) {
      System.out.println("use: client hostname");
      System.exit(-1);
    }*/

        //System.out.println("Connecting to... "+args[0]);

        fromserver = new Socket("localhost",4444);
        BufferedReader in  = new
                BufferedReader(new
                InputStreamReader(fromserver.getInputStream()));
        PrintWriter out = new PrintWriter(fromserver.getOutputStream(),true);
        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

        String fuser = null,fserver;

        while (true) {
            if((fuser = inu.readLine())!=null);
                    addStudent(in, out);
            if (fuser.equalsIgnoreCase("close")) break;
            if (fuser.equalsIgnoreCase("exit")) break;
        }
        out.close();
        in.close();
        inu.close();
        fromserver.close();
    }

    static void addStudent(BufferedReader bufferedReader,PrintWriter out) throws IOException {
        out.println("ADD");
        for(int i=0;i<14;i++){
            out.println(i+" chislo");
        }
        String fserver;
        if((fserver = bufferedReader.readLine())!=""){
            System.out.println(fserver);
        }
        int count = Integer.parseInt(fserver);
        while (count>0){
            int schetchik=0;
            while (schetchik<14)
            if((fserver = bufferedReader.readLine())!=""){
                System.out.println(fserver+" from server"+count);
                schetchik++;
            }
            count--;
        }
    }
}

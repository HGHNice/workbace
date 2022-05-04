package Text;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class User{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int a= sc.nextInt();
        while (a!=0){
            Socket socket=null;
            OutputStream os=null;
            try {
                InetAddress serverIP=InetAddress.getByName("127.0.0.1");
                int port=9999;
                socket=new Socket(serverIP,port);
                os=socket.getOutputStream();
                String e=sc.nextLine();
                os.write(e.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (os!=null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (socket!=null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
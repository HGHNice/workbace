package Text;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Tcp1{
    public static void main(String[] args) {
        Socket socket=null;
        OutputStream os=null;
        try {
            InetAddress serverIP=InetAddress.getByName("127.0.0.1");
            int port=9999;
             socket=new Socket(serverIP,port);
             os=socket.getOutputStream();
            os.write("你好".getBytes());
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
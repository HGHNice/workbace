package Text;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class text1 {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress=InetAddress.getByName("127.0.0.1");
            System.out.println(inetAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

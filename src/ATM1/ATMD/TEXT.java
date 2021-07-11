package ATM1.ATMD;


import java.io.File;
import java.io.Reader;

public class TEXT {

    public static File file;
    static Reader fw;
    static String name;
    static String pass;
    static String money;

    public static void main(String[] args)  {
        Account a = new Account();
        MainInterface mainInterface = new MainInterface();
        mainInterface.run();



    }


            }






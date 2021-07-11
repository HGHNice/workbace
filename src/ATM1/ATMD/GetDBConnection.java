package ATM1.ATMD;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetDBConnection {
    //DBName:数据库名 ，id : 用户名（root）password:数据库密码
    public static Connection ConnectDB(String DBName, String id, String password) {
        Connection con = null;
        String uri="jdbc:mysql://localhost:3306/"+DBName+"?useSSL=true&characterEncoding=utf-8";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动
        } catch (Exception e) {
            System.out.println("加载驱动失败");
        }

        try {
            con = DriverManager.getConnection(uri,id,password);//连接
        } catch (Exception e) {
            System.out.println("连接失败");
        }

        return con;
    }

}

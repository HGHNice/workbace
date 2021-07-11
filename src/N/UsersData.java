package N;

import java.sql.*;

public class UsersData {
    private static Connection con; //声明 Connection 对象
    private static PreparedStatement pStmt;//声明预处理 PreparedStatement 对象
    private static ResultSet res;//声明结果 ResultSet 对象

    private static String url = "jdbc:mysql://localhost:3306/text";// 协议：子协议：//目标IP地址：端口/数据库  在这里test1是之前创建的数据库名
    private static String user = "root";
    private static String password = "123456";

    public static Connection getConnection() {//建立返回值为 Connection 的方法

        //代码块（1）：加载数据库驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //代码块（2）：通过访问数据库的URL获取数据库连接对象
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public static void usermoth() {//主方法
        UsersData h = new UsersData();//创建本类对象
        con = h.getConnection();//与数据库建立连接
    }

    //链接普通用户的数据库
    public static boolean ordinaryUser(String id,String password){
        boolean ok = false;
        try {   //mysql查询语句
            String sql = "SELECT * FROM  text.di";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
                if(res.getString("账号").equals(id)){
                    if(res.getString("密码").equals(password)){
                        ok = true;
                    }
                }
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        }finally {
            return true;
        }
    }

    //链接管理员的数据库
    public static boolean manager(String id,String password){
        boolean ok = false;
        try {   //mysql查询语句
            String sql = "SELECT * FROM text.di ";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
                if(res.getString("账号").equals(id)){
                    if(res.getString("密码").equals(password)){
                        ok = true;
                    }
                }
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        }finally {
            return ok;
        }
    }

    //获取到普通用户的基本信息
    public static String[] userInformation(String id){
        String[] information = new String[4];
        try {   //mysql查询语句
            String sql = "SELECT * FROM text.di ";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
                if(res.getString("账号").equals(id)){
                    information[0] = res.getString("姓名");
                    information[1] = res.getString("联系方式");
                    information[2] = res.getString("性别");
                    information[3] = res.getString("地址");
                }
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        }finally {
            return information;
        }
    }

    //保存修改后的用户信息
    public static void saveEditor(String id,String name,String call,String sex,String address){
        try {   //mysql查询语句
            String sql = "SELECT * FROM text.di";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
                if(res.getString("账号").equals(id)){
                    String str1 = "update text.di set 姓名 = '"+ name +"',性别 = '"+sex+"',联系方式 = '"+call+"',地址 ='"+address+"' where 账号 = '"+id+"'";
                    pStmt = con.prepareStatement(str1);
                    pStmt.executeUpdate();
                    break;
                }
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        }
    }

    //查看用户“我的订单”中有多少条数据
    public static int numDate(String id){
        int i = 0;
        try {   //mysql查询语句
            String sql = "SELECT * FROM text.di";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()){
                i++;
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        } finally {
            return i;
        }

    }

    //实现获取“我的订单”数据的功能
    public static String[][] showData(int num,String id) {
        final int NUM = num;
        String[][] data = {};
        try {   //mysql查询语句
            data = new String[NUM][];
            String sql = "SELECT * FROM text.name" ;

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            for (int i = 0,j=0; res.next(); i++) {
                data[j] = new String[]{
                        res.getString("序号"),
                        res.getString("编号"),
                        res.getString("下单时间"),
                        res.getString("商品名称"),
                        res.getString("收货信息")
                };
                j++;
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        } finally {
            return data;
        }
    }

}

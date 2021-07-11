package N;

//import ATM.UserData;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreeData {
    private static Connection con; //声明 Connection 对象
    private static PreparedStatement pStmt;//声明预处理 PreparedStatement 对象
    private static ResultSet res;//声明结果 ResultSet 对象

    private static String url = "jdbc:mysql://localhost:3306/text?useSSL=true&characterEncoding=utf-8";// 协议：子协议：//目标IP地址：端口/数据库  在这里test1是之前创建的数据库名
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
        TreeData h = new TreeData();//创建本类对象
        con = h.getConnection();//与数据库建立连接
    }

    //获取到数据库中所有节点的名称
    public static List allNodes() {
        List list = new ArrayList();
        try {   //mysql查询语句
            String sql = "SELECT * FROM text.good";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
                list.add(res.getString("节点名称"));
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        }finally {
            return list;
        }

    }

    //找到位于最底部的节点
    public static String BottomNodes(String node) {
        String bottom = "";
        int flag = 0;
        try {   //mysql查询语句
            String sql = "SELECT * FROM text.good ";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
                if(res.getString("父节点").equals(node)){
                    flag = 1;
                    break;
                }
            }

            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        }finally {
            if(flag == 0){
                return node;
            }else {
                return null;
            }
        }
    }

    //获取到每个节点的父节点
    public static String fatherNodes(String node) {
        String father = "";
        try {   //mysql查询语句
            String sql = "SELECT * FROM text.good ";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
                if(res.getString("节点名称").equals(node)){
                    father = res.getString("父节点");
                }
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        }finally {
            return father;
        }

    }

    //对添加操作进行数据库的保存
    public static void addNewNode(String name,String price,String part,String details) {
        String father = ".fa";
        //代码块（4）：得到结果集
        String sql = "insert into text.good(节点名称,父节点,商品名称,商品价格,商品分类,商品详情) values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, father);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, price);
            preparedStatement.setString(5, part);
            preparedStatement.setString(6, details);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //获取到当前节点的具体内容
    public static String nowSelect(String name){
        String str = "";
        try {   //mysql查询语句
            String sql = "SELECT * FROM text.good ";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
               if(res.getString("节点名称").equals(name) && !(res.getString("商品名称").equals(""))){
                   str = res.getString("节点名称") + "\n" +
                           "价格："+res.getString("商品价格") + "\n" +
                           "商品详情" + "\n" + res.getString("商品详情");
               }
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        }finally {
            return str;
        }
    }

    //获取到当前节点的具体内容
    public static List showSelect(String name){
        List<String> node = new ArrayList<>();
        String str = "";
        try {   //mysql查询语句
            String sql = "SELECT * FROM text.good ";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
                if(res.getString("节点名称").equals(name)){
                    node.add(res.getString("节点名称"));
                    node.add(res.getString("商品价格"));
                    node.add(res.getString("商品分类"));
                    node.add(res.getString("商品详情"));
                }
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        }finally {
            return node;
        }
    }

    //保存更改后的数据
    public static void saveEditor(String name,String newName,String price,String part,String text){
        try {   //mysql查询语句
            String sql = "SELECT * FROM text.good";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
                if(res.getString("节点名称").equals(name)){
                    String str1 = "update text.good set 商品名称 = '"+ newName +"' where 节点名称 = '"+name+"'";
                    String str2 = "update text.good set 商品价格 = '"+ price +"' where 节点名称 = '"+name+"'";
                    String str3 = "update text.good set 商品分类 = '"+ part +"' where 节点名称 = '"+name+"'";
                    String str4 = "update text.good set 商品详情 = '"+ text +"' where 节点名称 = '"+name+"'";
                    pStmt = con.prepareStatement(str1);
                    pStmt = con.prepareStatement(str2);
                    pStmt = con.prepareStatement(str3);
                    pStmt = con.prepareStatement(str4);
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

}

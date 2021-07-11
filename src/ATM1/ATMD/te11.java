package ATM1.ATMD;

import java.sql.*;


/**
 * 实现查询 “历史记录” 功能
 * 每个账号都建立一个对应的数据库（history+账号）来存储相应的数据
 * 本类的具体功能：
 * 1、showData() 将数据库的内容导入表格中
 *  用showData()返回String[][]，在创建表格时使用String[][]达到导入表格的效果
 * 2、add()将数据添加到数据库中
 *
 **/

public class te11 {
    private static Connection con; //声明 Connection 对象
    private static PreparedStatement pStmt;//声明预处理 PreparedStatement 对象
    private static ResultSet res;//声明结果 ResultSet 对象

    private static String url = "jdbc:mysql://localhost:3306/text?useSSL=true&characterEncoding=utf-8";// 协议：子协议：//目标IP地址：端口/数据库  在这里test1是之前创建的数据库名
    private static String user = "root";
    private static String password = "123456";

    public static Connection getConnection() {//建立返回值为 Connection 的方法

        //加载数据库驱动类
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //通过访问数据库的URL获取数据库连接对象
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }
    public static void usermoth() {//主方法
        te11 h = new te11();//创建本类对象
        con = h.getConnection();//与数据库建立连接
    }

    public static int getDataNum(String id) {
        int i = 0;
        try {   //mysql查询语句
            String sql = "SELECT date,outmoney,inmoney,oldid FROM atmbankdatabase.atm";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            while (res.next()) {//如果当前语句不是最后一条，则进入循环
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
    //将数据库中的数据导入到表格中
    public static String[][] showData(String id) {
        final int NUM = getDataNum(id);
        String[][] data = new String[NUM][];

        try {   //mysql查询语句
            String sql = "SELECT date,outmoney,inmoney,oldid FROM atmbankdatabase.atm";

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            for (int i = 0; res.next(); i++) {
                data[i] = new String[]{
                        res.getString("交易日期"),
                        res.getString("支出"),
                        res.getString("收入"),
                        res.getString("对方账号"),
                };
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        } finally {
            return data;
        }
    }

    //方法重载，实现获取【近一个月】数据的功能
    public static String[][] showData(String id,int date) {
        final int NUM = getDataNum(id);
        String[][] data = new String[NUM][];

        try {   //mysql查询语句
            String sql = "SELECT * FROM atm" + id;

            //代码块（4）：得到结果集
            pStmt = con.prepareStatement(sql);
            res = pStmt.executeQuery();

            for (int i = 0; res.next(); i++) {
                String[] item = res.getString("交易日期").split("-");
                int oldDate = 0;
                oldDate = Integer.parseInt(item[0]) + Integer.parseInt(item[0])*100 + Integer.parseInt(item[0]);
                if(oldDate <= date && oldDate >= (date-100)){
                    data[i] = new String[]{
                            res.getString("交易日期"),
                            res.getString("支出"),
                            res.getString("收入"),
                            res.getString("对方账号"),
                    };
                }
            }
            res.close();//释放资源
            pStmt.close();
        } catch (SQLException e) {//捕获异常
            e.printStackTrace();
        } finally {
            return data;
        }
    }
    //动态的将操作存、取款的数据添加到数据库history+账号中
    public static void addIntOut(String id, String date, String isDeposit, String money) {

        //代码块（4）：得到结果集

        String sql = "insert into atm" + id + "date,outcomeId,incomeId,money values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);

            //判断是否为存取款
            if (isDeposit.equals("+")) {
                preparedStatement.setString(1, date);
                preparedStatement.setString(2, "0");
                preparedStatement.setString(3, money);
                preparedStatement.setString(4, "--");
                preparedStatement.executeUpdate();
            } else if (isDeposit.equals("-")) {
                preparedStatement.setString(1, date);
                preparedStatement.setString(2, money);
                preparedStatement.setString(3, "0");
                preparedStatement.setString(4, "--");
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //动态的将操作转账的数据添加到数据库history+账号中
    public static void addTransfer(String date, String outcomeId, String incomeId, String money) {

        //代码块（4）：得到结果集
        try {
            //对outcomeId进行操作
            String sql1 = "insert into atm" + outcomeId + "date,outcomeId,incomeId,money values(?,?,?,?)";
            PreparedStatement preparedStatement1 = getConnection().prepareStatement(sql1);

            preparedStatement1.setString(1, date);
            preparedStatement1.setString(2, money);
            preparedStatement1.setString(3, "0");
            preparedStatement1.setString(4, incomeId);
            preparedStatement1.executeUpdate();

            String sql2 = "insert into atm" + incomeId + "date,outcomeId,incomeId,money values(?,?,?,?)";
            PreparedStatement preparedStatement2 = getConnection().prepareStatement(sql2);
            preparedStatement2.setString(1, date);
            preparedStatement2.setString(2, "0");
            preparedStatement2.setString(3, money);
            preparedStatement2.setString(4, outcomeId);
            preparedStatement2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


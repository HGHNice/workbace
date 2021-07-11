package ATM1.ATMD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {    //此类编写所有方法
    public static Connection con;
    public static String cardID="";//用户卡号
    public static String password="123456";//用户登陆密码
    public static String password2="";//新密码(修改密码)
    public static String password3="";//确认新密码(修改密码)
    public static String balanceFixed ="0";//余额的变量
    public static PreparedStatement ps;//预编译的SQL语句的对象
    //以下三个接数据库增删改查所用的变量
    public String sql;
    public String s="";//接收各个方法返回值的变量
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String nowdate = dateFormat.format(new Date());


    //构造方法
    Account() {
        //连接数据库
        con = GetDBConnection.ConnectDB("text", "root", "123456");  //数据库密码及账号和要查询的表
        if(con == null) {
            System.out.println("数据库连接失败");
            return;
        }
        sql="select id from atm where balance=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, cardID);
            ResultSet rs =ps.executeQuery();//向数据库发送数据查询语句
            while(rs.next()) {
                balanceFixed = rs.getString("money");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void addIntOut(String id, String date, String isDeposit, String money) {    //判断是否为存取款 进行账户更新

        String sql ="insert into atmbankdatabase.atm" + " (date,交易账户,取,存,对方账号) values(? , ? ,?, ?, ?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            //判断是否为存取款
            if (isDeposit.equals("+")) {
                preparedStatement.setString(1, date);
                preparedStatement.setString(2, id);
                preparedStatement.setString(3,"0" );
                preparedStatement.setString(4, money);
                preparedStatement.setString(5, id);
                preparedStatement.executeUpdate();
            } else if (isDeposit.equals("-")) {

                preparedStatement.setString(1, date);
                preparedStatement.setString(2, id);
                preparedStatement.setString(3,money );
                preparedStatement.setString(4, "0");
                preparedStatement.setString(5, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //登陆
    public String jlogin(String cardID,String password) {
        String newCardID="0";
        String newPassword="0";
        String sql="select id,password from atm where id=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, cardID);
            ResultSet rs =ps.executeQuery();//向数据库发送数据查询语句
            while(rs.next()) {
                newCardID= rs.getString("id");
                newPassword=rs.getString("password");
            }
            if(cardID.equals(newCardID) && password.equals(newPassword)) {  //登陆判断
                System.out.println("登陆成功");
                s = "登陆成功";
                this.cardID=cardID;//使另一个类可以调用这个cardID
            }else {
                System.out.println("用户名或密码不正确,请重新输入");
                s="用户名或密码不正确,请重新输入";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }

    //查余额 调用sql数据库的数据
    public String select(String cardID) throws SQLException {
        String sql="select balance from atm where id=?;";
        ps=con.prepareStatement(sql);
        ps.setString(1, cardID);
        ResultSet rs =ps.executeQuery();//向数据库发送数据查询语句//返回查询 PreparedStatement的 ResultSet对象
        while(rs.next()) {
            balanceFixed = rs.getString("balance");
        }
        double balance_number = Double.parseDouble(balanceFixed);   //余额定义
        System.out.println("当前账户余额："+balance_number);
        balanceFixed = String.valueOf(balance_number);
        s=balanceFixed;
        return s;
    }

    //取款
    public String Withdrawal(String cardID,String take_money2) {
        try {                               //先查询余额
            select(cardID);
        } catch (SQLException e) {
            System.out.println("取款查询失败");
        }
        //take_money要取的钱数
        boolean isNum = take_money2.matches("[0-9]+"); //判断是否正确输入格式
        if(isNum) {
            double take_money = Double.parseDouble(take_money2);
            if(take_money<=5000) {
                if(take_money%100 == 0) {
                    try {
                        //balance_number:数字格式的余额，用于和将要取的金额做比较
                        double balance_number = Double.parseDouble(balanceFixed);
                        if(take_money<=balance_number) {
                            sql="update atm set balance=?-? where id=?;";
                            ps=con.prepareStatement(sql);
                            ps.setDouble(1, balance_number);//余额
                            ps.setDouble(2, take_money);//要取的金额
                            ps.setString(3, cardID);
                            ps.executeUpdate();//注意这个executeUpdate,和查询的不一样
                            balance_number=balance_number-take_money;
                            balanceFixed=String.valueOf(balance_number);
                            System.out.println("取款成功,当前余额为："+balanceFixed);
                            s=balanceFixed;
                            addIntOut(cardID,nowdate,"-", String.valueOf(take_money));
                        }else {
                            System.out.println("余额不足,请重新输入");
                            s="余额不足,请重新输入";
                        }
                    } catch (SQLException e) {
                        System.out.println("取款出错");
                        s="取款出错";
                    }
                }else {
                    System.out.println("取款金额必须是100的整数倍,请重新输入");
                    s="取款金额必须是100的整数倍,请重新输入";
                }

            }else {
                System.out.println("单次取款金额不得超过5000,请重新输入");
                s="单次取款金额不得超过5000,请重新输入";
            }
        }else {
            s="取款失败,您的输入为非数字";
            System.out.println("取款失败,您的输入为非数字");
        }


        return s;
    }

    //存款
    public String deposit(String cardID,String m) {
        try {                               //先查询余额
            select(cardID);
        } catch (SQLException e) {
            System.out.println("存款查询失败");
        }
        //用正则表达式来判断输入
        boolean inNum = m.matches("[0-9]+");
        if(inNum) {
            double add_money2 = Double.parseDouble(m);
            if(add_money2>0) {    //判断金额大于0
                if(add_money2%100 == 0) {  //判断金额为100的倍数
                    try {
                        //balance_number:数字格式的余额，用于和将要取的金额做比较
                        double balance_number = Double.parseDouble(balanceFixed);
                        sql="update atm set balance=?+? where id=?;";   //sql数据更新语句 +
                        ps=con.prepareStatement(sql);
                        ps.setDouble(1, balance_number);//余额
                        ps.setDouble(2, add_money2);//要存的金额
                        ps.setString(3, cardID);
                        ps.executeUpdate();
                        balance_number=balance_number+add_money2;
                        balanceFixed=String.valueOf(balance_number);
                        s=balanceFixed;
                        System.out.println("存款成功");
                        System.out.println("当前余额为："+balanceFixed);
                        addIntOut(cardID,nowdate,"+", String.valueOf(add_money2));

                    } catch (SQLException e) {
                        System.out.println("存款出错");
                    }
                }else {
                    s="存款金额必须是100的整数倍,请重新输入";
                    System.out.println("存款金额必须是100的整数倍,请重新输入");
                }
            }else {
                s="不得输入负数,请重新输入";
                System.out.println("不得输入负数,请重新输入");
            }
        }else {
            s="存款失败,您的输入为非数字";
            System.out.println("存款失败,您的输入为非数字");
        }
        return s;
    }

    //4.修改密码
    public String changePassword(String cardID,String password,String password2,String password3) {
        String yuanPassword="";//原密码
        sql="select password from atm where id=?;";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, cardID);
            ResultSet rs =ps.executeQuery();//向数据库发送数据查询语句
            while(rs.next()) {
                yuanPassword=rs.getString("apassword");
            }

            if(yuanPassword.equals(password)) {
                if(password2.length()>=6) {
                    char[] a = password2.toCharArray();
                    if(a[0]==a[1]&&a[1]==a[2]&&a[2]==a[3]&&a[3]==a[4]&&a[4]==a[5]) {  //不能全部一样
                        System.out.println("不可以设置全部数字相同的密码");
                        s="不可以设置全部数字相同的密码";
                    }else {
                        if(password2.equals(password3)) {
                            sql="update atm set password=? where id=?;";
                            ps = con.prepareStatement(sql);
                            ps.setString(1, password2);
                            ps.setString(2, cardID);
                            ps.executeUpdate();
                            System.out.println("密码修改成功");
                            s="密码修改成功";
                        }else {
                            System.out.println("两次密码不相同，请重新输入");
                            s="两次密码不相同，请重新输入";
                        }
                    }
                }else {
                    System.out.println("修改失败，密码长度不可小于6位");
                    s="修改失败，密码长度不可小于6位";
                }
            }else {
                System.out.println("原密码错误，请重新输入");
                s="原密码错误，请重新输入";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }

   }











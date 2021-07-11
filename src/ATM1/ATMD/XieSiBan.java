package ATM1.ATMD;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class XieSiBan extends JFrame {
    public static void main(String[] args) {
        try {
            // 加载MySql驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立数据库连接
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/text?useUnicode=true&characterEncoding=UTF8",
                    "root",
                    "123456");
            System.out.println("连接成功！");
            // 创建Statment对象
            Statement stmt = conn.createStatement();
            // 获取查询结果集
            ResultSet rs = stmt.executeQuery("SELECT date,id,password,balance FROM atm");
            System.out.println("查询成功！");


            String[][] data = new String[4][];
            for (int i = 0; rs.next(); i++) {
                data[i] = new String[]{
                        rs.getString("date"),
                        rs.getString("id"),
                        rs.getString("password"),
                        rs.getString("balance"),
                };
            }

            JFrame container;
            JTable jTable;

            String[] columnNames = { "交易日期","支出","收入","对方账号"};
            jTable = new JTable(data, columnNames);
            JScrollPane jScrollPane = new JScrollPane();
            jScrollPane.setViewportView(jTable);

            container = new JFrame("XieSiBan");
            container.setSize(500, 300);
            container.add(jScrollPane, BorderLayout.CENTER);
            container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            container.setVisible(true);

            //关闭资源
            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


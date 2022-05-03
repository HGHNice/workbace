import java.sql.*;

public class sql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:mysql://localhost:3306?useUnicode=true&characterEncoding=utf-8&SSL=true";
        String username="root";
        String password="123456";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from test.web ");
        while (resultSet.next()){
            resultSet.getObject("user");
            resultSet.getObject("pwd");

        }
        resultSet.close();
        statement.close();
        connection.close();

    }
}

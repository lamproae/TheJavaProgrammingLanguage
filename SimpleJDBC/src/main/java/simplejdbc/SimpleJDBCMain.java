package simplejdbc;

import java.sql.*;

public class SimpleJDBCMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stock", "kkkmmu", "leeweop");

        System.out.println("Database connected");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from stock");

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
            System.out.println(resultSet.getString("code") + "\t" + resultSet.getString("cn_name"));
        }

        connection.close();
    }
}

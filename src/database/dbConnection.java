package database;

import java.sql.*;

public class dbConnection {
    Connection Connect = null;

    public Connection DBConnectivity() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            Connection Connect = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            if (Connect != null) {
                System.out.println("Connected To Database Successfully");

                return Connect;
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Database Connection Unsuccessful");
            e.printStackTrace();

        }
        return null;
    }

    public void CloseConnection()throws SQLException{
        Connect.close();
        System.out.println("Database Connection Closed");
    }
}

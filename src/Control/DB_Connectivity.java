//package Control;
//
//import java.sql.*;
//
//public interface DB_Connectivity {
//    Connection Connect = null;
//
//    public default Connection DBConnectivity() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            //Connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
//            Connection Connect = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
//            if (Connect != null) {
//                System.out.println("Connected To Database Successfully");
//
//                return Connect;
//            }
//
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println("Database Connection Unsuccessful");
//            e.printStackTrace();
//
//        }
//        return null;
//    }
//
//    public default void CloseConnection()throws SQLException{
//        Connect.close();
//        System.out.println("Database Connection Closed");
//    }
//}
package DataBaseTesting;

import java.sql.*;

public class JdbcConnection {
    public static void main(String[] args) throws SQLException {
        String host = "localhost";
        String port = "3306";
        String database = "Qadbt";
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root", "password");
        Statement s = con.createStatement();
        ResultSet rs=s.executeQuery("select * from EmpolyeeInfo where designation = \"QA Engineer\";");
        while(rs.next()){
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("id"));
            System.out.println(rs.getString("location"));
        }
    }
}

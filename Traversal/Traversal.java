package Traversal;
import java.sql.*;
import java.util.ArrayList;

public class Traversal {
    final private String URL = "jdbc:mysql://localhost:3306/6_Degrees";
    final private String username = "root";
    final private String password = "Hunkerdown0809!";

    public ArrayList<String> traversing(String actorID1, String actorID2) {
        Connection databaseConnection;
        Statement statement;
        try {
            
            databaseConnection = DriverManager.getConnection(URL, username, password);
            statement = databaseConnection.createStatement();
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }

        

    }

    private ResultSet getResultSet(String id, String table, Statement statement) {
        ResultSet set = null;
        try {
            set = statement.executeQuery("SELECT " + id + " FROM " + table);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return set;
        }

        return set;
    }




}
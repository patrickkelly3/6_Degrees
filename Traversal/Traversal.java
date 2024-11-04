package Traversal;
import java.sql.*;
import java.util.ArrayList;

public class Traversal {
    
    
    public Connection connectToDatabase() {
        try {
            Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/6_Degrees", "root", "Hunkerdown0809!");
            return databaseConnection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    public ArrayList<String> traversing(String actorID1, String actorID2) {
        Connection databaseConnection = connectToDatabase();
        Statement statement;
        try {
            
            //databaseConnection = DriverManager.getConnection(URL, username, password);
            statement = databaseConnection.createStatement();

            ResultSet actor_1_set = getResultSet(actorID1, "ACTOR", statement);
            ResultSet actor_2_set = getResultSet(actorID2, "ACTOR", statement);

            ArrayList<String> path = new ArrayList<>();


            

        
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

    private ArrayList<String> actorTraversalRecursion (ArrayList<String> path, String actorID, int count) {

        
    }

    private ArrayList<String> movieTraversalRecursion(ArrayList<String> path, String movieId, int count) {

    }




}
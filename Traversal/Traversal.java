package Traversal;
import java.sql.*;
import java.util.ArrayList;

public class Traversal {
    
    private String actorID2;
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
        this.actorID2 = actorID2;
        
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

    private ArrayList<String> actorTraversalRecursion (ArrayList<String> path, String actorID, int count, Connection con) {
        path.add(actorID);
        if (count > 6)
            return null;
        else if (actorID.equals(this.actorID2))
            return path;

            try {
                Statement statement = con.createStatement();
                ResultSet set = getResultSet(actorID, "CAST", statement);
                ArrayList<String> loopPath = new ArrayList();
                while (set.next()) {
                    if (!set.getString("movieId").equals(actorID))
                        loopPath = movieTraversalRecursion(path, set.getString("movieId"), ++count, con);
                    if (loopPath != null)
                        break;
                }
    
                path.addAll(loopPath);
    
            } 
                catch (Exception e) {
            }
            
            return path;
        
    }

    private ArrayList<String> movieTraversalRecursion(ArrayList<String> path, String movieId, int count, Connection con) {
        path.add(movieId);
        if (count > 6)
            return null;
        
            try {
                Statement statement = con.createStatement();
                ResultSet set = getResultSet(movieId, "CAST", statement);
                ArrayList<String> loopPath = new ArrayList();
                while (set.next()) {
                    loopPath = movieTraversalRecursion(path, set.getString("movieId"), ++count, con);
                    if (loopPath != null)
                        break;
                }
    
                path.addAll(loopPath);
    
            } 
                catch (Exception e) {
            }
            
            return path;
    }

    




}
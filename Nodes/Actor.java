package Nodes;
public class Actor {
    
    private String id; //ID number of the actor for SQL Query referencing
    private String name; //Name of the Actor for user manipulation and understanding
    

    /**
     * 
     * @return String: ID number of the actor
     */
    public String getID() {
        return this.id;
    }

    /**
     * 
     * @return String: Name of the actor
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @param id
     */
    public void setID(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    
}
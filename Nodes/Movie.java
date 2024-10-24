package Nodes;

public class Movie {
    
    private String id; //Movie id for reference to the SQL Query
    private String name; //Movie name for user manipulation and understanding
    private String genre; //Movie genre for algorithm list reduction
    /**
     * 
     * @return String: id number of the movie
     */
    public String getID() {
        return this.id;
    }

    /**
     * 
     * @return String: the name of the movie
     */
    public String getName() {
        return this.name;
    }

    /**
     * 
     * @return String: genre of the movie
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * 
     * @param id : New id number to set Movie id variable to
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * 
     * @param name : New name of movie to set the variable to
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @param genre : New genre of movie to set the variable to
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
}

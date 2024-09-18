package Node;
import java.util.ArrayList;
class Actor {
    private String name;
    private ArrayList<Movie> movies;

    public Actor(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }
    
}
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private Director director;
    private List<Actor> actors;

    // Constructor
    public Movie(String title, Director director) {
        this.title = title;
        this.director = director;
        this.actors = new ArrayList<>();
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for director
    public Director getDirector() {
        return director;
    }

    // Setter for director
    public void setDirector(Director director) {
        this.director = director;
    }

    // Add an actor to the movie
    public void addActor(Actor actor) {
        actors.add(actor);
    }

    // Get list of actors
    public List<Actor> getActors() {
        return actors;
    }

    // Display full movie details
    public void displayMovieDetails() {
        System.out.println("\n🎬 Movie Title: " + title);
        System.out.print("🎬 Directed by: ");
        director.performRole();
        System.out.println("🎭 Cast:");
        for (Actor actor : actors) {
            actor.performRole();
        }
    }
}

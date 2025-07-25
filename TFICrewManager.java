import java.util.*;

public class TFICrewManager {

    static Scanner sc = new Scanner(System.in);
    static List<Actor> allActors = new ArrayList<>();
    static List<Director> allDirectors = new ArrayList<>();
    static List<Movie> allMovies = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n🎬==== TFI Crew Manager ====");
            System.out.println("1. Add Actor");
            System.out.println("2. Add Director");
            System.out.println("3. Create Movie");
            System.out.println("4. Assign Actors to Movie");
            System.out.println("5. View All Movies");
            System.out.println("6. Start Shooting Simulation");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addActor();
                case 2 -> addDirector();
                case 3 -> createMovie();
                case 4 -> assignActorsToMovie();
                case 5 -> viewAllMovies();
                case 6 -> startShooting();
                case 7 -> System.out.println("👋 Exiting... Jai TFI!");
                default -> System.out.println("❌ Invalid option. Try again.");
            }
        } while (choice != 7);
    }

    private static void addActor() {
        System.out.print("Enter actor name: ");
        String name = sc.nextLine();
        System.out.print("Enter actor age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter acting style: ");
        String style = sc.nextLine();
        Actor actor = new Actor(name, age, style);
        allActors.add(actor);
        System.out.println("✅ Actor added successfully.");
    }

    private static void addDirector() {
        System.out.print("Enter director name: ");
        String name = sc.nextLine();
        System.out.print("Enter director age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter genre speciality: ");
        String genre = sc.nextLine();
        Director director = new Director(name, age, genre);
        allDirectors.add(director);
        System.out.println("✅ Director added successfully.");
    }

    private static void createMovie() {
        if (allDirectors.isEmpty()) {
            System.out.println("❗ Please add at least one director first.");
            return;
        }

        System.out.print("Enter movie title: ");
        String title = sc.nextLine();

        // Choose director
        System.out.println("Select Director:");
        for (int i = 0; i < allDirectors.size(); i++) {
            System.out.println((i + 1) + ". " + allDirectors.get(i).getName());
        }
        int dIndex = sc.nextInt() - 1;
        sc.nextLine();

        Director selectedDirector = allDirectors.get(dIndex);
        Movie movie = new Movie(title, selectedDirector);
        allMovies.add(movie);
        System.out.println("✅ Movie created.");
    }

    private static void assignActorsToMovie() {
        if (allMovies.isEmpty()) {
            System.out.println("❗ Please create a movie first.");
            return;
        }

        System.out.println("Select Movie:");
        for (int i = 0; i < allMovies.size(); i++) {
            System.out.println((i + 1) + ". " + allMovies.get(i).getTitle());
        }
        int mIndex = sc.nextInt() - 1;
        sc.nextLine();
        Movie selectedMovie = allMovies.get(mIndex);

        // Add actors
        boolean adding = true;
        while (adding) {
            System.out.println("Available Actors:");
            for (int i = 0; i < allActors.size(); i++) {
                System.out.println((i + 1) + ". " + allActors.get(i).getName());
            }

            System.out.print("Choose actor number to add (or 0 to stop): ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 0) {
                adding = false;
            } else {
                Actor actor = allActors.get(choice - 1);
                selectedMovie.addActor(actor);
                System.out.println("✅ Actor assigned.");
            }
        }
    }

    private static void viewAllMovies() {
        if (allMovies.isEmpty()) {
            System.out.println("❗ No movies to display.");
            return;
        }

        for (Movie m : allMovies) {
            m.displayMovieDetails();
        }
    }

    private static void startShooting() {
        if (allMovies.isEmpty()) {
            System.out.println("❗ No movies created yet.");
            return;
        }

        System.out.println("Select Movie to Start Shooting:");
        for (int i = 0; i < allMovies.size(); i++) {
            System.out.println((i + 1) + ". " + allMovies.get(i).getTitle());
        }

        int mIndex = sc.nextInt() - 1;
        sc.nextLine();
        Movie movie = allMovies.get(mIndex);

        System.out.println("\n🎬 Shooting Simulation Started...");
        movie.getDirector().performRole();
        for (Actor actor : movie.getActors()) {
            actor.performRole();
        }
        System.out.println("🎉 Shooting Completed!");
    }
}

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    MovieCollection collection = new MovieCollection();

    boolean running = true;
    boolean searching;
    boolean editing;


public void start() {

        while (running) {
        System.out.println("Welcome to your movie collection! Type a number on the menu to perform the action.");
        System.out.println("");
        System.out.println("1. Add a movie");
        System.out.println("2. Search for a movie");
        System.out.println("3. Edit a movie in the collection");
        System.out.println("4. Exit");

        String menuAction = scanner.next();

        if (menuAction.equals("1")) {
            scanner.nextLine();

            System.out.println("Enter the title of the movie: ");
            String title = scanner.nextLine();

            System.out.println("Enter the name of the director: ");
            String director = scanner.nextLine();

            System.out.println("Enter the year the movie was released");
            int year = scanner.nextInt();

            System.out.println("Is the movie in color? (true/false): ");
            boolean colored = scanner.nextBoolean();
            scanner.nextLine();

            System.out.println("Enter the length of the movie in minutes: ");
            int length = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the genre of the movie: ");
            String genre = scanner.nextLine();

            Movie movie = new Movie(title, director, year, colored, length, genre);

            collection.addMovie(title, director, year, colored, length, genre);
            System.out.println("The movie has been added to your collection!");

        } else if (menuAction.equals("2")) {
            searching = true;
            scanner.nextLine();
            while (searching) {

                System.out.println("Search for a movie or type 'exit' to stop searching");
                String searchTerm = scanner.nextLine();
                Movie foundMovie = collection.searchMovie(searchTerm);

                if (searchTerm.equalsIgnoreCase("exit")) {
                    searching = false;
                }

                if (foundMovie != null) {
                    System.out.println("Movies found: " + foundMovie);
                } else {
                    System.out.println("No movie in the collection matches your search");
                }
            }
        } else if (menuAction.equals("3")) {
            scanner.nextLine();
            searching = true;
            while (searching) {

                System.out.println("Search for a movie or type 'exit' to stop searching");
                String searchTerm = scanner.nextLine();
                Movie foundMovie = collection.searchMovie(searchTerm);

                if (searchTerm.equalsIgnoreCase("exit")) {
                    searching = false;
                }

                if (foundMovie != null) {
                    System.out.println("Movie found: " + foundMovie);
                    System.out.println("Would you like to update this movie?");
                    System.out.println("1 = Yes / 2 = No");

                    if (scanner.nextLine().equalsIgnoreCase("2"))
                        searching = true;

                    if (scanner.nextLine().equalsIgnoreCase("1")) {
                        searching = false;
                        editing = true;


                        System.out.println("Enter new movie details.");
                        System.out.println("Enter new title: ");
                        String title = scanner.nextLine();

                        System.out.println("Enter new director: ");
                        String director = scanner.nextLine();

                        System.out.println("Enter new release year: ");
                        int year = Integer.parseInt(scanner.nextLine());

                        System.out.println("Is it in color? (true/false): ");
                        boolean isColor = Boolean.parseBoolean(scanner.nextLine());

                        System.out.println("Enter new length in minutes: ");
                        int length = Integer.parseInt(scanner.nextLine());

                        System.out.println("Enter new genre: ");
                        String genre = scanner.nextLine();

                        Movie updatedMovie = new Movie(title, director, year, isColor, length, genre);

                        collection.editMovie(searchTerm, updatedMovie);
                        System.out.println("Movie sucessfully updated");
                        searching = false;
                    }
                }
            }
        } else if (menuAction.equals("4")) {
            running = false;
        } else {
            System.out.println("Invalid command.");
        }

        System.out.println("Movies in your collection:");
        collection.listMovies();
    }
}
}

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    MovieCollection collection = new MovieCollection();

    boolean running = true;
    boolean searching;
    boolean editing;

    private int getInt(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a numerical value");
            }
        }
    }

    private boolean getBoo(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            } else {
                System.out.println("Please enter true or false");
            }
        }
    }

    public void start() {
        collection.loadFile("samling.txt");

        while (running) {
            System.out.println("Welcome to your movie collection! Type a number on the menu to perform the action.");
            System.out.println("");
            System.out.println("1. Add a movie");
            System.out.println("2. Search for a movie");
            System.out.println("3. Edit a movie in the collection");
            System.out.println("4. Delete a movie in the collection");
            System.out.println("5. Exit / View a list of the movies in the collection");

            String menuAction = scanner.next();

            if (menuAction.equals("1")) {
                scanner.nextLine();

                System.out.println("Enter the title of the movie: ");
                String title = scanner.nextLine();

                System.out.println("Enter the name of the director: ");
                String director = scanner.nextLine();

                System.out.println("Enter the year the movie was released");
                int year = getInt("");

                System.out.println("Is the movie in color? (true/false): ");
                boolean colored = getBoo("");

                System.out.println("Enter the length of the movie in minutes: ");
                int length = getInt("");

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
                            int year = getInt("");

                            System.out.println("Is it in color? (true/false): ");
                            boolean isColor = getBoo("");

                            System.out.println("Enter new length in minutes: ");
                            int length = getInt("");

                            System.out.println("Enter new genre: ");
                            String genre = scanner.nextLine();

                            Movie updatedMovie = new Movie(title, director, year, isColor, length, genre);

                            collection.editMovie(searchTerm, updatedMovie);
                            System.out.println("Movie sucessfully updated");
                            searching = false;
                        } else {
                            System.out.println("Invalid input. Please enter '1' or '2' ");
                        }
                    }
                }
            } else if (menuAction.equals("4")) {
                scanner.nextLine();
                searching = true;
                while (searching) {
                    System.out.println("Search for a movie to delete or type 'exit' to stop searching.");
                    String searchTerm = scanner.nextLine();

                    if (searchTerm.equalsIgnoreCase("exit")) {
                        searching = false;
                        break;
                    }

                    Movie foundMovie = collection.searchMovie(searchTerm);
                    if (foundMovie != null) {
                        System.out.println("Movie found: " + foundMovie);
                        System.out.println("Are you sure you want to delete this movie?");
                        System.out.println("1 = Yes / 2 = No");

                        String confirmation = scanner.nextLine();
                        if (confirmation.equals("1")) {
                            boolean deleted = collection.deleteMovie(foundMovie.getTitle());
                            if (deleted) {
                                System.out.println("Movie successfully deleted.");
                            } else {
                                System.out.println("Error: Movie could not be deleted.");
                            }
                            searching = false;
                        } else {
                            System.out.println("Deletion canceled.");
                            searching = false;
                        }
                    } else {
                        System.out.println("No movie in the collection matches your search.");
                    }
                }

            } else if (menuAction.equals("6")) {
                running = false;
            } else {
                System.out.println("Invalid command.");
            }

            System.out.println("Movies in your collection:");
            collection.listMovies();
            collection.saveFile("samling.txt");
        }
    }
}

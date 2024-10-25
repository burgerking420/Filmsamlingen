import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();

        boolean running = true;

        while (running) {
            System.out.println("Welcome to your movie collection! Type a number on the menu to perform the action.");
            System.out.println("");
            System.out.println("1. Add a movie");
            System.out.println("2. Exit");

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
                Boolean colored = scanner.nextBoolean();
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
                running = false;
            } else {
                System.out.println("Invalid command.");
            }

            System.out.println("Movies in your collection:");
            collection.listMovies();
        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class MovieCollection {
    private ArrayList<Movie> movies = new ArrayList<>();

    public void addMovie(String title, String director, int year, boolean colored, int length, String genre) {
        Movie movie = new Movie(title, director, year, colored, length, genre);
        movies.add(movie);
    }

    public ArrayList<Movie> getMovieCollectionList() {
        return new ArrayList<>(movies);
    }

    public void listMovies() {
        if (movies.isEmpty()) {
            System.out.println("There are currently no movies in this collection..");
        } else {
            for (Movie movie : movies) {
                System.out.println(movie);

                Collections.sort(movies, Comparator.naturalOrder());
            }
        }
    }

    public void saveFile(String filename) {
        try (PrintStream out = new PrintStream(filename)) {
            for(Movie movie : movies) {
                out.println(movie.getTitle() + "," + movie.getDirector() + "," + movie.getYear() + "," + movie.isColored() + "," + movie.getLength() + "," + movie.getGenre() + ".");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


public void loadFile(String filename) {
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNext()) {
               String[] data = fileScanner.nextLine().split(",");
               if (data.length == 6) {
                   String title = data[0];
                   String director = data[1];
                   int year = Integer.parseInt(data[2]);
                   boolean colored = Boolean.parseBoolean(data[3]);
                   int length = Integer.parseInt(data[4]);
                   String genre = data[5];
                   movies.add(new Movie(title, director, year, colored, length, genre));
               }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No movies found in the collection, time to get started!");
        }
}

    public Movie searchMovie(String searchTerm) {
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                return movie;
            }
        }
        return null;
    }

    public boolean deleteMovie(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().toLowerCase().contains(title.toLowerCase())) {
                movies.remove(movie);
                return true;
            }
        }
        return false;
    }


    public void editMovie(String searchTerm, Movie updatedMovie) {
        Movie movie = searchMovie(searchTerm);
        if (movie != null) {
            movie.setTitle(updatedMovie.getTitle());
            movie.setDirector(updatedMovie.getDirector());
            movie.setYear(updatedMovie.getYear());
            movie.setColored(updatedMovie.isColored());
            movie.setLength(updatedMovie.getLength());
            movie.setGenre(updatedMovie.getGenre());
        } else {
            System.out.println("There are no movies to edit..");
        }
    }
}
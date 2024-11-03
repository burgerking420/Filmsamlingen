import java.util.ArrayList;

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
            }
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
import java.util.ArrayList;

public class MovieCollection {
private ArrayList<Movie> movies = new ArrayList<>();

public void addMovie(String title, String director, int year, boolean colored, int length, String genre){
    Movie movie = new Movie(title, director, year, colored, length, genre);
    movies.add(movie);
}

public void listMovies() {
    if (movies.isEmpty()){
        System.out.println("There are currently no movies in this collection..");
    } else {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
}

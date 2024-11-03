import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class MovieCollectionTest {

    @Test
    void addMovie() {
        // Arrange
        MovieCollection samling = new MovieCollection();
        Movie film = new Movie("Dexter", "Harry Morgan", 1983, true, 35, "Thriller");
        samling.addMovie("Dexter", "Harry Morgan", 1983, true, 35, "Thriller");

        // Act
        String actualResult = film.getTitle();

        // Assert
        String expectedResult = "Dexter";
        assertEquals(actualResult, expectedResult);
    }


    @Test
    void listMovies() {
        // Arrange
        MovieCollection filmSamling = new MovieCollection();
        filmSamling.addMovie("Dexter", "Jeff Lindsay", 2006, true, 35, "Thriller");
        filmSamling.addMovie("Audition", "Takashi Miike", 1999, true, 115, "Horror");
        filmSamling.addMovie("Martyrs", "Pascal Laugier", 2008, true, 99, "Horror");
        int actualResult = filmSamling.getMovieCollectionList().size();

        // Act
        int expectedResult = 3;

        // Assert
        assertEquals(actualResult, expectedResult);



    }
}
public class Movie {
private String title;
private String director;
private int year;
private boolean colored;
private int length;
private String genre;

public Movie(String title, String director, int year, boolean colored, int length, String genre){
    this.title = title;
    this.director = director;
    this.year = year;
    this.colored = colored;
    this.length = length;
    this.genre = genre;
}

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public boolean isColored() {
        return colored;
    }

    public int getLength() {
        return length;
    }

    public String getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
    return "Title: " + title + ", Director: " + director + ", Year: " + year + ", Color:" + isColored() + ", Length: " + length + " minutes" + ", Genre: " + genre;
    }
}


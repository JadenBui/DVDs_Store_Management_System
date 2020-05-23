package Movie;

import java.util.Arrays;

public class Movie {
    private String title;
    private String starring;
    private String director;
    private String duration;
    private MovieType.Genre genre;
    private MovieType.Classification classification;
    private String releaseDate;
    private int borrowedTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStarring() {
        return starring;
    }

    public void setStarring(String starring) {
        this.starring = starring;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public MovieType.Genre getGenre() {
        return genre;
    }

    public void setGenre(MovieType.Genre genre) {
        this.genre = genre;
    }

    public MovieType.Classification getClassification() {
        return classification;
    }

    public void setClassification(MovieType.Classification classification) {
        this.classification = classification;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getBorrowedTime(){
        return this.borrowedTime;
    }

    public void isBorrowed(){
        int newBorrowedTime = this.borrowedTime + 1;
        this.borrowedTime = newBorrowedTime;
    }

    public Movie(String title, String starring, String director, String duration, MovieType.Genre genre, MovieType.Classification classification, String releaseDate){
        this.title = title;
        this.starring = starring;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
        this.classification = classification;
        this.releaseDate = releaseDate;
        this.borrowedTime = 0;
    }
    public static void main(String[] args) {
        Movie movie2 = new Movie("b","b","b","b", MovieType.Genre.ACTION, MovieType.Classification.PG,"b");
        Movie movie1 = new Movie("a","a","a","a", MovieType.Genre.ACTION, MovieType.Classification.PG,"a");
        Movie movie4 = new Movie("b","b","b","b", MovieType.Genre.ACTION, MovieType.Classification.PG,"b");
        Movie movie3 = new Movie("b","b","b","b", MovieType.Genre.ACTION, MovieType.Classification.PG,"b");
        Movie movie5 = new Movie("b","b","b","b", MovieType.Genre.ACTION, MovieType.Classification.PG,"b");
        movie2.isBorrowed();
        movie2.isBorrowed();
        movie1.isBorrowed();
        movie3.isBorrowed();
        movie3.isBorrowed();
        movie3.isBorrowed();
        movie4.isBorrowed();
        movie4.isBorrowed();
        movie4.isBorrowed();
        movie4.isBorrowed();
        movie5.isBorrowed();
        movie5.isBorrowed();
        movie5.isBorrowed();
        movie5.isBorrowed();
        movie5.isBorrowed();
        Movie[] movieList = new Movie[5];
        movieList[0] = movie2;
        movieList[1] = movie1;
        movieList[2] = movie4;
        movieList[3] = movie3;
        movieList[4] = movie5;
    }

    @Override
    public String toString() {
        return
                "Title='" + title + '\'' +
                ", Starring='" + starring + '\'' +
                ", Director='" + director + '\'' +
                ", Duration='" + duration + '\'' +
                ", Genre='" + genre + '\'' +
                ", Classification='" + classification + '\'' +
                ", ReleaseDate='" + releaseDate + '\''
                ;
    }
}

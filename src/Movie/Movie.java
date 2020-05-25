package Movie;

import java.util.Arrays;

public class Movie {
    private String title;
    private String starring;
    private String director;
    private int duration;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
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
        this.borrowedTime ++;
    }

    public Movie(String title, String starring, String director, int duration, MovieType.Genre genre, MovieType.Classification classification, String releaseDate){
        this.title = title;
        this.starring = starring;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
        this.classification = classification;
        this.releaseDate = releaseDate;
        this.borrowedTime = 0;
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

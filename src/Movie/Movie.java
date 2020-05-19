package Movie;

public class Movie {
    private String title;
    private String starring;
    private String director;
    private String duration;
    private String genre;
    private String classification;
    private String releaseDate;

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Movie(String title, String starring, String director, String duration, String genre, String classification, String releaseDate){
        this.title = title;
        this.starring = starring;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
        this.classification = classification;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", starring='" + starring + '\'' +
                ", director='" + director + '\'' +
                ", duration='" + duration + '\'' +
                ", genre='" + genre + '\'' +
                ", classification='" + classification + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}

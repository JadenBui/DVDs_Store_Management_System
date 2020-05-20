package Movie;

public class MovieType {
    public enum Genre {DRAMA, ADVENTURE, FAMILY, ACTION, SCI_FI, COMEDY, ANIMATED, THRILLER, OTHER}
    public enum Classification {G, PG, M15, MA15}

    public void getAllGenre(){
        int order = 1;
        Genre genres[] = Genre.values();
        for(Genre genre : genres){
            System.out.println(order+". "+genre);
            order++;
        }
    }

    public void getAllClassification(){
        int order = 1;
        Classification classifications[] = Classification.values();
        for(Classification classification : classifications){
            System.out.println(order+". "+classification);
            order++;
        }
    }
}

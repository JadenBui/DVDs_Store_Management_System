package Movie;

public class Node {
    int numberOfDvd;
    Movie movie;
    Node leftNode;
    Node rightNode;

    public Node(Movie movie, int numberOfDvd){
        this.movie = movie;
        this.numberOfDvd = numberOfDvd;
    }

    public int getNumberOfDvd() {
        return numberOfDvd;
    }

    public void setNumberOfDvd(int numberOfDvd) {
        this.numberOfDvd = numberOfDvd;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "movie=" + movie.getTitle() +
//                " ,numberOfDvd=" + numberOfDvd +
//                ", leftNode=" + leftNode +
//                ", rightNode=" + rightNode +
//                '}';
//    }
    @Override
    public String toString() {
        return "{" +
                "Title= '" + movie.getTitle() +
                "' ,Copies='" + numberOfDvd +
                "', Movie Detail='" + movie +
                "'"+'}';
    }
}

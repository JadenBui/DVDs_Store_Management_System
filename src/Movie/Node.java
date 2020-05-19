package Movie;

public class Node {
    Movie movie;
    Node leftNode;
    Node rightNode;

    public Node(Movie movie){
        this.movie = movie;
    }

    public Movie getValue(){
        return movie;
    }

    public void setValue(Movie movie){
        this.movie = movie;
    }

    public Node getLeftNode(){
        return leftNode;
    }

    public void setLeftNode(Node node){
        this.leftNode = node;
    }

    public Node getRightNode(){
        return rightNode;
    }

    public void setRightNode(Node node){
        this.rightNode = node;
    }

}

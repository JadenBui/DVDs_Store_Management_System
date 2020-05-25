package Movie;

import Menu.MainMenu;

public class MovieCollection {
    static int movieNumber = 0;
    static int orderNumber = 0;
    static Node[] movieRankList;
    private Node root;
    public MovieCollection(){
        if(movieRankList == null){
            movieRankList = new Node[20];
        }
    }

    public Node getRootMovie(){
        return root;
    }

    public Movie[] getMovieRankList(){
        Movie[] movies = new Movie[movieNumber];
        //only fill the array with exist data
        for(int i = 0; i < movieNumber; i++){
            if(movieRankList[i] == null){break;}
            movies[i] = movieRankList[i].getMovie();
        }
        return movies;
    }

    public void getMovieRanking(Node focusNode){
        //re-initialize the ranking list
        initializeMovieList(focusNode);
        Algorithms algorithms = new Algorithms();
        //sort the list according to the borrow frequency
        Movie[] newList = algorithms.countSort(getMovieRankList());
        for(int i = movieNumber - 1; i >= 0; i--){
            System.out.println(movieNumber-i+". "+newList[i]);
        }
        //reset number for initializeMovieList function
        orderNumber = 0;
    }

    public void addMovieNode(Movie movie, int numberOfDvd){
        Node newNode = new Node(movie,numberOfDvd);
        movieNumber++;
        if(root == null){
            root = newNode;
        }
        else{
            Node focusNode = root;
            Node parent;
            //find a proper position to add node based on the movie title
            while(true){
               parent = focusNode;
               if(newNode.movie.getTitle().toLowerCase().compareTo(focusNode.movie.getTitle().toLowerCase()) > 0){
                   focusNode = focusNode.rightNode;
                   if(focusNode == null){
                       parent.rightNode = newNode;
                       return;
                   }
               }else{
                   focusNode = focusNode.leftNode;
                   if(focusNode == null){
                       parent.leftNode = newNode;
                       return;
                   }
               }
            }
        }
    }

    public boolean deleteMovie(String title){
        Node focusNode = root;
        Node parent = root;
        if(parent == null){
            return false;
        }
        //Move to the node to be deleted
        while(focusNode.movie.getTitle().toLowerCase().compareTo(title) != 0){
            parent = focusNode;
            if(title.compareTo(focusNode.movie.getTitle().toLowerCase()) < 0){
                focusNode = focusNode.leftNode;
            }else{
                focusNode = focusNode.rightNode;
            }
            if(focusNode == null){return false;}
        }
        //Node to be deleted has 1 child or 0 children (is a leaf)
        if(focusNode.leftNode == null || focusNode.rightNode == null){
            Node replacementNode;
            if(focusNode.rightNode == null){
                replacementNode = focusNode.leftNode;
            }else{
                replacementNode = focusNode.rightNode;
            }
            if(focusNode == root){root = replacementNode;}
            else if(parent.rightNode == focusNode){
                parent.rightNode = replacementNode;
            }else{
                parent.leftNode = replacementNode;
            }
            //Node to be deleted has 2 children
        }else if(focusNode.leftNode != null && focusNode.rightNode != null){
            //Find the replacement node in order successor
            if(focusNode.rightNode.leftNode == null){
                //Preserve the left children of the deleted node
                focusNode.movie= focusNode.rightNode.movie;
                focusNode.numberOfDvd = focusNode.rightNode.numberOfDvd;
                //Carry on the right branch of the replacement node (if has one)
                focusNode.rightNode = focusNode.rightNode.rightNode;
            }else{
                //Find the node that is the smallest in order successor
                Node replacementNode = focusNode.rightNode;
                while(replacementNode.leftNode != null){
                    parent = replacementNode;
                    replacementNode = replacementNode.leftNode;
                }
                focusNode.movie = replacementNode.movie;
                focusNode.numberOfDvd = replacementNode.numberOfDvd;
                //Carry on the right branch of the replacement node
                parent.leftNode = replacementNode.rightNode;
            }
        }
        movieNumber--;
        return true;
    }

    public Node searchMovie(String movieTitle){
        Node focusNode = root;
        //recursively search for a node
        while(true){
            if(focusNode.movie.getTitle().toLowerCase().compareTo(movieTitle.toLowerCase()) == 0){return focusNode;}
            if(movieTitle.toLowerCase().compareTo(focusNode.movie.getTitle().toLowerCase()) < 0){
                focusNode = focusNode.leftNode;
            }else{
                focusNode = focusNode.rightNode;
            }
            if(focusNode == null){return null;}
        }
    }

    public void getAllMovies(Node focusNode){
        //re-initialize the movie list
        initializeMovieList(focusNode);
        for(int i = 0; i < orderNumber; i++){
            System.out.println(i+1+". "+"Copies: "+movieRankList[i].getNumberOfDvd()+", "+movieRankList[i].movie);
        }
        orderNumber = 0;
    }

    public void addMovieToRanking(Node node){
        //add movie into the ranking list
        movieRankList[orderNumber] = node;
        orderNumber++;
    }

    public void initializeMovieList(Node focusNode){
        //visit node by node in the binary search tree
        if(focusNode != null){
            initializeMovieList(focusNode.leftNode);
            addMovieToRanking(focusNode);
            initializeMovieList(focusNode.rightNode);
        }
    }
}

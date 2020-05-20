package Movie;

public class MovieCollection {
    static int movieNumber = 0;
    private Node root;
    public MovieCollection(){}

    public Node getRootMovie(){
        return root;
    }

    public void addMovieNode(Movie movie, int numberOfDvd){
        Node newNode = new Node(movie,numberOfDvd);
        if(root == null){
            root = newNode;
        }
        else{
            Node focusNode = root;
            Node parent;
            while(true){
               parent = focusNode;
               if(newNode.movie.getTitle().compareTo(focusNode.movie.getTitle()) > 0){
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

    public Boolean deleteMovie(String title){
        Node focusNode = root;
        Node parent = root;
        if(parent == null){
            return false;
        }
        //Move to the node to be deleted
        while(focusNode.movie.getTitle().compareTo(title) != 0){
            parent = focusNode;
            if(title.compareTo(focusNode.movie.getTitle()) < 0){
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
        return true;
    }

    public Node searchMovie(String movieTitle){
        Node focusNode = root;
        while(true){
            System.out.println(focusNode.movie.getTitle());
            if(focusNode.movie.getTitle().compareTo(movieTitle) == 0){return focusNode;}
            if(movieTitle.compareTo(focusNode.movie.getTitle()) < 0){
                focusNode = focusNode.leftNode;
            }else{
                focusNode = focusNode.rightNode;
            }
            if(focusNode == null){return null;}
        }
    }

    public void getAllMovies(Node focusNode){
        if(focusNode != null){
            getAllMovies(focusNode.leftNode);
            System.out.println(movieNumber + ". " +focusNode);
            movieNumber++;
            getAllMovies(focusNode.rightNode);
        }
    }

    public static void main(String[] args) {
        MovieCollection movieList = new MovieCollection();
        Movie Kaite = new Movie("Kaite Sexy",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Gorilla = new Movie("Gorilla Amazing",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Dog = new Movie("Dog Adventure",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Bee = new Movie("Bee Animal",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie AmazingWomen = new Movie("AmazingWomen Movie",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Cat = new Movie("Cat Show",
        "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Funny = new Movie("Funny Guy",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Elephant = new Movie("Elephant Wing",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Jupiter = new Movie("Jupiter universal",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Incredible = new Movie("Incredible Family",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Versace = new Movie("Versace HighEnd",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Quantum = new Movie("Quantum Science",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Yummi = new Movie("Yummi Cat",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Zelda = new Movie("Zelda Warrior",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Octopus = new Movie("Octopus Prime",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Warrior = new Movie("Warrior Ultimate",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");

        movieList.addMovieNode(Kaite,150);
        movieList.addMovieNode(Gorilla,151);
        movieList.addMovieNode(Dog,1502);
        movieList.addMovieNode(Bee,15012);
        movieList.addMovieNode(AmazingWomen,1555);
        movieList.addMovieNode(Cat,1235);
        movieList.addMovieNode(Funny,1501);
        movieList.addMovieNode(Elephant,1505);
        movieList.addMovieNode(Jupiter,123);
        movieList.addMovieNode(Incredible,252);
        movieList.addMovieNode(Versace,355);
        movieList.addMovieNode(Quantum,2532);
        movieList.addMovieNode(Yummi,1232);
        movieList.addMovieNode(Zelda,6543);
        movieList.addMovieNode(Octopus,3452);
        movieList.addMovieNode(Warrior,5464);


        movieList.deleteMovie("AmazingWomen Movie");
        movieList.getAllMovies(movieList.root);
    }

}

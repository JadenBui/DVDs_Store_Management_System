package Menu;

import Movie.Movie;
import Movie.MovieType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StaffMenu implements Menu{
    public void getMenu(){
        System.out.println("====================== STAFF ======================");
        System.out.println("1. Add DVDs of a new movie to the software application");
        System.out.println("2. Remove a movie DVD from the software application");
        System.out.println("3. Register a member with the software application");
        System.out.println("4. Find a member’s contact phone number, given the member’s full name");
    }

    public Object[] getMovieInputs(){
        Object[] inputs = new Object[2];
        MovieType movieType = new MovieType();
        Scanner movieInput = new Scanner(System.in);
        System.out.print("Please type in the movie title:");
        String title = movieInput.nextLine();
        System.out.print("Please type in the starting actor: ");
        String starting = movieInput.nextLine();
        System.out.print("Please type in the movie director: ");
        String director = movieInput.nextLine();
        System.out.print("Please type in the movie duration (minutes): ");
        String duration = movieInput.nextLine();
        System.out.print("Please type in the movie release (year): ");
        String release = movieInput.nextLine();
        System.out.println("Please choose the movie genre: ");
        movieType.getAllGenre();
        System.out.println("Your choice: ");
        int genreChoice = movieInput.nextInt();
        MovieType.Genre genre = MovieType.Genre.values()[genreChoice - 1];
        System.out.println("Please choose the movie classification: ");
        movieType.getAllClassification();
        System.out.println("Your choice: ");
        int classificationChoice = movieInput.nextInt();
        MovieType.Classification classification = MovieType.Classification.values()[classificationChoice - 1];
        Movie newMovie = new Movie(title,starting,director,duration,genre,classification,release);
        System.out.println("Please enter the number of DVD: ");
        int numberOfCopies = movieInput.nextInt();
        inputs[0] = newMovie;
        inputs[1] = numberOfCopies;
        return inputs;
    }

    public void getNextMove(){
        System.out.println("What do you want to do next?");
        System.out.println("1. Back to Staff Menu");
        System.out.println("2. Back to Main Menu");
        System.out.println("3. Exit program");
        System.out.print("Your choice: ");
    }

    public void staffLogin(){
        Scanner staffInput = new Scanner(System.in);
        String username;
        int password;
        do{
            System.out.print("username: ");
            username = staffInput.next();
            if(username.compareTo("staff") != 0){
                System.out.println("Wrong username, please try again!");
            }else{
                break;
            }
        }while (true);
        do{
            System.out.print("password: ");
            try{
                password = staffInput.nextInt();
                if(password != 1234){
                    System.out.println("Wrong password, please try again!");
                }else{
                    break;
                }
            }catch (InputMismatchException e){
                System.out.println("Password format invalid, please enter number only!");
                staffInput.next();
            }

        }while (true);
        System.out.println("=============================Login in successful!=============================\n");
    }
}

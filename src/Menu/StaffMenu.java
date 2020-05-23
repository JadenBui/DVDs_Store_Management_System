package Menu;

import Movie.Movie;
import Movie.MovieCollection;
import Movie.MovieType;
import User.Member;
import User.MemberCollection;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StaffMenu implements Menu{
    MainMenu mainMenu;
    public StaffMenu() {
        mainMenu = new MainMenu();
    }

    public void getMenu(){
        System.out.println("====================== STAFF ======================");
        System.out.println("1. Add DVDs of a new movie to the software application");
        System.out.println("2. Remove a movie DVD from the software application");
        System.out.println("3. Register a member with the software application");
        System.out.println("4. Find a member’s contact phone number, given the member’s full name");
        System.out.println("-1. Return to Main Menu");
        System.out.println("===================================================");
        System.out.print("Please enter your choice: ");

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
        System.out.print("Your choice: ");
        int genreChoice = movieInput.nextInt();
        MovieType.Genre genre = MovieType.Genre.values()[genreChoice - 1];
        System.out.println("Please choose the movie classification: ");
        movieType.getAllClassification();
        System.out.print("Your choice: ");
        int classificationChoice = movieInput.nextInt();
        MovieType.Classification classification = MovieType.Classification.values()[classificationChoice - 1];
        Movie newMovie = new Movie(title,starting,director,duration,genre,classification,release);
        System.out.print("Please enter the number of DVD: ");
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

    public boolean getDeleteMovie(MovieCollection movieCollection){
        if(movieCollection.getRootMovie() == null){
            System.out.println("There is no movie exist in the system, please add more!");
        }
        outer: while (true){
            Scanner movieDeleteInput = new Scanner(System.in);
            System.out.print("Please type in the movie title: ");
            String titleDelete = movieDeleteInput.nextLine();
            Boolean result = movieCollection.deleteMovie(titleDelete.toLowerCase());
            if(result){
                System.out.println("The movie is deleted!");
                System.out.println("Here is the current movie list: ");
                movieCollection.getAllMovies(movieCollection.getRootMovie());
                return true;
            }else {
                System.out.println("Sorry, the movie is not exist!");
                System.out.println("Do you want to retry? (Y/N)");
                String choice = mainMenu.getValidStringInput();
                if(choice.compareTo("y") == 0){
                    continue outer;
                }else{
                    break;
                }

            }

        }
        return false;
    }

    public void getContactDetail(MemberCollection memberCollection){
        outer:while(true){
            Scanner memberInputs = new Scanner(System.in);
            System.out.print("Please enter the member full name: ");
            String name = memberInputs.nextLine();
            Member foundMember = memberCollection.searchMember(name);
            if(foundMember == null){
                System.out.println("Sorry, user not found!");
                System.out.println("Do you want to retry? (Y/N)");
                String choice = mainMenu.getValidStringInput();
                if(choice.compareTo("y") == 0){
                    continue outer;
                }else{
                    break;
                }
            }else{
                System.out.println("The member contact info: \n"
                        + "1. Phone number: " + foundMember.getPhone() + "\n"
                        + "2. Address: " + foundMember.getAddress() + "\n");
            }
        }
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

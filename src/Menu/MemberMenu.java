package Menu;

import Movie.MovieCollection;
import Movie.Node;
import User.Member;
import User.MemberCollection;

import java.util.Scanner;

public class MemberMenu implements Menu{
    @Override
    public void getMenu() {
        System.out.println("====================== MEMBER ======================");
        System.out.println("1. Show all movies");
        System.out.println("2. Borrow a movie DVD");
        System.out.println("3. Return a movie DVD");
        System.out.println("4. List all current borrowed movie DVDSs");
        System.out.println("5. Display top 10 most popular movies");
        System.out.println("-1. Return to main Menu");
        System.out.println("====================================================");
        System.out.print("Please enter your choice: ");
    }

    //Get all movies in the system
    public void getAllMovies(MovieCollection movieCollection){
        if(movieCollection.getRootMovie() == null){
            System.out.println("Sorry, there's no movie in the library yet!");
        }else{
            System.out.println("======================================================================== MOVIES ========================================================================");
            movieCollection.getAllMovies(movieCollection.getRootMovie());
            System.out.println("========================================================================================================================================================");
        }
    }

    //Login helper function for member
    public String memberLogin(MemberCollection memberCollection){
        MainMenu mainMenu = new MainMenu();
        Scanner memberInput = new Scanner(System.in);
        String username;
        int password;
        System.out.println("====================== Login ======================");
        inner :do{
            System.out.print("username: ");
            username = memberInput.nextLine();
            if(username.contains(" ")){
                System.out.println("Sorry, you can't have blank space in username!");
                continue inner;
            }
            if(memberCollection.searchMember(username) != null){
                break;
            }else{
                System.out.print("Sorry, user not found! \n"+
                        "Try again? (Y/N) \n");
                String choice = mainMenu.getValidStringInput();
                if(choice.equals("y")){
                    continue inner;
                }else{
                    return null;
                }
            }
        }while (true);

         do{
             System.out.print("password: ");
             password = mainMenu.getValidIntInput();
             if(password == memberCollection.searchMember(username).getPassword()){
                 System.out.println("===================================================");
                 return username;
             }else{
                 System.out.println("Wrong password!");
             }
        }while (true);
    }

    //Get next choice of the user
    public void getNextMove(){
        System.out.println("============================");
        System.out.println("What do you want to do next?");
        System.out.println("1. Back to Member Menu");
        System.out.println("2. Back to Main Menu");
        System.out.println("3. Exit program");
        System.out.println("============================");
        System.out.print("Your choice: ");
    }

    //Borrow movie
    public void getBorrowMovie( MovieCollection movieCollection, MemberCollection memberCollection,String member){
        MainMenu mainMenu = new MainMenu();
        MemberMenu memberMenu = new MemberMenu();
        if(movieCollection.getRootMovie() == null){
            System.out.println("Sorry, there's no movie to borrow yet!");
        }else{
            borrow: while(true){
                Node borrowMovie = memberMenu.searchBorrowMovie(movieCollection);
                if(borrowMovie != null){
                    Member memberBorrow = memberCollection.searchMember(member);
                    if(memberBorrow.movieInBorrowList(borrowMovie.getMovie().getTitle())){
                        System.out.println("You have already rent this movie!");
                        break borrow;
                    }
                    memberCollection.borrowDVD(borrowMovie,memberBorrow);
                    break borrow;
                }else{
                    System.out.println("Sorry, the movie is not exist!");
                    System.out.println("Try again (Y/N) ?");
                    String retry = mainMenu.getValidStringInput();
                    if(retry.toLowerCase().compareTo("y") == 0){
                        continue borrow;
                    }else{
                        break borrow;
                    }
                }
            }
        }
    }


    //Search for the movie to rent
    public Node searchBorrowMovie(MovieCollection movieList) {
        Scanner movieInput = new Scanner(System.in);
        System.out.print("Please type in the movie title: ");
        String movieTitle = movieInput.nextLine();
        Node foundMovie = movieList.searchMovie(movieTitle);
        if(foundMovie == null){
            return  null;
        }
        return foundMovie;
    }

    //Return movie
    public void returnBorrowMovie(MemberCollection memberCollection, MovieCollection movieCollection, String member){
        MainMenu mainMenu = new MainMenu();
        Scanner returnInput = new Scanner(System.in);
        Member currentMem = memberCollection.searchMember(member);
        if(movieCollection.getRootMovie() == null){
            System.out.println("The movie library is empty!");
            return;
        }
        if(currentMem.borrowListIsEmpty()){
            System.out.println("You have not borrow any movie!");
        }else{
            returnMovie: while(true){
                Boolean isReturned = memberCollection.returnBorrowedDVD(member,memberCollection,movieCollection);
                if(isReturned == true){
                    System.out.println("You have successfully returned the movie!");
                    break returnMovie;
                }else{
                    System.out.print("Return the movie failed! \n"
                            +"Try again ? (Y/N) \n");
                    String retry = mainMenu.getValidStringInput();
                    if(retry.toLowerCase().compareTo("y") == 0){
                        continue returnMovie;
                    }else{
                        break;
                    }
                }
            }
        }
    }

    //Get credentials of new user to register
    public Member getNewMemberCredentials(){
        MainMenu mainMenu = new MainMenu();
        Member newMember;
        Scanner memberInputs = new Scanner(System.in);
        System.out.println("Please enter the user credentials: ");
        System.out.print("Full Name: ");
        String newName = memberInputs.nextLine();
        System.out.print("Address: ");
        String newAddress = memberInputs.nextLine();
        System.out.print("Phone: ");
        String newPhone = memberInputs.nextLine();
        System.out.print("Username: ");
        String newUserName = memberInputs.nextLine();
        System.out.print("Password: ");
        int newPassword = mainMenu.getValidIntInput();
        newMember = new Member(newUserName,newPassword,newName,newAddress,newPhone);
        return newMember;
    }
}

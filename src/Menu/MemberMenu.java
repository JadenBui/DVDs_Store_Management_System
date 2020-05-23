package Menu;

import Movie.Movie;
import Movie.MovieCollection;
import Movie.Node;
import User.Member;
import User.MemberCollection;

import java.util.Arrays;
import java.util.InputMismatchException;
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
    }

    public String memberLogin(MemberCollection memberCollection){
        Scanner memberInput = new Scanner(System.in);
        String username;
        int password;
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
                        "Try again? (Y/N): ");
                String choice = memberInput.nextLine();
                if(choice.equals("y")){
                    continue inner;
                }else{
                    return null;
                }
            }
        }while (true);

         do{
            try{
                System.out.print("password: ");
                password = memberInput.nextInt();
                if(password == memberCollection.searchMember(username).getPassword()){
                    return username;
                }else{
                    System.out.println("Wrong password!");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid input, please type in number only!");
                memberInput.next();
            }
        }while (true);
    }

    public void getNextMove(){
        System.out.println("What do you want to do next?");
        System.out.println("1. Back to Member Menu");
        System.out.println("2. Back to Main Menu");
        System.out.println("3. Exit program");
        System.out.print("Your choice: ");
    }

    public Node getBorrowMovie(MovieCollection movieList) {
        loop:
        while (true) {
            Scanner movieInput = new Scanner(System.in);
            System.out.print("Please type in the movie title: ");
            String movieTitle = movieInput.nextLine();
            Node foundMovie = movieList.searchMovie(movieTitle);
            return foundMovie;
        }
    }

    public boolean returnBorrowMovie(String username,MemberCollection memberList, MovieCollection movieCollection){
        Scanner inputMovie = new Scanner(System.in);
        Member memberReturn = memberList.searchMember(username);
        String[] borrowedMovieList = memberReturn.getBorrowedMovies();
        if(borrowedMovieList[0].compareTo("Empty") == 0){
            return false;
        }
        System.out.println("Here is your current borrowing list: ");
        memberList.displayAllBorrowedMovies(memberReturn);
        System.out.print("Please enter the movie title to return: ");
        String returnMovie = inputMovie.nextLine();
        for(int i = 0; i < borrowedMovieList.length; i++){
            if(returnMovie.toLowerCase().compareTo(borrowedMovieList[i].toLowerCase()) == 0){
                borrowedMovieList[i] = "Empty";
                memberReturn.setBorrowedMovies(borrowedMovieList);
                return true;
            }
        }
        return false;
    }

    public Member getMemberInputs(){
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
        int newPassword = memberInputs.nextInt();
        newMember = new Member(newUserName,newPassword,newName,newAddress,newPhone);
        return newMember;
    }
}

package com.company;

import Menu.MainMenu;
import Menu.MemberMenu;
import Menu.StaffMenu;
import Movie.Movie;
import Movie.MovieType;
import Movie.Node;
import Movie.MovieCollection;
import User.Member;
import User.MemberCollection;

import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MemberCollection memberList =  MemberCollection.getList();
        memberList.addMember(new Member("mytam",1234,"My Tam","Kelvin Grove","0123456789"));
        memberList.addMember(new Member("damvinhhung",1234,"Dam Vinh Hung","Kelvin Grove","1234123"));

        StaffMenu staffMenu = new StaffMenu();
        MemberMenu memberMenu = new MemberMenu();
        MainMenu mainMenu = new MainMenu();

        MovieType movieType = new MovieType();

        MovieCollection movieList = new MovieCollection();

        Scanner scan1 = new Scanner(System.in);

        int choice = -1;
        outside: while(choice != 0){
            mainMenu.getMenu();
            System.out.print("Please enter your choice: ");
            choice = scan1.nextInt();
            switch (choice){
                case 1:
                    staffMenu.staffLogin();
                    staffMenu.getMenu();
                    inner: while (true){
                        System.out.print("Please enter your choice: ");
                        choice = scan1.nextInt();
                        switch (choice){
                            case 1:
                                Scanner movieInput = new Scanner(System.in);
                                int numberOfCopies;
                                Movie newMovie;
                                Object[] staffInputs = staffMenu.getMovieInputs();
                                movieList.addMovieNode((Movie)staffInputs[0],(int)staffInputs[1]);
                                System.out.println("Movie added! Current movie list:");
                                movieList.getAllMovies(movieList.getRootMovie());
                                staffMenu.getNextMove();
                                int option = movieInput.nextInt();
                                switch (option){
                                    case 1:
                                        staffMenu.getMenu();
                                        continue inner;
                                    case 2:
                                        break inner;
                                    case 3:
                                        return;
                                }
                                break;
                            case 2:
                                Scanner movieDeleteInput = new Scanner(System.in);
                                System.out.print("Please type in the movie title: ");
                                String titleDelete = movieDeleteInput.nextLine();
                                Boolean result = movieList.deleteMovie(titleDelete);
                                System.out.println(result ? "The movie is deleted!" : "Sorry, the movie is not exist!");
                                staffMenu.getNextMove();
                                option = movieDeleteInput.nextInt();
                                switch (option){
                                    case 1:
                                        staffMenu.getMenu();
                                        continue inner;
                                    case 2:
                                        break inner;
                                    case 3:
                                        return;
                                }
                                break ;
                            case 3:
                                Scanner memberInput = new Scanner(System.in);
                                memberList.addMember(memberMenu.getMemberInputs());
                                System.out.println("Member has been registered! \n"
                                +"List of all members: \n");
                                memberList.getAllMembers();
                                staffMenu.getNextMove();
                                option = memberInput.nextInt();
                                switch (option){
                                    case 1:
                                        staffMenu.getMenu();
                                        continue inner;
                                    case 2:
                                        break inner;
                                    case 3:
                                        return;
                                }
                                break;

                            case 4:
                                Scanner memberInputs = new Scanner(System.in);
                                System.out.print("Please enter the member full name: ");
                                String name = memberInputs.nextLine();
                                Member foundMember = memberList.searchMember(name);
                                if(foundMember == null){
                                    System.out.println("Sorry, user not found!");
                                }else{
                                    System.out.println("The member contact info: \n"
                                           + "1. Phone number: " + foundMember.getPhone() + "\n"
                                           + "2. Address: " + foundMember.getAddress() + "\n");
                                }
                                staffMenu.getNextMove();
                                option = memberInputs.nextInt();
                                switch (option){
                                    case 1:
                                        staffMenu.getMenu();
                                        continue inner;
                                    case 2:
                                        break inner;
                                    case 3:
                                        return;
                                }
                                break;
                            default:
                                System.out.println("Invalid choice, please choose again!");
                                staffMenu.getMenu();
                                System.out.print("Please enter your choice :");
                        }
                    }
                    mainMenu.getMenu();
                    System.out.print("Please enter your choice :");
                    break;
                case 2:
                    Boolean isAuth = true;
                    isAuth = memberMenu.memberLogin(memberList);
                    if(isAuth){
                        System.out.println("=============================Login in successful!=============================\n");
                    }else{
                        continue outside;
                    }
                    memberMenu.getMenu();
                    inner: while (true){
                        System.out.print("Please enter your choice: ");
                        choice = scan1.nextInt();
                        switch (choice){
                            case 1:
                                if(movieList.getRootMovie() == null){
                                    System.out.println("Sorry, there's no movie in the list yet!");
                                }else{
                                    movieList.getAllMovies(movieList.getRootMovie());
                                }
                                memberMenu.getNextMove();
                                int option = scan1.nextInt();
                                switch (option){
                                    case 1:
                                        staffMenu.getMenu();
                                        continue inner;
                                    case 2:
                                        break inner;
                                    case 3:
                                        return;
                                }
                                break;
                            case 2:
                                Node borrowMovie = memberMenu.getBorrowMovie(movieList);

                            case 3:
                                break;

                            case 4:

                                break;
                            default:
                                System.out.println("Invalid choice, please choose again!");
                                System.out.print("Please enter your choice :");
                        }
                    }
                    mainMenu.getMenu();
                    System.out.print("Please enter your choice :");
                    break;
                case 0:
                    choice = 0;
                    break;
                default:
                    System.out.println("Invalid choice, please choose again!");
                    mainMenu.getMenu();
                    System.out.print("Please enter your choice :");
            }
        }
        System.out.println("==========================THANK YOU FOR USING OUR SOFTWARE!==========================");
    }
}

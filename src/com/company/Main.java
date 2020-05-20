package com.company;

import Menu.MainMenu;
import Menu.MemberMenu;
import Menu.StaffMenu;
import Movie.Movie;
import Movie.MovieType;
import Movie.MovieCollection;
import User.Member;
import User.MemberCollection;

import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MemberCollection list =  MemberCollection.getList();
        list.addMember(new Member("mytam",1234,"My Tam","Kelvin Grove","0123456789"));
        list.addMember(new Member("damvinhhung",1234,"Dam Vinh Hung","Kelvin Grove","0123456789"));

        StaffMenu staffMenu = new StaffMenu();
        MemberMenu memberMenu = new MemberMenu();
        MainMenu mainMenu = new MainMenu();

        MovieType movieType = new MovieType();

        MovieCollection movieList = new MovieCollection();

        mainMenu.getMenu();
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Please enter your choice: ");
        int choice = -1;
        while(choice != 0){
            choice = scan1.nextInt();
            switch (choice){
                case 1:
                    staffMenu.StaffLogin();
                    staffMenu.getMenu();
                    inner: while (true){
                        System.out.print("Please enter your choice: ");
                        choice = scan1.nextInt();
                        if (choice == -2) break inner;
                        switch (choice){
                            case 1:
                                Scanner movieInput = new Scanner(System.in);
                                int numberOfCopies;
                                Movie newMovie;
                                Object[] staffInputs = staffMenu.newMovieInputs();
                                movieList.addMovieNode((Movie)staffInputs[0],(int)staffInputs[1]);
                                System.out.println("Movie added! Current movie list:");
                                movieList.getAllMovies(movieList.getRootMovie());
                                staffMenu.nextMove();
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
                                break ;
                            case 3:
                                Scanner scan3 = new Scanner(System.in);
                                System.out.println("Please enter the user credentials: ");
                                System.out.print("Full Name: ");
                                String newName = scan3.next();
                                System.out.print("Address: ");
                                String newAddress = scan3.next();
                                System.out.print("Phone: ");
                                String newPhone = scan3.next();
                                System.out.print("Username: ");
                                String newUserName = scan3.next();
                                System.out.print("Password: ");
                                int newPassword = scan3.nextInt();
                                list.addMember(new Member(newUserName,newPassword,newName,newAddress,newPhone));
                                break;

                            case 4:
                                Scanner scan4 = new Scanner(System.in);
                                System.out.print("Please enter the member full name: ");
                                String name = scan4.nextLine();
                                Member foundMember = list.searchMember(name);
                                if(foundMember == null){
                                    System.out.println("Sorry, user not found!");
                                    break;
                                }
                                System.out.println("The member contact info : " + foundMember.getPhone());
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
                    memberMenu.getMenu();
                    System.out.print("Please enter your choice: ");
                    inner: while (true){
                        choice = scan1.nextInt();
                        if (choice == -2) break inner;
                        switch (choice){
                            case 1:
                                break;
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

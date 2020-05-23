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
        Movie Funny = new Movie("Funny Guy",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Elephant = new Movie("Elephant Wing",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
        Movie Incredible = new Movie("Incredible Family",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");

        Movie Quantum = new Movie("Quantum Science",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");

        Movie Zelda = new Movie("Zelda Warrior",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");

        Movie Warrior = new Movie("Warrior Ultimate",
                "Chris Evan","Two brothers","120",
                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");

        movieList.addMovieNode(Kaite,150);
        movieList.addMovieNode(Gorilla,151);
        movieList.addMovieNode(Dog,1502);
        movieList.addMovieNode(Bee,15012);
        movieList.addMovieNode(Funny,1501);
        movieList.addMovieNode(Elephant,1505);
        movieList.addMovieNode(Incredible,252);
        movieList.addMovieNode(Quantum,2532);
        movieList.addMovieNode(Zelda,6543);
        movieList.addMovieNode(Warrior,5464);


        Scanner scan1 = new Scanner(System.in);

        int choice = -1;
        boolean askNext = false;
        outside: while(choice != 0){
            mainMenu.getMenu();
            choice = mainMenu.getValidIntInput();
            switch (choice){
                case 1:
                    staffMenu.staffLogin();
                    staffMenu.getMenu();
                    inner: while (true){
                        if(askNext){
                            choice = 99;
                        }else{
                            choice = mainMenu.getValidIntInput();
                        }
                        switch (choice){
                            case -1:
                                continue outside;
                            case 1:
                                Object[] staffInputs = staffMenu.getMovieInputs();
                                movieList.addMovieNode((Movie)staffInputs[0],(int)staffInputs[1]);
                                System.out.println("Movie added! Current movie list:");
                                movieList.getAllMovies(movieList.getRootMovie());
                                askNext = true;
                                break;
                            case 2:
                                staffMenu.getDeleteMovie(movieList);
                                staffMenu.getNextMove();
                                askNext = true;

                                break ;
                            case 3:
                                Scanner memberInput = new Scanner(System.in);
                                memberList.addMember(memberMenu.getMemberInputs());
                                System.out.println("Member has been registered! \n"
                                +"List of all members: \n");
                                memberList.getAllMembers();
                                staffMenu.getNextMove();
                                askNext = true;
                                break;

                            case 4:
                                staffMenu.getContactDetail(memberList);
                                staffMenu.getNextMove();
                                askNext = true;

                                break;

                            case 99:
                                askNext = false;
                                staffMenu.getNextMove();
                                int option = mainMenu.getValidIntInput();
                                boolean goNext = false;
                                while(!goNext){
                                    switch (option){
                                        case 1:
                                            staffMenu.getMenu();
                                            continue inner;
                                        case 2:
                                            break inner;
                                        case 3:
                                            return;
                                        default:
                                            goNext = false;
                                            System.out.println("Invalid choice!");
                                            option = mainMenu.getValidIntInput();
                                    }
                                }
                            default:
                                System.out.println("Invalid choice, please choose again!");
                                staffMenu.getMenu();
                        }
                    }
                    break;
                case 2:
                    String member;
                    member = memberMenu.memberLogin(memberList);
                    if(member != null){
                        System.out.println("=============================Login in successful!=============================\n");
                    }else{
                        continue outside;
                    }
                    memberMenu.getMenu();
                    inner: while (true){
                        choice = mainMenu.getValidIntInput();
                        switch (choice){
                            case -1:
                                continue outside;
                            case 1:
                                if(movieList.getRootMovie() == null){
                                    System.out.println("Sorry, there's no movie in the list yet!");
                                }else{
                                    movieList.getAllMovies(movieList.getRootMovie());
                                }
                                askNext = true;
                                break;
                            case 2:
                                Scanner borrowInput = new Scanner(System.in);
                                if(movieList.getRootMovie() == null){
                                    System.out.println("Sorry, there's no movie to borrow yet!");
                                }else{
                                    borrow: while(true){
                                        Node borrowMovie = memberMenu.getBorrowMovie(movieList);
                                        if(borrowMovie != null){
                                            Member memberBorrow = memberList.searchMember(member);
                                            memberList.borrowDVD(borrowMovie,memberBorrow);
                                            break borrow;
                                        }else{
                                            System.out.println("Sorry, the movie is not exist!");
                                            System.out.print("Try again (Y/N) ? : ");
                                            String retry = borrowInput.nextLine();
                                            if(retry.toLowerCase().compareTo("y") == 0){
                                                continue borrow;
                                            }else{
                                                break borrow;
                                            }
                                        }
                                    }
                                }

                                askNext = true;
                                break;
                            case 3:
                                Scanner returnInput = new Scanner(System.in);
                                Member currentMem = memberList.searchMember(member);
                                if(currentMem.getBorrowedMovies()[0].compareTo("Empty") == 0){
                                    System.out.println("You have not borrow any movie!");
                                }else{
                                    returnMovie: while(true){
                                        Boolean isReturned = memberMenu.returnBorrowMovie(member,memberList,movieList);
                                        if(isReturned == true){
                                            System.out.println("You have successfully returned the movie!");
                                            break returnMovie;
                                        }else{
                                            System.out.print("Return the movie failed! \n"
                                                    +"Try again? : ");
                                            String retry = returnInput.nextLine();
                                            if(retry.toLowerCase().compareTo("y") == 0){
                                                continue returnMovie;
                                            }else{
                                                break;
                                            }
                                        }
                                    }
                                }

                                askNext = true;

                                break;

                            case 4:
                                Member currentMember = memberList.searchMember(member);
                                memberList.displayAllBorrowedMovies(currentMember);
                                memberMenu.getNextMove();
                                askNext = true;

                                break;

                            case 5:
                                if(movieList.getRootMovie() == null){
                                    System.out.println("Please add movie in first!");
                                }else{
                                    movieList.getMovieRanking();
                                }
                                askNext = true;
                                break;
                                
                            case 99:
                                askNext = false;
                                memberMenu.getNextMove();
                                int option = mainMenu.getValidIntInput();
                                boolean goNext = false;
                                while(!goNext){
                                    switch (option){
                                        case 1:
                                            staffMenu.getMenu();
                                            continue inner;
                                        case 2:
                                            break inner;
                                        case 3:
                                            return;
                                        default:
                                            goNext = false;
                                            System.out.println("Invalid choice!");
                                            option = mainMenu.getValidIntInput();
                                    }
                                }

                            default:
                                System.out.println("Invalid choice, please choose again!");
                                System.out.print("Please enter your choice :");
                        }
                    }
                    break;
                case 0:
                    choice = 0;
                    break;
                default:
                    System.out.println("Invalid choice, please choose again!");
                    System.out.print("Please enter your choice :");
            }
        }
        System.out.println("==========================THANK YOU FOR USING OUR SOFTWARE!==========================");
    }
}

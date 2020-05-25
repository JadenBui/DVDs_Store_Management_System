package com.company;

import Menu.MainMenu;
import Menu.MemberMenu;
import Menu.StaffMenu;
import Movie.Movie;
import Movie.MovieType;
import Movie.MovieCollection;
import User.Member;
import User.MemberCollection;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //initialize menu
        StaffMenu staffMenu = new StaffMenu();
        MemberMenu memberMenu = new MemberMenu();
        MainMenu mainMenu = new MainMenu();

        //initialize member collection
        MemberCollection memberList =  MemberCollection.getList();

        //initialize movie collection
        MovieCollection movieList = new MovieCollection();

        int choice = -1;
        boolean askNext = false;
        outside: while(choice != 0){
            mainMenu.getMenu();
            choice = mainMenu.getValidIntInput();
            switch (choice){
                case 1:
                    //login
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
                            //add new movie
                            case 1:
                                Object[] staffInputs = staffMenu.getMovieInputs(movieList);
                                if(staffInputs == null){
                                    System.out.println("Movie updated! Current movie list:");
                                }else{
                                    movieList.addMovieNode((Movie)staffInputs[0],(int)staffInputs[1]);
                                    System.out.println("Movie added! Current movie list:");
                                }
                                System.out.println("========================================================== MOVIES ==========================================================");
                                movieList.getAllMovies(movieList.getRootMovie());
                                System.out.println("============================================================================================================================");
                                //initial user next step
                                askNext = true;
                                break;

                            //delete a movie
                            case 2:
                                staffMenu.getDeleteMovie(movieList);
                                askNext = true;
                                break ;

                            //register a member
                            case 3:
                                memberList.addMember(memberMenu.getNewMemberCredentials());
                                System.out.println("Member has been registered! \n"
                                +"List of all members: \n");
                                System.out.println("======================================================= MEMBERS =======================================================");
                                memberList.getAllMembers();
                                System.out.println("=======================================================================================================================");
                                askNext = true;
                                break;

                            //get contact detail
                            case 4:
                                staffMenu.getContactDetail(memberList);
                                askNext = true;
                                break;

                            //get user next case
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
                                            staffMenu.getNextMove();
                                            option = mainMenu.getValidIntInput();
                                    }
                                }
                            default:
                                System.out.println("Invalid choice, please choose again!");
                                staffMenu.getMenu();
                                continue inner;
                        }
                    }
                    break;

                case 2:
                    String member;
                    //login
                    if(memberList.getMemberList()[0] == null){
                        System.out.println("The member list is empty!");
                        continue outside;
                    }
                    member = memberMenu.memberLogin(memberList);

                    if(member != null){
                        System.out.println("=============================Login in successful!=============================\n");
                        System.out.println("=============================Welcome "+member+"=============================\n");
                    }else{
                        continue outside;
                    }

                    memberMenu.getMenu();
                    inner: while (true){
                        if(askNext){
                            choice = 99;
                        }else{
                            choice = mainMenu.getValidIntInput();
                        }
                        switch (choice){
                            case -1:
                                continue outside;

                            //get all movies
                            case 1:
                                memberMenu.getAllMovies(movieList);
                                askNext = true;
                                break;

                            //borrow a movie
                            case 2:
                                memberMenu.getBorrowMovie(movieList,memberList,member);
                                askNext = true;
                                break;

                            //return a movie
                            case 3:
                                memberMenu.returnBorrowMovie(memberList, movieList, member);
                                askNext = true;
                                break;

                            //display current borrowed movies
                            case 4:
                                Member currentMember = memberList.searchMember(member);
                                memberList.displayAllBorrowedMovies(currentMember);
                                askNext = true;
                                break;

                            //display top 10 movies
                            case 5:
                                if(movieList.getRootMovie() == null){
                                    System.out.println("Please add movie in first!");
                                }else{
                                    System.out.println("====================================================================== TOP MOVIES ======================================================================");
                                    movieList.getMovieRanking(movieList.getRootMovie());
                                    System.out.println("========================================================================================================================================================");
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
                                            memberMenu.getMenu();
                                            continue inner;
                                        case 2:
                                            break inner;
                                        case 3:
                                            return;
                                        default:
                                            goNext = false;
                                            System.out.println("Invalid choice!");
                                            memberMenu.getNextMove();
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
            }
        }
        System.out.println("==========================THANK YOU FOR USING OUR SOFTWARE!==========================");
    }
}

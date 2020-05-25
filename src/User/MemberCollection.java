package User;

import Movie.Movie;
import Movie.MovieType;
import Movie.Node;
import Movie.MovieCollection;

import java.util.Arrays;
import java.util.Scanner;

public class MemberCollection {
    static int member = 0;
    static Member[] list;
    private static MemberCollection memberList = null;
    //since there should only be 1 list of member, singleton pattern is used
    private MemberCollection(){};

    public static MemberCollection getList(){
        if(memberList == null){
            memberList = new MemberCollection();
            list = new Member[100];
        }
        return memberList;
    }

    public Member[] getMemberList(){
        return list;
    }

    public void addMember(Member newMember){
        list[member++] = newMember;
    }

    public void getAllMembers(){
        for(int i = 0; i < member; i++){
            System.out.println(i+1+". "+list[i]);
        }
    }

    public Member searchMember(String name){
        String parsedName = name.replace(" ","");
        for(int i = 0; i < member; i ++){
            if(parsedName.toLowerCase().equals(list[i].getFullName().toLowerCase().replace(" ",""))){
                return list[i];
            }
        }
        return null;
    }

    public void displayAllBorrowedMovies(Member member){
        String[] listBorrowed = member.getBorrowedMovies();
        if(member.borrowListIsEmpty()){
            System.out.println("Sorry, you haven't borrow any movie");
        }else{
            int order = 1;
            System.out.println("===================== Borrowed Movies =====================");
            for(int i = 0; i < listBorrowed.length; i++){
                if(listBorrowed[i].compareTo("Empty") == 0){
                    continue;
                }
                System.out.println(order+". "+listBorrowed[i]);
                order++;
            }
        }

    }

    public void borrowDVD(Node movieNode, Member memberBorrow){
        String[] borrowList = memberBorrow.getBorrowedMovies();
        int copiesOfDvD = movieNode.getNumberOfDvd();
        if(copiesOfDvD <= 0){
            System.out.println("Sorry, this movie has out of stock!");
        }else{
            if(memberBorrow.borrowListFull()){
                System.out.println("Sorry, your borrow list capacity is full!");
            }else{
                movieNode.getMovie().isBorrowed();
                //search for an empty spot and put the movie in
                for(int i = 0; i < borrowList.length; i++){
                    if(borrowList[i].compareTo("Empty") == 0){
                        borrowList[i] = movieNode.getMovie().getTitle();
                        movieNode.setNumberOfDvd(copiesOfDvD - 1);
                        memberBorrow.setBorrowedMovies(borrowList);
                        break;
                    }
                }
            }
            System.out.println("You have successfully borrow the movie! \n" +
                    "Here is your movie list of borrowing:");
            displayAllBorrowedMovies(memberBorrow);
        }
    }

    public boolean returnBorrowedDVD(String username,MemberCollection memberList, MovieCollection movieCollection){
        Scanner inputMovie = new Scanner(System.in);
        Member memberReturn = memberList.searchMember(username);
        String[] borrowedMovieList = memberReturn.getBorrowedMovies();
        System.out.println("Here is your current borrowing list: ");
        memberList.displayAllBorrowedMovies(memberReturn);
        System.out.print("Please enter the movie title to return: ");
        String returnMovie = inputMovie.nextLine();
        Node returnMovieNode = movieCollection.searchMovie(returnMovie);
        //check if the movie exists
        if(returnMovieNode == null){
            System.out.println("This movie does not exist!");
            return false;
        }
        //check if the movie is in the member's borrowed list
        if(!memberReturn.movieInBorrowList(returnMovie)){
            System.out.println("This movie is not in your borrow list!");
            return false;
        }
        for(int i = 0; i < borrowedMovieList.length; i++){
            //find the movie and replace with "Empty"
            if(returnMovie.toLowerCase().compareTo(borrowedMovieList[i].toLowerCase()) == 0){
                borrowedMovieList[i] = "Empty";
                memberReturn.setBorrowedMovies(borrowedMovieList);
                returnMovieNode.setNumberOfDvd(returnMovieNode.getNumberOfDvd() + 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "list=" + Arrays.toString(list) +
                '}';
    }
}

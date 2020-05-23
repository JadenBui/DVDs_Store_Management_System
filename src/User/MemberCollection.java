package User;

import Movie.Movie;
import Movie.MovieType;
import Movie.Node;
import Movie.MovieCollection;

import java.util.Arrays;

public class MemberCollection {
    static int member = 0;
    static Member[] list;
    private static MemberCollection memberList = null;
    private MemberCollection(){};

    public static MemberCollection getList(){
        if(memberList == null){
            memberList = new MemberCollection();
            list = new Member[100];
        }
        return memberList;
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
        if(listBorrowed[0].compareTo("Empty") == 0){
            System.out.println("Sorry, you haven't borrow any movie");
        }else{
            for(int i = 0; i < listBorrowed.length; i++){
                if(listBorrowed[i].compareTo("Empty") == 0){
                    break;
                }
                System.out.println(i+1+". "+listBorrowed[i]);
            }
        }

    }

    public void borrowDVD(Node movieNode, Member memberBorrow){
        String[] borrowList = memberBorrow.getBorrowedMovies();
        int copiesOfDvD = movieNode.getNumberOfDvd();
        if(copiesOfDvD <= 0){
            System.out.println("Sorry, this movie has out of stock!");
        }else{
            if(borrowList[9].compareTo("Empty") != 0){
                System.out.println("Sorry, your borrow list capacity is full!");
            }else{
                movieNode.getMovie().isBorrowed();
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

    public void returnBorrowedMovie(Node movieNode, Member memberBorrow){

    }

//    public static void main(String[] args) {
//        Movie Koku = new Movie("Superman Amazing",
//                "Chris Evan","Two brothers","120",
//                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
//        Movie Gorilla = new Movie("Gorilla Amazing",
//                "Chris Evan","Two brothers","120",
//                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
//        Movie Kangaroo = new Movie("Gorilla Amazings",
//                "Chris Evan","Two brothers","120",
//                MovieType.Genre.ACTION, MovieType.Classification.PG,"20/01/2019");
//
//
//        Member katie = new Member("a",123,"","","");
//        MemberCollection members = new MemberCollection();
//        MovieCollection movieCollection = new MovieCollection();
//        movieCollection.addMovieNode(Kangaroo,150);
//        movieCollection.addMovieNode(Koku,1220);
//
//        movieCollection.addMovieNode(Gorilla,120);
//
//
//        members.borrowDVD(movieCollection.searchMovie("gorilla amazing"),katie);
//        members.borrowDVD(movieCollection.searchMovie("gorilla amazing"),katie);
//
//        members.borrowDVD(movieCollection.searchMovie("superman amazing"),katie);
//
//        movieCollection.getMovieRanking();
//
//    }

    @Override
    public String toString() {
        return "list=" + Arrays.toString(list) +
                '}';
    }
}

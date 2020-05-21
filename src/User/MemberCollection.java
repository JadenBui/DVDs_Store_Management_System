package User;

import Movie.Node;

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

    public void borrowDVD(Node movieNode, Member memberBorrow){
        String[] borrowList = memberBorrow.getBorrowedMovies();
        int copiesOfDvD = movieNode.getNumberOfDvd();
        if(copiesOfDvD <= 0){
            System.out.println("Sorry, this movie has out of stock!");
        }else{
            if(borrowList[9] == null){
                System.out.println("Sorry, your borrow list capacity is full!");
            }else{
                for(int i = 0; i < borrowList.length; i++){
                    if(borrowList[i] == null){
                        borrowList[i] = movieNode.getMovie().getTitle();
                        movieNode.setNumberOfDvd(copiesOfDvD - 1);
                        break;
                    }
                }
            }
            System.out.println("You have successfully borrow the movie! \n+" +
                    "Here is your movie list of borrowing:\n");
            System.out.println(Arrays.toString(memberBorrow.getBorrowedMovies()));
        }
    }

    @Override
    public String toString() {
        return "list=" + Arrays.toString(list) +
                '}';
    }
}

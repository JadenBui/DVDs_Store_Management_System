package User;

import java.util.Arrays;

public class Member extends User {
    private String fullName;
    private String address;
    private String phone;
    private String[] borrowedMovies;

    private int id;
    private static int memberNumber = 0;
    public Member(String username, int password, String fullName, String address, String phone) {
        super(username, password);
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.id = memberNumber++;
        this.borrowedMovies = new String[20];
        for(int i = 0; i < 20; i++){
            borrowedMovies[i] = "Empty";
        }
    }

    public String[] getBorrowedMovies() {
        return borrowedMovies;
    }

    public boolean movieInBorrowList(String title){
        for(int i = 0; i < this.getBorrowedMovies().length; i++){
            if(title.toLowerCase().compareTo(this.getBorrowedMovies()[i].toLowerCase()) == 0){
                return true;
            }
        }
        return false;
    }

    //check if the current borrowing list still have spot to borrow
    public boolean borrowListFull(){
        String[] listBorrowedMovie = this.getBorrowedMovies();
        for(int i = 0; i < listBorrowedMovie.length; i++){
            if(listBorrowedMovie[i].compareTo("Empty") == 0){
                return false;
            }
        }
        return true;
    }

    //check if the current borrowing list is empty
    public boolean borrowListIsEmpty(){
        String[] listBorrowedMovie = this.getBorrowedMovies();
        int count = 0;
        for(int i = 0; i < listBorrowedMovie.length; i++){
            if(listBorrowedMovie[i].compareTo("Empty") == 0){
                count++;
            }
        }
        if(count == getBorrowedMovies().length){
            return true;
        }
        return false;
    }

    public void setBorrowedMovies(String[] borrowedMovies) {
        this.borrowedMovies = borrowedMovies;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" + "id: '" + id + '\''+
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}

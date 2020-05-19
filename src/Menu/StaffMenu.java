package Menu;

public class StaffMenu implements Menu{
    public void getMenu(){
        System.out.println("====================== STAFF ======================");
        System.out.println("1. Add DVDs of a new movie to the software application");
        System.out.println("2. Remove a movie DVD from the software application");
        System.out.println("3. Register a member with the software application");
        System.out.println("4. Find a member’s contact phone number, given the member’s full name");
    }
}

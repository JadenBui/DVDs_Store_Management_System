package Menu;

public class MemberMenu implements Menu{
    @Override
    public void getMenu() {
        System.out.println("====================== MEMBER ======================");
        System.out.println("1. Show all movies");
        System.out.println("2. Borrow a movie DVD");
        System.out.println("3. Return a movie DVD");
        System.out.println("4. List all current borrowed movie DVDSs");
        System.out.println("5. Display top 10 most popular movies");
        System.out.println("0. Return to main Menu");
    }
}

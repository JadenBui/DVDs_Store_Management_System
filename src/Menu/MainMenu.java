package Menu;

public class MainMenu implements Menu{

    @Override
    public void getMenu() {
        System.out.println("====================== STAFF ======================");
        System.out.println("1. Staff Login");
        System.out.println("4. Member Login");
        System.out.println("0. Exit");
    }
}

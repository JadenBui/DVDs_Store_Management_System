package Menu;

public class MainMenu implements Menu{

    @Override
    public void getMenu() {
        System.out.println("====================== MAIN MENU ======================");
        System.out.println("1. Staff Login");
        System.out.println("2. Member Login");
        System.out.println("0. Exit");
    }
}

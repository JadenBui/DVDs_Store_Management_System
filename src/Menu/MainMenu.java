package Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu implements Menu{

    @Override
    public void getMenu() {
        System.out.println("====================== MAIN MENU ======================");
        System.out.println("1. Staff Login");
        System.out.println("2. Member Login");
        System.out.println("0. Exit");
        System.out.println("=======================================================");
        System.out.print("Please enter your choice: ");
    }

    public int getValidIntInput(){
        Scanner input = new Scanner(System.in);
        getInput: do{
            try{
                int pick = input.nextInt();
                return pick;
            }catch (InputMismatchException e){
                System.out.println("Invalid input, number only!");
                System.out.print("Your choice: ");
                input.next();
                continue getInput;
            }

        }while(true);

    }

    public String getValidStringInput(){
        Scanner stringInput = new Scanner(System.in);
        getInputs: do{
            System.out.print("Please enter your choice: ");
            String choice = stringInput.nextLine();
            if(choice.toLowerCase().compareTo("y") == 0){
                return "y";
            }else if(choice.toLowerCase().compareTo("n") == 0){
                return "n";
            }else{
                System.out.println("Invalid choice! Please choose Y or N: ");
                continue getInputs;
            }
        }while(true);

    }
}

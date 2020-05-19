package com.company;

import Menu.MainMenu;
import Menu.MemberMenu;
import Menu.StaffMenu;
import User.Member;
import User.MemberCollection;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MemberCollection list =  MemberCollection.getList();
        list.addMember(new Member("mytam",1234,"My Tam","Kelvin Grove","0123456789"));
        list.addMember(new Member("damvinhhungs",1234,"Dam Vinh Hung","Kelvin Grove","0123456789"));

        StaffMenu staffMenu = new StaffMenu();
        MemberMenu memberMenu = new MemberMenu();
        MainMenu mainMenu = new MainMenu();

        mainMenu.getMenu();
        Scanner scan1 = new Scanner(System.in);
        int choice = scan1.nextInt();

        switch (choice){
            case 1:
                staffMenu.getMenu();
                System.out.print("Please enter your choice: ");
                choice = scan1.nextInt();

                switch (choice){
                    case 1:

                    case 2:

                    case 3:
                        Scanner scan3 = new Scanner(System.in);
                        System.out.println("Please enter the user credentials: ");
                        System.out.println("Full Name: ");
                        String newName = scan3.nextLine();
                        System.out.println("Address: ");
                        String newAddress = scan3.nextLine();
                        System.out.println("Full Name: ");
                        String newPhone = scan3.nextLine();
                        System.out.println("Full Name: ");
                        String newUserName = scan3.nextLine();
                        System.out.println("Full Name: ");
                        String newPassword = scan3.nextLine();

                    case 4:
                        Scanner scan4 = new Scanner(System.in);
                        System.out.print("Please enter the member full name: ");
                        String name = scan4.nextLine();
                        Member foundMember = list.searchMember(name);
                        if(foundMember == null){
                            System.out.println("Sorry, user not found!");
                            break;
                        }
                        System.out.println("The member contact info : " + foundMember.getPhone());
                        break;
                    default:
                }
        }
    }
}

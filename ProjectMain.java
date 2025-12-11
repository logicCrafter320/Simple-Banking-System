package BProj;

import java.util.*;

public class ProjectMain {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        DataManagement obj1 = new DataManagement();

        while (true) {  
            System.out.println("********** Welcome to Bank Illuminati **********");
            System.out.println("Select user type:");
            System.out.println("1. Customer");
            System.out.println("2. Manager");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1/2/3): ");
            int a = sc.nextInt();
            sc.nextLine();  

            if (a == 3) {
                System.out.println("Thank you for using Bank Illuminati!");
                break; 
            }

            switch (a) {

                case 1:  
                    System.out.println("Are you a new customer or old customer?");
                    System.out.println("Type 'new' to sign up, or 'old' to login:");
                    String b = sc.nextLine();

                    if (b.equalsIgnoreCase("new")) {
                        obj1.signupUser();
                    } else if (b.equalsIgnoreCase("old")) {

                        obj1.loginUser();  

                        while (true) {  
                            System.out.println("\nWhat would you like to do?");
                            System.out.println("1. Check balance");
                            System.out.println("2. Deposit money");
                            System.out.println("3. Withdraw money");
                            System.out.println("4. Back to main menu");
                            System.out.print("Enter choice: ");
                            int n = sc.nextInt();
                            sc.nextLine();

                            if (n == 4) {
                                System.out.println("Returning to Main Menu...");
                                break;
                            }

                            switch (n) {
                                case 1:
                                    obj1.checkBal();
                                    break;
                                case 2:
                                    obj1.depositMoney();
                                    break;
                                case 3:
                                    obj1.withdrawMoney();
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                            }
                        }
                    } else {
                        System.out.println("Invalid input, try again.");
                    }
                    break;

                case 2:  
                    System.out.println("Are you a new manager or old manager?");
                    System.out.println("Type 'new' to sign up, or 'old' to login:");
                    String c = sc.nextLine();

                    if (c.equalsIgnoreCase("new")) {
                        obj1.signupManager();
                    } else if (c.equalsIgnoreCase("old")) {

                        obj1.loginManager();

                        while (true) {  
                            System.out.println("\nManager Actions:");
                            System.out.println("1. View all customers");
                            System.out.println("2. De-Activate customer account");
                            System.out.println("3. Change customer password");
                            System.out.println("4. De-Activate Manager account");
                            System.out.println("5. Back to main menu");
                            System.out.print("Enter choice: ");
                            int h = sc.nextInt();
                            sc.nextLine();

                            if (h == 5) {
                                System.out.println("Returning to Main Menu...");
                                break;
                            }

                            switch (h) {
                                case 1:
                                    obj1.viewAllCust();
                                    break;
                                case 2:
                                    obj1.deAcCustAcc();
                                    break;
                                case 3:
                                    obj1.changeCustPassword();
                                    break;
                                case 4:
                                    obj1.deAcManAcc();
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                            }
                        }
                    } else {
                        System.out.println("Invalid input, try again.");
                    }
                    break;

                default:
                    System.out.println("Invalid user type! Try again.");
            } 

        } 

        sc.close();
    }
}

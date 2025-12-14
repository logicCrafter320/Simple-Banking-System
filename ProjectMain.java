package BProj;

import java.util.Scanner;

public class ProjectMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DataManagement obj1 = new DataManagement();

        while (true) {
            System.out.println("\n********** Welcome to Bank Illuminati **********");
            System.out.println("Select user type:");
            System.out.println("1. Customer");
            System.out.println("2. Manager");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1/2/3): ");
            int a = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (a == 3) {
                System.out.println("Thank you for using Bank Illuminati!");
                break;
            }

            switch (a) {

                // ---------------- CUSTOMER ----------------
                case 1:
                    System.out.println("Are you a new customer or old customer?");
                    System.out.println("Type 'new' to sign up, or 'old' to login:");
                    String custChoice = sc.nextLine();

                    if (custChoice.equalsIgnoreCase("new")) {
                        obj1.signupUser();
                    } else if (custChoice.equalsIgnoreCase("old")) {
                        obj1.loginUser();

                        // Customer Menu (print once)
                        if (obj1.isUserLoggedIn) {
                            System.out.println("\n--- Customer Menu ---");
                            System.out.println("1. Check Balance");
                            System.out.println("2. Deposit Money");
                            System.out.println("3. Withdraw Money");
                            System.out.println("4. Apply for Loan");
                            System.out.println("5. Pay Loan Amount");
                            System.out.println("6. Change Password");
                            System.out.println("7. Logout");

                            while (obj1.isUserLoggedIn) {
                                System.out.print("\nEnter choice (1to7): ");
                                int custMenu = sc.nextInt();
                                sc.nextLine(); // clear buffer

                                switch (custMenu) {
                                    case 1:
                                        obj1.checkBal();
                                        break;
                                    case 2:
                                        obj1.depositMoney();
                                        break;
                                    case 3:
                                        obj1.withdrawMoney();
                                        break;
                                    case 4:
                                        obj1.applyForLoan();
                                        break;
                                    case 5:
                                        obj1.payLoanAmount();
                                        break;
                                    case 6:
                                        obj1.changeCustPassword();
                                        break;
                                    case 7:
                                        obj1.isUserLoggedIn = false;
                                        obj1.currentUserID = null;
                                        System.out.println("Customer logged out.");
                                        break;
                                    default:
                                        System.out.println("Invalid option! Try again.");
                                }
                            }
                            System.out.println("Returning to main menu...");
                        }
                    } else {
                        System.out.println("Invalid input, try again.");
                    }
                    break;

                // ---------------- MANAGER ----------------
                case 2:
                    System.out.println("Are you a new manager or old manager?");
                    System.out.println("Type 'new' to sign up, or 'old' to login:");
                    String mgrChoice = sc.nextLine();

                    if (mgrChoice.equalsIgnoreCase("new")) {
                        obj1.signupManager();
                    } else if (mgrChoice.equalsIgnoreCase("old")) {
                        obj1.loginManager();

                        // Manager Menu (print once)
                        if (obj1.isManagerLoggedIn) {
                            System.out.println("\n--- Manager Menu ---");
                            System.out.println("1. View All Customers");
                            System.out.println("2. De-Activate Customer Account");
                            System.out.println("3. De-Activate Manager Account");
                            System.out.println("4. Logout");

                            while (obj1.isManagerLoggedIn) {
                                System.out.print("\nEnter choice (1to4): ");
                                int mgrMenu = sc.nextInt();
                                sc.nextLine(); // clear buffer

                                switch (mgrMenu) {
                                    case 1:
                                        obj1.viewAllCust();
                                        break;
                                    case 2:
                                        obj1.deAcCustAcc();
                                        break;
                                    case 3:
                                        obj1.deAcManAcc();
                                        break;
                                    case 4:
                                        obj1.isManagerLoggedIn = false;
                                        obj1.currentManagerID = null;
                                        System.out.println("Manager logged out.");
                                        break;
                                    default:
                                        System.out.println("Invalid option! Try again.");
                                }
                            }
                            System.out.println("Returning to main menu...");
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

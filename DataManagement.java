package BProj;
import java.io.*;
import java.util.*;

public class DataManagement {

    public boolean isUserLoggedIn = false;
    public boolean isManagerLoggedIn = false;
    public String currentUserID = null;
    public String currentManagerID = null;

    /* ================= SIGNUP ================= */

    public void signupUser() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String fname = sc.next();
        System.out.print("Enter second name: ");
        String sname = sc.next();
        System.out.print("Enter accno: ");
        String accno = sc.next();
        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter id: ");
        String id = sc.next();
        System.out.print("Enter pwd: ");
        String pwd = sc.next();

        user u = new user(fname, sname, accno, balance, id, pwd);
        BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt", true));
        bw.write(u.toString());
        bw.newLine();
        bw.close();

        System.out.println("Sign Up Successful!!");
    }

    public void signupManager() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String fname = sc.next();
        System.out.print("Enter second name: ");
        String sname = sc.next();
        System.out.print("Enter id: ");
        String id = sc.next();
        System.out.print("Enter pwd: ");
        String pwd = sc.next();

        manager m = new manager(fname, sname, id, pwd);
        BufferedWriter bw = new BufferedWriter(new FileWriter("mgr.txt", true));
        bw.write(m.toString());
        bw.newLine();
        bw.close();

        System.out.println("Sign Up Successful!!");
    }

    /* ================= LOGIN ================= */

    public void loginUser() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        String id = sc.nextLine();
        System.out.print("Enter password: ");
        String pwd = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader("user.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] p = line.split("\\|");
            if (p.length >= 6 && p[4].equals(id) && p[5].equals(pwd)) {
                isUserLoggedIn = true;
                currentUserID = id;
                System.out.println("Login successful!");
                System.out.println(p[0] + " " + p[1]);
                br.close();
                return;
            }
        }
        br.close();
        System.out.println("Login failure");
    }

    public void loginManager() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Manager ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Manager Password: ");
        String pwd = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader("mgr.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] p = line.split("\\|");
            if (p.length >= 4 && p[2].equals(id) && p[3].equals(pwd)) {
                isManagerLoggedIn = true;
                currentManagerID = id;
                System.out.println("Login successful!");
                System.out.println(p[0] + " " + p[1]);
                br.close();
                return;
            }
        }
        br.close();
        System.out.println("Login failure");
    }

    /* ================= BALANCE ================= */

    public void checkBal() throws Exception {
        if (!isUserLoggedIn) return;

        BufferedReader br = new BufferedReader(new FileReader("user.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] p = line.split("\\|");
            if (p.length >= 6 && p[4].equals(currentUserID)) {
                System.out.println("Balance: Rs " + p[3]);
                br.close();
                return;
            }
        }
        br.close();
    }

    /* ================= DEPOSIT ================= */

    public void depositMoney() throws Exception {
        if (!isUserLoggedIn) return;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();

        BufferedReader br = new BufferedReader(new FileReader("user.txt"));
        String data = "", line;
        boolean done = false;

        while ((line = br.readLine()) != null) {
            String[] p = line.split("\\|");
            if (!done && p.length >= 6 && p[4].equals(currentUserID)) {
                p[3] = String.valueOf(Double.parseDouble(p[3]) + amt);
                line = String.join("|", p);
                done = true;
                System.out.println("Deposit successful!");
            }
            data += line + "\n";
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt"));
        bw.write(data);
        bw.close();
    }

    /* ================= WITHDRAW ================= */

    public void withdrawMoney() throws Exception {
        if (!isUserLoggedIn) return;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();

        BufferedReader br = new BufferedReader(new FileReader("user.txt"));
        String data = "", line;
        boolean done = false;

        while ((line = br.readLine()) != null) {
            String[] p = line.split("\\|");
            if (!done && p.length >= 6 && p[4].equals(currentUserID)) {
                double bal = Double.parseDouble(p[3]);
                if (bal < amt) {
                    System.out.println("Insufficient balance!");
                    br.close();
                    return;
                }
                p[3] = String.valueOf(bal - amt);
                line = String.join("|", p);
                done = true;
                System.out.println("Withdrawal successful!");
            }
            data += line + "\n";
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt"));
        bw.write(data);
        bw.close();
    }

    /* ================= APPLY LOAN ================= */

    public void applyForLoan() throws Exception {
        if (!isUserLoggedIn) return;

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        System.out.print("Mobile: ");
        String mob = sc.nextLine();
        System.out.print("Address: ");
        String addr = sc.nextLine();
        System.out.print("Amount: ");
        String amt = sc.nextLine();
        System.out.print("Tenure: ");
        String ten = sc.nextLine();
        System.out.print("Interest: ");
        String intr = sc.nextLine();

        int sno = getNextSno();
        String appl = generateAppNo(sno);

        String rec = currentUserID + "|" + mob + "|" + addr + "|" +
                amt + "|" + ten + "|" + intr + "|0|" +
                amt + "|-1|" + sno + "|" + appl;

        BufferedWriter bw = new BufferedWriter(new FileWriter("loan.txt", true));
        bw.write(rec);
        bw.newLine();
        bw.close();

        System.out.println("Loan applied! App No: " + appl);
    }

    /* ================= PAY LOAN ================= */

    public void payLoanAmount() throws Exception {
        if (!isUserLoggedIn) return;

        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        System.out.print("Mobile: ");
        String mob = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader("loan.txt"));
        String data = "", line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] p = line.split("\\|");
            if (!found && p.length >= 11 &&
                p[0].equals(currentUserID) && p[1].equals(mob)) {

                found = true;
                double pending = Double.parseDouble(p[7]);
                System.out.print("Pay amount: ");
                double pay = Double.parseDouble(sc.nextLine());

                if (pay <= 0 || pay > pending) {
                    System.out.println("Invalid amount!");
                    br.close();
                    return;
                }

                p[7] = String.valueOf(pending - pay);
                line = String.join("|", p);
                System.out.println("Payment successful!");
            }
            data += line + "\n";
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("loan.txt"));
        bw.write(data);
        bw.close();
    }

    /* ================= DEACTIVATE ================= */

    public void deAcCustAcc() throws Exception {
        if (!isManagerLoggedIn) return;

        Scanner sc = new Scanner(System.in);
        System.out.print("Customer ID: ");
        String id = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader("user.txt"));
        String data = "", line;
        boolean done = false;

        while ((line = br.readLine()) != null) {
            String[] p = line.split("\\|");
            if (p.length >= 6 && p[4].equals(id)) {
                done = true;
                continue;
            }
            data += line + "\n";
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt"));
        bw.write(data);
        bw.close();

        System.out.println(done ? "Customer deleted" : "User not found");
    }

    public void deAcManAcc() throws Exception {
        if (!isManagerLoggedIn) return;

        Scanner sc = new Scanner(System.in);
        System.out.print("Manager ID: ");
        String id = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader("mgr.txt"));
        String data = "", line;
        boolean done = false;

        while ((line = br.readLine()) != null) {
            String[] p = line.split("\\|");
            if (p.length >= 4 && p[2].equals(id)) {
                done = true;
                continue;
            }
            data += line + "\n";
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("mgr.txt"));
        bw.write(data);
        bw.close();

        System.out.println(done ? "Manager deleted" : "Manager not found");
    }

    /* ================= HELPERS ================= */

    private int getNextSno() throws Exception {
        int max = 0;
        BufferedReader br = new BufferedReader(new FileReader("loan.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] p = line.split("\\|");
            if (p.length >= 10) {
                try {
                    int v = Integer.parseInt(p[9]);
                    if (v > max) max = v;
                } catch (Exception e) {}
            }
        }
        br.close();
        return max + 1;
    }

    private String generateAppNo(int sno) {
        return "AP" + String.format("%03d", sno);
    }

    public void changeCustPassword() throws Exception {
    if (!isUserLoggedIn) {
        System.out.println("Please login as customer!");
        return;
    }

    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Customer ID: ");
    String custId = sc.nextLine();

    System.out.print("Enter new password: ");
    String new1 = sc.nextLine();

    System.out.print("Re-enter new password: ");
    String new2 = sc.nextLine();

    if (!new1.equals(new2)) {
        System.out.println("Passwords do not match!");
        return;
    }

    BufferedReader br = new BufferedReader(new FileReader("user.txt"));
    String line;
    String data = "";
    boolean found = false;

    while ((line = br.readLine()) != null) {
        String[] p = line.split("\\|");

        if (!found && p.length >= 6 && p[4].equals(custId)) {
            p[5] = new1;               // change password
            line = String.join("|", p);
            found = true;
            System.out.println("Customer password changed successfully!");
        }

        data += line + "\n";
    }
    br.close();

    BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt"));
    bw.write(data);
    bw.close();

    if (!found) {
        System.out.println("Customer not found!");
    }
}

public void viewAllCust() throws Exception {
    if (!isManagerLoggedIn) {
        System.out.println("Please login as manager!");
        return;
    }

    BufferedReader br = new BufferedReader(new FileReader("user.txt"));
    String line;

    System.out.println("\n===== CUSTOMER LIST =====");
    while ((line = br.readLine()) != null) {
        if (line.trim().isEmpty()) continue;

        String[] p = line.split("\\|");
        if (p.length >= 3) {
            System.out.println(
                "Name: " + p[0] + " " + p[1] +
                " | Acc No: " + p[2] +
                " | User ID: " + p[4]
            );
        }
    }
    br.close();
}

}

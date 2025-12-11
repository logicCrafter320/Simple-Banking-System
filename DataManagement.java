package BProj;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataManagement {
public void signupUser() throws Exception{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter first name ");
    String fname=sc.next();
    System.out.println("Enter second name ");
    String sname=sc.next();
    System.out.println("Enter accno ");
    String accno=sc.next();
    System.out.println("Enter balance ");
    double balance=sc.nextDouble();
    System.out.println("Enter id ");
    String id=sc.next();
    System.out.println("Enter pwd ");
    String pwd=sc.next();
    user person1=new user(fname,sname,accno,balance,id,pwd);
    FileWriter fw=new FileWriter("user.txt",true);
    BufferedWriter bw=new BufferedWriter(fw);
    bw.write(person1.toString());
    bw.newLine();
    bw.close();
    fw.close();
    System.out.println("Sign Up Successful!!");

}
public void signupManager() throws Exception{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter first name ");
    String fname=sc.next();
    System.out.println("Enter second name ");
    String sname=sc.next();
    System.out.println("Enter id ");
    String id=sc.next();
    System.out.println("Enter pwd ");
    String pwd=sc.next();
    manager person1=new manager(fname,sname,id,pwd);
    FileWriter fw=new FileWriter("mgr.txt",true);
    BufferedWriter bw=new BufferedWriter(fw);
    bw.write(person1.toString());
    bw.newLine();
    bw.close();
    fw.close();
    System.out.println("Sign Up Successful!!");
    

}
public void loginUser() throws Exception{
    Scanner sc=new Scanner(System.in);
    System.out.println("enter ID");
    String id=sc.next();
    System.out.println("enter PWD");
    String pwd=sc.next();
    FileReader fr=new FileReader("user.txt");
    BufferedReader br=new BufferedReader(fr);
    String line=null;
    boolean status=false;
    while((line=br.readLine())!=null){
    String[] vardata=line.split("\\|");
    if((id.equals(vardata[4])&&pwd.equals(vardata[5]))){
        System.out.println("login successful");
        status=true;
        System.out.println("Fname : "+vardata[0]);
        System.out.println("Sname : "+vardata[1]);
        System.out.println("Accno : "+vardata[2]);     
}
    }
    if(status==false){
        System.out.println("login failure");
    }
    
}


public void loginManager() throws Exception{
    Scanner sc=new Scanner(System.in);
    System.out.println("enter ID");
    String id=sc.next();
    System.out.println("enter PWD");
    String pwd=sc.next();
    FileReader fr=new FileReader("mgr.txt");
    BufferedReader br=new BufferedReader(fr);
    String line=null;
    boolean status=false;
    while((line=br.readLine())!=null){
    String[] vardata=line.split("\\|");
    if((id.equals(vardata[2])&&pwd.equals(vardata[3]))){
        System.out.println("login successful");
        status=true;
        System.out.println("Fname : "+vardata[0]);
        System.out.println("Sname : "+vardata[1]);
        
    }
    }
    
    if(status==false){
        System.out.println("login failure");
    }
}
public void checkBal() throws Exception{
    Scanner sc=new Scanner(System.in);
    System.out.println("enter ID");
    String id=sc.next();
    System.out.println("enter PWD");
    String pwd=sc.next();
    FileReader fr=new FileReader("user.txt");
    BufferedReader br=new BufferedReader(fr);
    String line=null;
    boolean status=false;
    while((line=br.readLine())!=null){
    String[] vardata=line.split("\\|");
    if((id.equals(vardata[4])&&pwd.equals(vardata[5]))){
        System.out.println("login successful");
        status=true;
        System.out.println("Balance : "+vardata[3]);
       
    
}
    
    }
    if(status==false){
        System.out.println("Balance Fetch Failed");
    }
    }

    public void depositMoney() throws Exception{
    Scanner sc=new Scanner(System.in);
    System.out.println("enter ID");
    String id=sc.next();
    System.out.println("enter PWD");
    String pwd=sc.next();
    FileReader fr=new FileReader("user.txt");
    BufferedReader br=new BufferedReader(fr);
    String line=null;
    boolean status=false;
    while((line=br.readLine())!=null){
    String[] vardata=line.split("\\|");
    if((id.equals(vardata[4])&&pwd.equals(vardata[5]))){
        System.out.println("login successful");
        System.out.println("Enter amount to be deposited:");
            double exb=sc.nextInt();//extra balance to be added
            double pb=Double.parseDouble(vardata[3]);//changing present balance from string to double
            double ub=exb+pb;//storing updated balance in double 
            String ubs=Double.toString(ub);//converting back double to string 
            vardata[3]=ubs;//storing updated bal in string 
            System.out.println("Balance Updated . New Balance is: "+vardata[3]);
       
}
    
    }
    if(status==false){
        System.out.println("Amount Deposit Failed");
    }
    }



    public void withdrawMoney() throws Exception{
        Scanner sc=new Scanner(System.in);
    System.out.println("enter ID");
    String id=sc.next();
    System.out.println("enter PWD");
    String pwd=sc.next();
    FileReader fr=new FileReader("user.txt");
    BufferedReader br=new BufferedReader(fr);
    String line=null;
    boolean status=false;
    while((line=br.readLine())!=null){
    String[] vardata=line.split("\\|");
    if((id.equals(vardata[4])&&pwd.equals(vardata[5]))){
        System.out.println("login successful");
       System.out.println("Enter amount to be withdrawn:");
            double wr=sc.nextInt();//money to be removed
            double bb=Double.parseDouble(vardata[3]);//bank balance
            if(bb<=wr){
            double uaw=wr-bb;//updated after withdrawal
            String wbs=Double.toString(uaw);
            vardata[3]=wbs;
            System.out.println("Withdrawal Successful.");
            System.out.println("Balance Updated . New Balance is: "+vardata[3]);}
            else{System.out.println("Not enough balance.Try again.");
                break;
            }
       
}
    
    }
    if(status==false){
        System.out.println("Amount Withdrawal Failed");
    }
    }
    

    public void viewAllCust() throws Exception{
          try (BufferedReader br = new BufferedReader(new FileReader("user.txt"))) {
            String line;
            System.out.println("Listing all users :");
            while ((line = br.readLine()) != null) {
               
                if (line.trim().isEmpty()) continue;

                String[] vardata = line.split("\\|");  
                if (vardata.length >= 3) {
                    System.out.println("Fname: " + vardata[0]
                                     + " | Sname: " + vardata[1]
                                     + " | AccNo: " + vardata[2]);
                } else {
                    
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file ");
        }
    }
    
    public void deAcCustAcc() throws Exception{
        Scanner sc=new Scanner(System.in);
    System.out.println("enter ID");
    String id=sc.next();
    System.out.println("enter PWD");
    String pwd=sc.next();
    FileReader fr=new FileReader("user.txt");
    BufferedReader br=new BufferedReader(fr);
    String line=null;
    boolean status=false;
    while((line=br.readLine())!=null){
    String[] vardata=line.split("\\|");
    if((id.equals(vardata[4])&&pwd.equals(vardata[5]))){
       System.out.println("ACCOUNT DEACTIVATED ");
    }
            else{System.out.println("Deactivation Failed.Try again.");
                break;
            }
       
}
    
    
    if(status==false){
        System.out.println("Failed");
    }}
    


    public void changeCustPassword() throws Exception{
            Scanner sc=new Scanner(System.in);
    System.out.println("enter ID");
    String id=sc.next();
    System.out.println("enter PWD");
    String pwd=sc.next();
    FileReader fr=new FileReader("user.txt");
    BufferedReader br=new BufferedReader(fr);
    String line=null;
    boolean status=false;
    while((line=br.readLine())!=null){
    String[] vardata=line.split("\\|");
    if((id.equals(vardata[4])&&pwd.equals(vardata[5]))){
         System.out.println("Enter your current password:");
            String pss=sc.nextLine();
            if(pss==vardata[5]){
                System.out.println("Enter your new password");
                String nps1=sc.nextLine();
                System.out.println("Enter new password again");
                String nps2=sc.nextLine();
                if(nps1==nps2){
                    System.out.println("Password Updated.");
                    vardata[5]=nps2;
                    break;
                }
                else{
                    System.out.println("Passwords Mismatch . Try again.");
                    continue;
                }}
            else{
                System.out.println("Incorrect Password. Try again");
            }
           
    }}
    if(status==false){
        System.out.println("Password change Failed");
    }
}

     public void deAcManAcc() throws Exception{
    Scanner sc=new Scanner(System.in);
    System.out.println("enter ID");
    String id=sc.next();
    System.out.println("enter PWD");
    String pwd=sc.next();
    FileReader fr=new FileReader("mgr.txt");
    BufferedReader br=new BufferedReader(fr);
    String line=null;
    boolean status=false;
    while((line=br.readLine())!=null){
    String[] vardata=line.split("\\|");
    if((id.equals(vardata[4])&&pwd.equals(vardata[5]))){
       System.out.println("ACCOUNT DEACTIVATED ");
    }
            else{System.out.println("Deactivation Failed.Try again.");
                break;
            }
       
}
    if(status==false){
        System.out.println("Failed");
    }

    }
}


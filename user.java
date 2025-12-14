package BProj;

public class user{
private String fname;
private String sname;
private String accno;
private double balance;
private String id;
private String pwd;
public user(String fname, String sname, String accno, double balance, String id, String pwd) {
    this.fname = fname;
    this.sname = sname;
    this.accno = accno;
    this.balance = balance;
    this.id = id;
    this.pwd = pwd;
}
public String getFname() {
    return fname;
}
public String getSname() {
    return sname;
}
public String getAccno() {
    return accno;
}
public double getBalance() {
    return balance;
}
public String getId() {
    return id;
}
public String getPwd() {
    return pwd;
}
public void setFname(String fname) {
    this.fname = fname;
}
public void setSname(String sname) {
    this.sname = sname;
}
public void setAccno(String accno) {
    this.accno = accno;
}
public void setBalance(double balance) {
    this.balance = balance;
}
public void setId(String id) {
    this.id = id;
}
public void setPwd(String pwd) {
    this.pwd = pwd;
}

public String toString() {
    return fname+"|"+sname+"|"+accno+"|"+balance+"|"+id+"|"+pwd;
}

}

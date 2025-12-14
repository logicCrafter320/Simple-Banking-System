package BProj;

public class manager {
private String fname;
private String sname;
private String id;
private String pwd;
public manager(String fname, String sname, String id, String pwd) {
    this.fname = fname;
    this.sname = sname;
    this.id = id;
    this.pwd = pwd;
}
public String getFname() {
    return fname;
}
public String getSname() {
    return sname;
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
public void setId(String id) {
    this.id = id;
}
public void setPwd(String pwd) {
    this.pwd = pwd;
}
public String toString() {
    return fname+"|"+sname+"|"+id+"|"+pwd;
}
}

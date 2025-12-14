package BProj;

public class loan{
private String sno;
private String applino;
private String name;
private String addr;
private String mobilno;
private String reqamt;
private String dispamt;
private String tenure;
private String intrper;
private String pendamt;
private String status;
public loan(String sno, String applino, String name, String addr, String mobilno, String reqamt, String dispamt,
        String tenure, String intrper, String pendamt, String status) {
    this.sno = sno;
    this.applino = applino;
    this.name = name;
    this.addr = addr;
    this.mobilno = mobilno;
    this.reqamt = reqamt;
    this.dispamt = dispamt;
    this.tenure = tenure;
    this.intrper = intrper;
    this.pendamt = pendamt;
    this.status = status;
}
public String getSno() {
    return sno;
}
public String getApplino() {
    return applino;
}
public String getName() {
    return name;
}
public String getAddr() {
    return addr;
}
public String getMobilno() {
    return mobilno;
}
public String getReqamt() {
    return reqamt;
}
public String getDispamt() {
    return dispamt;
}
public String getTenure() {
    return tenure;
}
public String getIntrper() {
    return intrper;
}
public String getPendamt() {
    return pendamt;
}
public String getStatus() {
    return status;
}
public void setSno(String sno) {
    this.sno = sno;
}
public void setApplino(String applino) {
    this.applino = applino;
}
public void setName(String name) {
    this.name = name;
}
public void setAddr(String addr) {
    this.addr = addr;
}
public void setMobilno(String mobilno) {
    this.mobilno = mobilno;
}
public void setReqamt(String reqamt) {
    this.reqamt = reqamt;
}
public void setDispamt(String dispamt) {
    this.dispamt = dispamt;
}
public void setTenure(String tenure) {
    this.tenure = tenure;
}
public void setIntrper(String intrper) {
    this.intrper = intrper;
}
public void setPendamt(String pendamt) {
    this.pendamt = pendamt;
}
public void setStatus(String status) {
    this.status = status;
}
public String toString() {
    return name+"|"+addr+"|"+mobilno+"|"+reqamt+"|"+dispamt+"|"+tenure+"|"+intrper+"|"+pendamt+"|"+status+"|"+sno+"|"+applino;
}

}

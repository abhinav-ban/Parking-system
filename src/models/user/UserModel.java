package models.user;

import java.sql.Timestamp;

public class UserModel{
    private String id;
    private String name;
    private String car_no;
    private String mobile_no;
    private String slot;
    private Timestamp enTtime ;
    private Timestamp exTime;

    public UserModel(String n,String m,String c,String s){
        this.car_no = c;
        this.mobile_no = m;
        this.name = n;
        this.slot = s;
    }
    public UserModel(Timestamp ent,Timestamp ext){
        this.enTtime = ent;
        this.exTime = ext;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getMobileNo() { return mobile_no; }
    public String getCarNo() { return car_no; }
    public String getSlot()  {return slot;}
    public Timestamp getentime() {return enTtime;}
    public Timestamp getextime() {return exTime;}
    public void setId(String id) { this.id = id; }
}

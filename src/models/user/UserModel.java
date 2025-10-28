package models.user;

public class UserModel{
    private String id;
    private String name;
    private String car_no;
    private String mobile_no;

    public UserModel(String n,String m,String c){
        this.car_no = c;
        this.mobile_no = m;
        this.name = n;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getMobileNo() { return mobile_no; }
    public String getCarNo() { return car_no; }
    public void setId(String id) { this.id = id; }
}

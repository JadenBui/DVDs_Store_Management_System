package User;

public class Member extends User {
    private String fullName;
    private String address;
    private String phone;
    private int id;
    private static int memberNumber = 0;
    public Member(String username, int password, String fullName, String address, String phone) {
        super(username, password);
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.id = memberNumber++;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" + "id: '" + id + '\''+
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}

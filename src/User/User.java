package User;

public abstract class User {
    private String username;
    private int password;

    public User(String username, int password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package online.luffyk.studentsystem.domain;

public class User {
    private Integer userid;
    private String username;
    private String password;
    private String usersex;

    public User() {
    }

    public User(Integer userid, String username, String password, String usersex) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.usersex = usersex;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", usersex='" + usersex + '\'' +
                '}';
    }
}

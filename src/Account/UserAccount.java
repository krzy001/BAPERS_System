package Account;

public class UserAccount {

    String name;
    String username;
    String password;
    int accountID;
    String role;

    public UserAccount(String name, String username, String password, int accountID, String role){
        this.name = name;
        this.username = username;
        this.password = password;
        this.accountID = accountID;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

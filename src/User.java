package src;

public abstract class User {
    private String userId;
    public String firstName;
    public String lastName;
    protected String password;
    private String email;
    private String userRole="Patient";


    public User(String userId, String firstName, String lastName, String password, String email, String userRole) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }


    public abstract boolean login();
    public abstract void viewProfile();
    public abstract void updateProfile();


    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // email getter and setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // password getter and setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // userRole getter and setter
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

}

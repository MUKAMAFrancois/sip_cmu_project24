package src;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Admin extends User {
    public Admin(String userId, String firstName, String lastName, String password, String email) {
        super(userId, firstName, lastName, password, email, "Admin");
    }

    @Override
    public boolean login() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public void viewProfile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'viewProfile'");
    }

    @Override
    public void updateProfile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateProfile'");
    }

    // initiateRegistration method
    public void initiateRegistration() {
        // Check if the current user role is Admin
        if (this.getUserRole().equals("Admin")) {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter Valid Patient Email: ");
            String email = input.nextLine();

            // check if email is valid
            if (email.contains("@") && email.contains(".")) {
                System.out.println("Email is valid");
            } else {
                System.out.println("Email is invalid");
                return; // Exit if email is invalid
            }

            // Generate and display a new UUID for the patient
            String uuid = UUID.randomUUID().toString();
            System.out.println("Patient ID: " + uuid);
        } else {
            System.out.println("Only Admin can initiate registration, choose another option.");
        }
    }

    public void exportUsers(List<User> users) {
        // Implementation for exporting users
    }
}

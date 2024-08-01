import java.util.Scanner;
import src.Patient;
import src.Admin;
import java.util.UUID;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Life Prognosis Management Tool");
        Scanner mainChoice = new Scanner(System.in);

        System.out.println("1. Patient");
        System.out.println("2. Admin");
        System.out.println("3. Help");
        System.out.println("4. Exit");

        System.out.print("Choose an option: ");
        int choice = mainChoice.nextInt();

        switch (choice) {
            case 1:
                handlePatient();
                break;

            case 2:
                handleAdmin();
                break;

            case 3:
                System.out.println("Help information");
                break;

            case 4:
                System.out.println("Exiting...");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid choice. Please try again");
        }
    }

    public static void handlePatient() {
        Scanner patientChoice = new Scanner(System.in);
        System.out.println("1. Complete registration");
        System.out.println("2. View profile");
        System.out.println("3. Update profile");

        System.out.print("Choose an option: ");
        int pChoice = patientChoice.nextInt();
        System.out.println("Your choice is: " + pChoice);

        switch (pChoice) {
            case 1:
                Patient.completeRegistration();
                break;

            case 2:
                System.out.println("Viewing profile...");
                // viewProfile();
                break;

            case 3:
                System.out.println("Updating profile...");
                // updateProfile();
                break;

            default:
                System.out.println("Invalid choice. Please try again");
        }
    }

    public static void handleAdmin() {
        Admin admin = new Admin("admin123", "John", "Anderson", "adminPassword", "admin@gmail.com");
        Scanner adminChoice = new Scanner(System.in);
        System.out.println("1. Initiate Registration");
        System.out.println("2. View profile");
        System.out.println("3. Export users list");
        System.out.println("4. Download analytics");

        System.out.print("Choose an option: ");
        int aChoice = adminChoice.nextInt();
        System.out.println("Your choice is: " + aChoice);

        switch (aChoice) {
            case 1:
                System.out.println("Initiating registration...");
                admin.initiateRegistration();
                break;

            case 2:
                System.out.println("Viewing profile...");
                // viewProfile();
                break;

            case 3:
                System.out.println("Exporting users list...");
                // exportUsers();
                break;

            case 4:
                System.out.println("Downloading analytics...");
                // downloadAnalytics();
                break;

            default:
                System.out.println("Invalid choice. Please try again");
        }
    }
}

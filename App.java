import java.util.Scanner;

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
            case 2:
                handleChoice(choice);
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

    public static void handleChoice(int choice) {
        try {
            ProcessBuilder pb = new ProcessBuilder("./scripts/user-manager.sh");
            pb.environment().put("USER_TYPE", String.valueOf(choice));
            pb.inheritIO();
            Process process = pb.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

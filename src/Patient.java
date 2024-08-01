package src;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class Patient extends User {

    private Date dateOfBirth;
    private boolean hivStatus;
    private String countryOfResidence;
    private boolean hasStartedART;
    private Date ARTDate;
    private Date diagnosisDate;

  // constructor
    public Patient(String userId, String firstName, String lastName, 
        String password, String email, Date dateOfBirth, 
        String hivStatus, String countryOfResidence, String artStatus, 
        Date ARTDate, Date diagnosisDate) {

        super(userId, firstName, lastName, password, email, "Patient");
        this.dateOfBirth = dateOfBirth;
        this.hivStatus = hivStatus.equals("positive") ? true : false;
        this.countryOfResidence = countryOfResidence;
        this.hasStartedART = artStatus.equals("true") ? true : false;
        this.ARTDate = ARTDate;
        this.diagnosisDate = diagnosisDate;
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


    // getters and setters

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isHivStatus() {
        return hivStatus;
    }

    public void setHivStatus(boolean hivStatus) {
        this.hivStatus = hivStatus;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public boolean isHasStartedART() {
        return hasStartedART;
    }

    public void setHasStartedART(boolean hasStartedART) {
        this.hasStartedART = hasStartedART;
    }

    public Date getARTDate() {
        return ARTDate;
    }

    public void setARTDate(Date aRTDate) {
        ARTDate = aRTDate;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }


    
// methods

 public static void completeRegistration() {
    Scanner input = new Scanner(System.in);
    String uuid, firstName, lastName, dateOfBirth, hivStatus, diagnosisDate, artStatus, artStartDate, countryOfResidence, password;
    Date dob = null, dod = null, artDate = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.print("Enter UUID: ");
        uuid = input.nextLine();

        System.out.print("Enter First Name: ");
        firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        lastName = input.nextLine();

        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        while(true){
            dateOfBirth = input.nextLine();
            try {
                dob = sdf.parse(dateOfBirth);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Enter again (YYYY-MM-DD): ");
            }
        }
        

        System.out.print("Enter HIV Status (positive/negative): ");
        while(true){
            hivStatus = input.nextLine();
            if(hivStatus.equalsIgnoreCase("positive") || hivStatus.equalsIgnoreCase("negative")){
                break;
            } else {
                System.out.println("Invalid input. Enter again (positive/negative): ");
            }
        }
       


        System.out.print("Enter Diagnosis Date (YYYY-MM-DD): ");
        while(true){
            diagnosisDate = input.nextLine();
            try {
                dod = sdf.parse(diagnosisDate);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Enter again (YYYY-MM-DD): ");
            }
        }
        

        System.out.print("Enter ART Status (true/false): ");
        while(true){
            artStatus = input.nextLine();
            if(artStatus.equalsIgnoreCase("true") || artStatus.equalsIgnoreCase("false")){
                break;
            } else {
                System.out.println("Invalid input. Enter again (true/false): ");
            }
        }
        

        System.out.print("Enter ART Start Date (YYYY-MM-DD): ");
        while(true){
            artStartDate = input.nextLine();
            try {
                artDate = sdf.parse(artStartDate);
                break;
            } catch (Exception e) {
                System.out.println("Invalid date format. Enter again (YYYY-MM-DD): ");
            }
        }
        
        System.out.print("Enter Country of Residence (ISO Code): ");
        countryOfResidence = input.nextLine();
        System.out.print("Enter Password: ");
        password = input.nextLine();

        try {
            // create patient object
            Patient patient = new Patient(uuid, firstName, lastName, password, "", dob,
                    hivStatus, countryOfResidence,
                    artStatus, artDate, dod);
            System.out.println("Patient created successfully");

        } catch (Exception e) {
            System.out.println("Invalid input. Please try again");
        }
    }
    
    
}

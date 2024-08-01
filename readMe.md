# sip_cmu_project24



## To run the script:
1. Make the script executable:
   ```bash
   chmod +x ./scripts/user-manager.sh
   ```
2. Run the script:
   ```bash
   ./scripts/user-manager.sh
   ```

## Project Structure:
```
sipProject24
├── App.java
├── data
│   ├── user-store.txt
│   ├── admin-credentials.txt
├── readMe.md
├── scripts
│   └── user-manager.sh
└── src
    ├── Admin.java
    ├── Patient.java
    ├── iCalendar.java
    ├── LifeCalculator.java
    ├── User.java
```

## Role of Each File:

### App.java
- **Location**: Root Directory
- **Role**: Entry point of the Java application. This file contains the main method that runs the application.

### data/
- **Role**: Directory that holds data files for storing user information.

#### user-store.txt
- **Location**: data/
- **Role**: Stores the credentials and information of all the users (except admin). Each entry includes the user's email, UUID, hashed password, first name, last name, date of birth, HIV status, diagnosis date, ART status, ART start date, and country of residence.

#### admin-credentials.txt
- **Location**: data/
- **Role**: Stores the credentials and information of the admin user. Each entry includes the admin's email, UUID, hashed password, and role.



### scripts/
- **Role**: Directory containing shell scripts for managing user registration and authentication.

#### user-manager.sh
- **Location**: scripts/
- **Role**: Bash script that manages user operations. 

### src/
- **Role**: Directory containing Java source files for different components of the application.

#### Admin.java
- **Location**: src/
- **Role**: Java class representing an Admin user. 

#### Patient.java
- **Location**: src/
- **Role**: Java class representing a Patient user.

#### iCalendar.java
- **Location**: src/
- **Role**: Java class related to calendar functionalities. 

#### LifeCalculator.java
- **Location**: src/
- **Role**: Java class that will includes methods for calculating life expectancy.

#### User.java
- **Location**: src/
- **Role**: Java class representing a generic User. This class includes common attributes such as user ID, first name, last name, email, and role. It serves as a base class for Admin and Patient classes.
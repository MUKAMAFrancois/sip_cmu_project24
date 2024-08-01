#!/usr/bin/bash

USER_STORE="data/user-store.txt"
ADMIN_CREDENTIALS="data/admin-credentials.txt"
HASH_ALGO="sha256"

# SHA-256 (Secure Hash Algorithm 256-bit) is a cryptographic 
# hash function that generates a fixed-size 256-bit (32-byte) 
# hash value from input data of any size. It is part of the SHA-2 
# (Secure Hash Algorithm 2) family, 
# which was designed by the National Security Agency (NSA) 
# and published by the National Institute of Standards and Technology (NIST).
#  SHA-256 is widely used in various security applications and protocols, 
# including SSL/TLS, digital signatures, and blockchain technologies.

# Function to hash passwords
hash_password() {
  echo -n "$1" | openssl dgst -$HASH_ALGO | awk '{print $2}'
}

# Function to add initial admin
initialize_admin() {
  if [ ! -f "$ADMIN_CREDENTIALS" ]; then
    touch "$ADMIN_CREDENTIALS"
    echo "Creating initial admin..."
    read -p "Enter admin email: " admin_email
    read -sp "Enter admin password: " admin_password
    echo
    hashed_password=$(hash_password "$admin_password")
    uuid=$(uuidgen)
    echo "$admin_email,$uuid,$hashed_password,Admin" >> "$ADMIN_CREDENTIALS"
    echo "Admin created successfully."
  else
    echo "Admin credentials already exist. Initialization skipped."
  fi
}

# Function to initiate patient registration
initiate_registration() {
  while true; do
    echo "Initiating patient registration..."
    read -p "Enter patient email: " patient_email
    uuid=$(uuidgen)
    echo "$patient_email,$uuid,,Patient" >> "$USER_STORE"
    echo "Patient registration initiated. Email: $patient_email, Code: $uuid"

    read -p "Do you want to add another patient? (y/n): " choice
    if [[ "$choice" != "y" ]]; then
      break
    fi
  done
}

# Function to check if the user exists in the store
check_user_exists() {
  grep -q "$1" "$USER_STORE"
}

# Function to complete patient registration
complete_registration() {
  echo "Completing patient registration..."
  read -p "Enter registration code: " reg_code
  if check_user_exists "$reg_code"; then
    read -p "Enter First Name: " first_name
    read -p "Enter Last Name: " last_name
    read -p "Enter Date of Birth (YYYY-MM-DD): " dob
    read -p "Enter HIV Status (positive/negative): " hiv_status
    read -p "Enter Diagnosis Date (YYYY-MM-DD): " diagnosis_date
    read -p "Enter ART Status (true/false): " art_status
    read -p "Enter ART Start Date (YYYY-MM-DD): " art_start_date
    read -p "Enter Country of Residence (ISO Code): " country
    read -sp "Enter Password: " password
    echo

    # Hash the password
    hashed_password=$(hash_password "$password")

    # Update user-store.txt with the complete details
    sed -i "/$reg_code/s/,,/,$hashed_password,$first_name,$last_name,$dob,$hiv_status,$diagnosis_date,$art_status,$art_start_date,$country/" "$USER_STORE"

    echo "Registration completed."
  else
    echo "Invalid registration code. Please contact admin."
  fi
}

# Function to login user
login_user() {
  echo "Logging in..."
  read -p "Enter email: " email
  if check_user_exists "$email"; then
    read -sp "Enter password: " password
    echo
    stored_password=$(grep "$email" "$USER_STORE" | awk -F ',' '{print $3}')
    hashed_password=$(hash_password "$password")
    if [ "$stored_password" == "$hashed_password" ]; then
      echo "Login successful."
    else
      echo "Invalid password."
    fi
  else
    echo "User not found."
  fi
}

# function to view user list: download csv file
view_user_list(){


}

#function get analytics
get_analytics(){
  
}


# Admin menu
admin_menu() {
  echo "1. Initialize Admin Account"
  echo "2. Initiate Patient Registration"
  echo "3. View User List (csv)"
  echo "4. Get Analytics (csv)"
  echo "5. Exit"
  read -p "Choose an option: " choice
  case $choice in
    1) initialize_admin ;;
    2) initiate_registration ;;
    3) view_user_list ;;
    4) get_analytics ;;
    5) exit 0 ;;
    *) echo "Invalid option" ;;
  esac
}

# Function to view user profile
view_profile() {
  echo "Viewing profile... under process"
  
}

# Function to update user profile
update_profile() {
  echo "Updating profile... under process"
  
}

# Patient menu
patient_menu() {
  echo "1. Complete Registration"
  echo "2. View Profile"
  echo "3. Update Profile"
  echo "4. Exit"
  read -p "Choose an option: " choice
  case $choice in
    1) complete_registration ;;
    2) view_profile ;;
    3) update_profile;;
    4) exit 0 ;;
    *) echo "Invalid option" ;;
  esac
}

# Main logic
if [ -z "$1" ]; then
  echo "Choose an option: "
  echo "1. Admin"
  echo "2. Patient"
  read -p "Enter your choice: " user_type
else
  user_type=$1
fi

if [ "$user_type" == "admin" ] || [ "$user_type" == "1" ]; then
  while true; do
    admin_menu
  done
elif [ "$user_type" == "patient" ] || [ "$user_type" == "2" ]; then
  while true; do
    patient_menu
  done
else
  echo "Invalid argument. Use 'admin' or 'patient'."
  exit 1
fi

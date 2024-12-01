public class Admin {
  // Attributes
  private String username;
  private String email;
  private String password;

  // Constructor
  public Admin(String username, String email, String password) {
      this.username = username;
      this.email = email;
      this.password = password; // In a real application, consider hashing passwords
  }

  // Getter for username
  public String getUsername() {
      return username;
  }

  // Setter for username
  public void setUsername(String username) {
      this.username = username;
  }

  // Getter for email
  public String getEmail() {
      return email;
  }


  public void setEmail(String email) {
      this.email = email;
  }

  public String getpassword() {
    return password;
  }

  public void setpassword(String email) {
    this.password = password;
  }

  // Method to change password
  public void changePassword(String newPassword) {
      this.password = newPassword; // In a real application, consider validating the new password
  }

  // Method to display admin details
  public void displayAdminInfo() {
      System.out.println("Admin Username: " + username);
      System.out.println("Admin Email: " + email);
  }
}
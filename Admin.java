public class Admin {
  private String username;
  private String email;
  private String password;

  public Admin(String username, String email, String password) {
      this.username = username;
      this.email = email;
      this.password = password; 
  }

  public String getUsername() {
      return username;
  }

  public void setUsername(String username) {
      this.username = username;
  }

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

  public void changePassword(String newPassword) {
      this.password = newPassword; 
  }

  public void displayAdminInfo() {
      System.out.println("Admin Username: " + username);
      System.out.println("Admin Email: " + email);
  }
}
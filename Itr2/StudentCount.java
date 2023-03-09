package Itr2;
import java.sql.*;

public class StudentCount {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/library"; // localhost:3306 - change here if needed
            String user="root"; // use your own user name here
            String password="123456"; // use your own password
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement st = connection.createStatement();
            String sql = "SELECT username, password FROM users WHERE role = 'student'";
            ResultSet rs = st.executeQuery(sql);
          while (rs.next()) {
            String username = rs.getString("username");
            String password1 = rs.getString("password");
            System.out.println("Username: " + username + ", Password: " + password1);
          }
          rs.close();
          st.close();
          connection.close();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
}

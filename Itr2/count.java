package Itr2;
import java.sql.*;
import java.util.*;



public class count extends User{

    public count(String username, String password, String role) {
        super(username, password, role);
       
    }
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = ""; // private url
            String DBuser = ""; // private name
            String password =""; // private password
            Connection connection = DriverManager.getConnection(url,DBuser,password);
            String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement pt = connection.prepareStatement(sql);
            ArrayList<User> users = new ArrayList<>(); // add user function
            users.add(new User("w", "2w", "student"));
            
            for(User user : users){
                pt.setString(1, user.getUsername());
                pt.setString(2, user.getPassword());
                pt.setString(3, user.getRole());
                int rows = pt.executeUpdate();
                System.out.println("Inserted " + rows + user.getUsername()+ ".");
            }
            connection.close();
            pt.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}

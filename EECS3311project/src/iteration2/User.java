package iteration2;


public class User {
private String userId;
private String name;
private String email;

public User(String user) {
    this.userId = user;
}

public User(String userId, String name, String email) {
    this.userId = userId;
    this.name = name;
    this.email = email;
}

public String getUserId() {
    return userId;
}

public String getName() {
    return name;
}

public String getEmail() {
    return email;
}

public void setUserId(String userId) {
    this.userId = userId;
}

public void setName(String name) {
    this.name = name;
}

public void setEmail(String email) {
    this.email = email;
}
}
package edu.studio.issue;

public class User {

    private long id;
    private String login;
    
    public User() {}
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    
    @Override
    public String toString() {
        
        return "Username: "+ this.login + ", Id: "+ this.id;
    }
}

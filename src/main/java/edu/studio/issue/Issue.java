package edu.studio.issue;

import java.util.Date;

public class Issue {
    
    private long id;
    private int number;
    private String state;
    private String title;
    private String body;
    private Date createdAt;
    private Date closedAt=null;
    private User user;
    private User asignee;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getClosedAt() {
        return closedAt;
    }
    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public User getAsignee() {
        return asignee;
    }
    public void setAsignee(User asignee) {
        this.asignee = asignee;
    }
  

}

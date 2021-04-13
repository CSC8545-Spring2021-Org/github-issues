package edu.studio.issue;

import java.util.Date;

public class Issue implements Comparable<Issue> {

    private long id;
    private int number;
    private String state;
    private String title;
    private String body;
    private Date createdAt;
    private Date closedAt;
    private User user;
    private User assignee;

    public Issue() {
    }

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

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User asignee) {
        this.assignee = asignee;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Number: " + number + ", State: " + state + ", Title: " + title + ", Body: " + body
                + ", Created At: " + createdAt + ", Closed At: " + closedAt + ", User: " + user + ", Assignee: "
                + assignee;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            result=true;
        }
        
        Issue other = (Issue) obj;
        if (id != other.id) {
            result = false;
        }
        return result;
    }

    @Override
    public int compareTo(Issue o) {

        return this.id < o.id ? -1 : this.id == o.id ? 0 : 1;
    }

}

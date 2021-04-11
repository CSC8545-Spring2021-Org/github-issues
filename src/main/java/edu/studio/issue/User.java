package edu.studio.issue;

public class User implements Comparable<User> {

    private long id;
    private String login;

    public User() {
    }

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

        return "Username: " + this.login + ", Id: " + this.id;
    }

    @Override
    public int compareTo(User o) {

        return this.id < o.id ? -1 : this.id == o.id ? 0 : 1;
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
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            result=true;
        }

        if (getClass() != obj.getClass()) {
            result = false;
        }
        User other = (User) obj;
        if (id != other.id) {
            result = false;
        }
        return result;
    }

}

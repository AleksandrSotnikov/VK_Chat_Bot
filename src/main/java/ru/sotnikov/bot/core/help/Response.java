package ru.sotnikov.bot.core.help;


public class Response {

    private Integer id;
    private String first_name;
    private String last_name;
    private Boolean is_closed;
    private Boolean canAccessClosed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public Boolean getIsClosed() {
        return is_closed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.is_closed = isClosed;
    }

    public Boolean getCanAccessClosed() {
        return canAccessClosed;
    }

    public void setCanAccessClosed(Boolean canAccessClosed) {
        this.canAccessClosed = canAccessClosed;
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", isClosed=" + is_closed +
                ", canAccessClosed=" + canAccessClosed +
                '}';
    }
}
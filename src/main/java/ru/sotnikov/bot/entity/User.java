package ru.sotnikov.bot.entity;

public class User {
    private String firstName;
    private String lastName;
    private String nickName;
    private int id;

    public User() {
    }

    public User(String firstName, String lastName, String nickName, String id) {
        setFirstName(firstName);
        setLastName(lastName);
        setNickName(nickName);
        setId(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstNameID() {
        return "@".concat("id").concat(String.valueOf(getId())).concat("(").concat(getFirstName()).concat("), ");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }
}

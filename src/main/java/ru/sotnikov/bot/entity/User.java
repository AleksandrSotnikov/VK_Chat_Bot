package ru.sotnikov.bot.entity;

public class User {
    private static String firstName;
    private static String lastName;
    private static String nickName;
    private static String id;

    public User() {
    }

    public User(String firstName,String lastName,String nickName,String id) {
        setFirstName(firstName);
        setLastName(lastName);
        setNickName(nickName);
        setId(id);
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        User.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        User.lastName = lastName;
    }

    public static String getNickName() {
        return nickName;
    }

    public static void setNickName(String nickName) {
        User.nickName = nickName;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        User.id = id;
    }
}

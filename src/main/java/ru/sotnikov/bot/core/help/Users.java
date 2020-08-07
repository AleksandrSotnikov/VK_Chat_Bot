package ru.sotnikov.bot.core.help;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private ArrayList<Response> response = null;

    public ArrayList<Response> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<Response> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Users{" +
                "response=" + response +
                '}';
    }
}

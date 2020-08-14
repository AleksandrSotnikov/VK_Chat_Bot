package ru.sotnikov.bot.core.commands;

import ru.sotnikov.bot.entity.Entity;
import ru.sotnikov.bot.entity.JailUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MinerKick extends DefaultCommand {

    private final ArrayList<JailUser> jail;

    public MinerKick(Entity entity, ArrayList<JailUser> jail) {
        super(entity);
        this.jail = jail;
    }

    public static String getJSON(String urle) {
        try {
            URL url = new URL(urle);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-length", "0");
            con.setConnectTimeout(30000);
            con.connect();
            int resp = con.getResponseCode();
            if (resp == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                StringBuilder sb = new StringBuilder();
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                br.close();
                return sb.toString();
            } else {
                System.out.println("Ответ сервера: " + resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<JailUser> minerDefend() {
        JailUser jails = new JailUser(getEntity().getFirstUser().getId(), 0, 0);
        if (!jail.contains(jails)) jail.add(jails);
        for (JailUser j : jail) {
            if (j.equals(jails)) {
                jail.remove(jails);
                if (j.getCountMine() < 2) {
                    jail.add(new JailUser(j.getId(), j.getCountMine() + 1, j.getCountCase()));
                    sendMessage(getEntity().getFirstUser().getFirstNameID() + " В данной беседе запрещено копать");
                } else {
                    jail.add(new JailUser(j.getId(), 0, j.getCountCase()));
                    String msg = "https://api.vk.com/method/messages.send?peer_id=2000000310&message="
                            .concat("пред%20")
                            .concat(getEntity().getFirstUser().getFirstNameID().replace(", ", ""))
                            .concat("&v=5.38&access_token=").concat(getEntity().getAccessTokens());
                    System.out.println("Выдан пред" + j.getId());
                    getJSON(msg);
                }
            }
        }
        return jail;
    }
}

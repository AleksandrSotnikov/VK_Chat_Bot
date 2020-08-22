package ru.sotnikov.bot.entity;

import java.util.Objects;

public class PunishmentUser {
    private int peerID;
    private int userID;
    private int punishmentCount = 0;

    public PunishmentUser(int peerID, int userID) {
        setPeerID(peerID);
        setUserID(userID);
    }

    public PunishmentUser(int peerID, int userID, int punishmentCount) {
        setPeerID(peerID);
        setUserID(userID);
        setPunishmentCount(punishmentCount);
    }

    public PunishmentUser updatePunishmentCountPlus() {
            setPunishmentCount(getPunishmentCount() + 1);
        return this;
    }

    public PunishmentUser updatePunishmentCountMinus() {
            if(getPunishmentCount()-1>0)
            setPunishmentCount(getPunishmentCount() - 1);
        return this;
    }

    public PunishmentUser updatePunishmentCountClear() {
            setPunishmentCount(0);
        return this;
    }

    public PunishmentUser updatePunishmentCountImun() {
            setPunishmentCount(Integer.MIN_VALUE);
        return this;
    }

    public int getPeerID() {
        return peerID;
    }

    public void setPeerID(int peerID) {
        this.peerID = peerID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPunishmentCount() {
        return punishmentCount;
    }

    public void setPunishmentCount(int punishmentCount) {
        this.punishmentCount = punishmentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PunishmentUser that = (PunishmentUser) o;
        return peerID == that.peerID &&
                userID == that.userID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(peerID, userID);
    }
}

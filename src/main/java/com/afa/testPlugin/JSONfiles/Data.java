package com.afa.testPlugin.JSONfiles;

import java.util.Date;

public class Data {
    private String playerName;
    private Boolean value;
    private Date date;

    public Data(String playerName, Boolean value, Date date) {
        this.playerName = playerName;
        this.value = value;
        this.date = date;
    }

    public String getPlayerName() { return playerName; }
    public Boolean getValue() { return value; }
    public Date getDate() { return date; }
}

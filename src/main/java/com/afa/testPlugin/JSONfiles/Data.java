package com.afa.testPlugin.JSONfiles;

import java.util.Date;

public class Data {
    private String playerName;
    private Boolean buildMode;
    private Date date;

    public Data(String playerName, Boolean buildMode, Date date) {
        this.playerName = playerName;
        this.buildMode = buildMode;
        this.date = date;
    }

    public String getPlayerName() { return playerName; }
    public Boolean getBuildMode() { return buildMode; }
    public Date getDate() { return date; }
}
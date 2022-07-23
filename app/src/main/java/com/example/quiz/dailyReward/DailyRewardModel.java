package com.example.quiz.dailyReward;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "dailyReward")
public class DailyRewardModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "online_dated")
    private String online;

    @ColumnInfo(name = "isActive")
    private boolean active;

    public DailyRewardModel(int id, String online, boolean active) {
        this.id = id;
        this.online = online;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

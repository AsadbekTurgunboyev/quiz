package com.example.quiz.dailyReward;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {DailyRewardModel.class}, exportSchema = false, version = 1)
public abstract class DailyRewardDatabase extends RoomDatabase {
    private static final String DB_NAME = "personactive_db";
    private static DailyRewardDatabase instance;

    public static synchronized DailyRewardDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), DailyRewardDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;

    }

    public abstract DailyRewardDao dailyRewardDao();
}

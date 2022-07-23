package com.example.quiz.dailyReward;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DailyRewardDao {

    @Query("SELECT * FROM dailyReward")
    List<DailyRewardModel> getAll();

    @Insert
    void insertPersonAcitive(DailyRewardModel model);

}

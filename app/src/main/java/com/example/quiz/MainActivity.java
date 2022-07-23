package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quiz.avatar.avatar_adapter.AvatarAdapter;
import com.example.quiz.avatar.avatars_pictures.Avatars_Pictures;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    public final static String PREFS = "PrefsFile";

    private SharedPreferences settings = null;
    private SharedPreferences.Editor editor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.check_daily_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        RecyclerView rec = dialog.findViewById(R.id.recAvatar);
//        AvatarAdapter adapter = new AvatarAdapter(this, Avatars_Pictures.avatars);
//        rec.setAdapter(adapter);
        dialog.show();
        settings = getSharedPreferences(PREFS, MODE_PRIVATE);
        editor = settings.edit();

        // First time running app?
        if (!settings.contains("lastTimeActionDone"))
            enableNotification(null);

        Log.v(TAG, "Starting CheckRecentRun service...");
        startService(new Intent(this, CheckActionDone.class));


    }
    public void doAction(View v) {
        Toast.makeText(this, "boshladi", Toast.LENGTH_SHORT).show();
        Log.v(TAG, "Recording time action done");
        editor.putLong("lastTimeActionDone", System.currentTimeMillis());
        editor.commit();

    }

    public void enableNotification(View v) {
        editor.putBoolean("enabled", true);
        editor.commit();
        Log.v(TAG, "Notifications enabled");
    }

    public void disableNotification(View v) {
        editor.putBoolean("enabled", false);
        editor.commit();
        Log.v(TAG, "Notifications disabled");
    }
}
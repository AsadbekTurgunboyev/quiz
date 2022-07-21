package com.example.quiz.avatar.avatar_adapter;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.R;
import com.example.quiz.sound.SoundManager;
import com.google.android.material.card.MaterialCardView;

public class AvatarAdapter extends RecyclerView.Adapter<AvatarAdapter.MyViewHolder> {
    Context context;
    int[] pics;
    SoundPool soundPool;
    int sound;


    public AvatarAdapter(Context context, int[] pics) {
        this.context = context;
        this.pics = pics;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.avatar_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(position == 0){
            holder.picAvatar.setImageResource(R.drawable.ic_baseline_crop_original_24);
        }else {

        holder.picAvatar.setImageResource(pics[position-1]);

        }

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setMaxStreams(6)
                .setAudioAttributes(audioAttributes)
                .build();
        sound = soundPool.load(context,R.raw.a,1);
        SoundManager manager = SoundManager.getInstance(context);

        holder.avat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                soundPool.play(sound,1,1,0,0,1);
            manager.playSound(1);
            }
        });


        holder.picAvatar.playSoundEffect(SoundEffectConstants.CLICK);

    }

    @Override
    public int getItemCount() {
        return pics.length + 1;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView picAvatar;
        FrameLayout avat;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            picAvatar = itemView.findViewById(R.id.picAvatar);
            avat = itemView.findViewById(R.id.avat);
        }
    }
}

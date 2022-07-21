package com.example.quiz.sound;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.SparseArray;
import android.util.SparseIntArray;

import com.example.quiz.R;

public class SoundManager {
    public static int SOUNDPOOLSND_MENU_BTN = 0;
    public static int SOUNDPOOLSND_WIN = 1;
    public static int SOUNDPOOLSND_LOOSE = 2;
    public static int SOUNDPOOLSND_DRAW = 3;
    public static int SOUNDPOOLSND_TICK1 = 4;
    public static int SOUNDPOOLSND_TICK2 = 5;
    public static int SOUNDPOOLSND_OUT_OF_TIME = 6;
    public static int SOUNDPOOLSND_HISCORE = 7;
    public static int SOUNDPOOLSND_CORRECT_LETTER = 8;
    int sound;
    public static boolean isSoundTurnedOff;

    private static SoundManager mSoundManager;

    private SoundPool mSoundPool;
    private SparseIntArray mSoundPoolMap;
    private AudioManager mAudioManager;

    public static final int maxSounds = 4;

    public static SoundManager getInstance(Context context) {
        if (mSoundManager == null) {
            mSoundManager = new SoundManager(context);
        }

        return mSoundManager;
    }


    public SoundManager(Context mContext) {
        mAudioManager = (AudioManager) mContext
                .getSystemService(Context.AUDIO_SERVICE);
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setMaxStreams(6)
                .setAudioAttributes(audioAttributes)
                .build();

          sound =  mSoundPool.load(mContext, R.raw.a, 0);


        mSoundPoolMap = new SparseIntArray();
        mSoundPoolMap.put(SOUNDPOOLSND_MENU_BTN,
                mSoundPool.load(mContext, R.raw.a, 0));
        mSoundPoolMap.put(SOUNDPOOLSND_WIN,
                mSoundPool.load(mContext, R.raw.a, 1));
        mSoundPoolMap.put(SOUNDPOOLSND_LOOSE,
                mSoundPool.load(mContext, R.raw.a, 2));
        mSoundPoolMap.put(SOUNDPOOLSND_TICK1,
                mSoundPool.load(mContext, R.raw.a, 3));
        mSoundPoolMap.put(SOUNDPOOLSND_TICK2,
                mSoundPool.load(mContext, R.raw.a, 4));


    }

    public void playSound(int index) {
        int streamVolume = mAudioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        mSoundPool.play(sound, 1, 1,
                0, 0, 1);
    }

    public void clear() {
        if (mSoundManager != null) {
            mSoundManager.mSoundPool = null;
            mSoundManager.mAudioManager = null;
            mSoundManager.mSoundPoolMap = null;
        }
        mSoundManager = null;
    }
}

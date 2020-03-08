package com.example.spellingbee;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService2 extends Service implements MediaPlayer.OnErrorListener {

    private final IBinder mBinder = new ServiceBinder();
    MediaPlayer mPlayer2;
    private int length = 0;

    public MusicService2() {
    }

    public class ServiceBinder extends Binder {
        MusicService2 getService() {
            return MusicService2.this;
        }
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mPlayer2 = MediaPlayer.create(this, R.raw.congrats_song);
        mPlayer2.setOnErrorListener(this);

        if (mPlayer2 != null) {
            mPlayer2.setLooping(true);
            mPlayer2.setVolume(50, 50);
        }


        mPlayer2.setOnErrorListener(new MediaPlayer.OnErrorListener() {

            public boolean onError(MediaPlayer mp, int what, int
                    extra) {

                onError(mPlayer2, what, extra);
                return true;
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mPlayer2 != null) {
            mPlayer2.start();
        }
        return START_NOT_STICKY;
    }

    public void pauseMusic() {
        if (mPlayer2 != null) {
            if (mPlayer2.isPlaying()) {
                mPlayer2.pause();
                length = mPlayer2.getCurrentPosition();
            }
        }
    }

    public void resumeMusic() {
        if (mPlayer2 != null) {
            if (!mPlayer2.isPlaying()) {
                mPlayer2.seekTo(length);
                mPlayer2.start();
            }
        }
    }

    public void startMusic() {
        mPlayer2 = MediaPlayer.create(this, R.raw.bg3);
        mPlayer2.setOnErrorListener(this);

        if (mPlayer2 != null) {
            mPlayer2.setLooping(true);
            mPlayer2.setVolume(50, 50);
            mPlayer2.start();
        }

    }

    public void stopMusic() {
        if (mPlayer2 != null) {
            mPlayer2.stop();
            mPlayer2.release();
            mPlayer2 = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPlayer2 != null) {
            try {
                mPlayer2.stop();
                mPlayer2.release();
            } finally {
                mPlayer2 = null;
            }
        }
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {

        Toast.makeText(this, "Music player failed", Toast.LENGTH_SHORT).show();
        if (mPlayer2 != null) {
            try {
                mPlayer2.stop();
                mPlayer2.release();
            } finally {
                mPlayer2 = null;
            }
        }
        return false;
    }
}
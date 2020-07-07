package com.wat128.nyan_java;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TestService extends Service {

    private MediaPlayer mediaPlayer;
    private int counter = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("debug", "onCreate()");

        mediaPlayer = MediaPlayer.create(this, R.raw.sample);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("debug", "onStartCommand()");

        int requestCode = intent.getIntExtra("REQUEST_CODE", 0);
        Context context = getApplicationContext();
        String channelId = "default";
        String title = context.getString(R.string.app_name);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel channel = new NotificationChannel(channelId, title, NotificationManager.IMPORTANCE_DEFAULT);

        if(notificationManager != null) {
            notificationManager.createNotificationChannel(channel);

            Notification notification = new Notification.Builder(context, channelId)
                    .setContentTitle(title)
                    .setSmallIcon(android.R.drawable.ic_media_play)
                    .setContentText("MediaPlay")
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setWhen(System.currentTimeMillis())
                    .build();

            startForeground(1, notification);

            audioStart();
        }

        return START_NOT_STICKY;
    }

    private void audioStart() {
        ++counter;
        Log.d("debug", "audioStart: " + String.valueOf(counter));

        if(mediaPlayer != null) {
            mediaPlayer.setLooping(true);

            mediaPlayer.start();

            String str = "Start Walking\n(c)Music-Note.jp";
            Toast toast = Toast.makeText(this, str, Toast.LENGTH_LONG);
            toast.show();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    Log.d("debug", "end of audio");

                    audioStop();

                    stopSelf();
                }
            });
        }
    }

    private void audioStop() {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("debug", "onDestroy()");

        if(mediaPlayer != null) {
            Log.d("debug", "end of audio");
            audioStop();
        }

        stopSelf();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

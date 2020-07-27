package com.wat128.nyan_java;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class TestService extends Service {

    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        InternalFileReadWrite fileReadWrite = new InternalFileReadWrite(context);
        fileReadWrite.writeFile();

        int requestCode = intent.getIntExtra("REQUEST_CODE", 0);

        String channelid = "default";
        String title = context.getString(R.string.app_name);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel channel = new NotificationChannel(channelid, title, NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Silent Notification");
        channel.setSound(null, null);
        channel.enableLights(false);
        channel.setLightColor(Color.BLUE);
        channel.enableVibration(false);

        if(notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
            Notification notification = new Notification.Builder(context, channelid)
                    .setContentTitle(title)
                    .setSmallIcon(android.R.drawable.btn_star)
                    .setContentText("Alarm Counter")
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setWhen(System.currentTimeMillis())
                    .build();

            startForeground(1, notification);

        }

        setNextAlarmService(context);

        return START_NOT_STICKY;
    }

    private void setNextAlarmService(Context context) {

        long repearPeriod = 15 * 60 * 1000;

        Intent intent = new Intent(context, TestService.class);

        long startMills = System.currentTimeMillis() + repearPeriod;

        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        if(alarmManager != null) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, startMills, pendingIntent);
        }
    }

    private void stopAlarmService() {
        Intent intent = new Intent(context, TestService.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        if(alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopSelf();;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}


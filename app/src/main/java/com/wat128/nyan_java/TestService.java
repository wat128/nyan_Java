package com.wat128.nyan_java;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
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

    private View view;
    private WindowManager windowManager;
    private int dpScale ;

    @Override
    public void onCreate() {
        super.onCreate();

        dpScale = (int)getResources().getDisplayMetrics().density;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Context context = getApplicationContext();
        String channelId = "default";
        String title = context.getString(R.string.app_name);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel channel = new NotificationChannel( channelId, title , NotificationManager.IMPORTANCE_DEFAULT);

        if(notificationManager != null){

            notificationManager.createNotificationChannel(channel);

            Notification notification = new Notification.Builder(context, channelId)
                    .setContentTitle(title)
                    .setSmallIcon(android.R.drawable.btn_star)
                    .setContentText("APPLICATION_OVERLAY")
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)
                    .setWhen(System.currentTimeMillis())
                    .build();

            startForeground(1, notification);
        }

        LayoutInflater layoutInflater = LayoutInflater.from(this);

        int typeLayer = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;

        windowManager = (WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams (
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                typeLayer,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                PixelFormat.TRANSLUCENT);

        params.gravity=  Gravity.TOP | Gravity.END;
        params.x = 20 * dpScale;
        params.y = 80 * dpScale;

        final ViewGroup nullParent = null;
        view = layoutInflater.inflate(R.layout.service_layer, nullParent);

        view.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("debug","onTouch");

                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Log.d("debug","ACTION_DOWN");
                }

                if(event.getAction() == MotionEvent.ACTION_UP){
                    Log.d("debug","ACTION_UP");
                    view.performClick();
                    stopSelf();
                }

                return false;
            }
        });

        windowManager.addView(view, params);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("debug","onDestroy");
        windowManager.removeView(view);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
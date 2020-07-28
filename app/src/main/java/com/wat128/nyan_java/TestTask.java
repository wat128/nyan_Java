package com.wat128.nyan_java;

import android.os.AsyncTask;
import android.util.Log;

public class TestTask extends AsyncTask<Integer, Integer, Integer> {

    private Listener listener;

    @Override
    protected Integer doInBackground(Integer... params) {

        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            Log.d("debug", "" + params[0]);
            params[0]++;
            publishProgress(params[0]);
        } while(params[0] < 10);

        return params[0];
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        if(listener != null)
            listener.onSuccess(values[0]);

    }

    @Override
    protected void onPostExecute(Integer result) {

        if(listener != null)
            listener.onSuccess(result);

    }

    void setListener(Listener listener) {
        this.listener = listener;
    }

    interface Listener {
        void onSuccess(int count);
    }
}

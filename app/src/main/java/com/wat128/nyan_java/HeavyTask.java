package com.wat128.nyan_java;

public class HeavyTask {

    private TestListener listener;

    interface TestListener {
        void onSuccess(int result);
    }

    void setListener(TestListener listener) {
        this.listener = listener;
    }

    void taskStart() {

        int sum = 1;
        int i = 0;

        for( ; i < 20; ) {
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            sum += sum;
            i++;
        }

        if(listener != null) {
            listener.onSuccess(sum);
        }
    }
}

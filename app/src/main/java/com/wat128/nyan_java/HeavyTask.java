package com.wat128.nyan_java;

public class HeavyTask {

    interface TestListener {
        void onSuccess(int result);
    }

    void TaskStart(final TestListener listener) {
        int sum = 1;
        int i = 0;
        for( ; i < 20; ) {
            sum += sum;
            i++;
        }

        if(listener != null) {
            listener.onSuccess(sum);
        }
    }
}

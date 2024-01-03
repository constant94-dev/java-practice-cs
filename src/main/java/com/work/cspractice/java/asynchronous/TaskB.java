package com.work.cspractice.java.asynchronous;

public class TaskB {
    private OnTaskEventListener mListener; // listener field

    // setting the listener
    public void registerOnTaskEventListener(OnTaskEventListener mListener) {
        this.mListener = mListener;
    }

    // Asynchronous task
    public void doTaskStuff() {
        // An Async task always execute in new thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                // perform any operation
                System.out.println("Performing operation in Asynchronous Task");

                // check if listener is registered
                if (mListener != null) {
                    // invoke the callback method of class TaskA
                    mListener.onTaskEvent();
                }
            }
        }).start();

        System.out.println("비동기 작업 수행 메서드 끝!");
    }
}

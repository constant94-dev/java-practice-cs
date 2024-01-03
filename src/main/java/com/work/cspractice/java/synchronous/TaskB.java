package com.work.cspractice.java.synchronous;

public class TaskB {
    private OnTaskEventListener mListener; // listener field

    // setting the listener
    public void registerOnTaskEventListener(OnTaskEventListener mListener) {
        this.mListener = mListener;
    }

    // Synchronous task
    public void doTaskStuff() {
        // perform any operation
        System.out.println("Performing callback before synchronous Task");

        // check if listener is registered
        if (this.mListener != null) {
            // invoke the callback method of class TaskA
            mListener.onTaskEvent();
        }

        System.out.println("동기 작업 수행 메서드 끝!!");
    }
}

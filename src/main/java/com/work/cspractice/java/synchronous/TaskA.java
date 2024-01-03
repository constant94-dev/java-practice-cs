package com.work.cspractice.java.synchronous;

public class TaskA implements OnTaskEventListener {
    @Override
    public void onTaskEvent() {
        System.out.println("Performing callback after synchronous Task");
        // perform some routine operation
    }
    // some class A methods
}

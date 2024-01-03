package com.work.cspractice.java.asynchronous;

public class TaskA implements OnTaskEventListener {
    @Override
    public void onTaskEvent() {
        System.out.println("Performing callback after Asynchronous Task");
        // perform some routine operation
    }
    // some class A methods
}

package com.github.douglasdocket.async.thread;

public class MethodAThread implements Runnable {

    private static boolean running = false;
    private static String formatedDate;
    private static long processDurationInMilis;

    public MethodAThread(String formatedDate, long processDurationInMilis) {
        this.formatedDate = formatedDate;
        this.processDurationInMilis = processDurationInMilis;
    }

    public static boolean isRunning() {
        return running;
    }

    @Override
    public void run() {

        if (MethodCThread.isRunning()) {
            System.out.println("MethodAThread.run - Don't run because MethodCThread is running.");
        }

        running = true;

        System.out.println("MethodAThread.run - " + formatedDate);

        try {

            Thread.sleep(processDurationInMilis);

            running = false;

            return;
        } catch (InterruptedException e) {
            running = false;

            e.printStackTrace();

            return;
        }

    }

}

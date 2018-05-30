package com.github.douglasdocket.async.thread;

public class MethodBThread implements Runnable {

    private static boolean running = false;
    private static String formatedDate;
    private static long processDurationInMilis;

    public MethodBThread(String formatedDate, long processDurationInMilis) {
        this.formatedDate = formatedDate;
        this.processDurationInMilis = processDurationInMilis;
    }

    public static boolean isRunning() {
        return running;
    }

    @Override
    public void run() {

        if (MethodAThread.isRunning()) {
            System.out.println("MethodBThread.run - Don't run because MethodAThread is running.");
        }

        running = true;

        System.out.println("MethodBThread.run - " + formatedDate);

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

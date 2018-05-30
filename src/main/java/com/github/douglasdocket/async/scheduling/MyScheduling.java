package com.github.douglasdocket.async.scheduling;

import com.github.douglasdocket.async.thread.MethodAThread;
import com.github.douglasdocket.async.thread.MethodCThread;
import com.github.douglasdocket.async.thread.MethodBThread;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MyScheduling {

    private static final long SEGUNDO = 1000;

    private static final DateFormat formatToHHMMSS = new SimpleDateFormat("HH:mm:ss");

    private static final String TIME_ZONE = "America/Sao_Paulo";

    private static final String CRON_METHOD_A = "0/8 * * * * ?";
    private static final String CRON_METHOD_B = "0/3 * * * * ?";
    private static final String CRON_METHOD_C = "0/5 * * * * ?";

    private static final long METHOD_A_PROCESS_DURATION = SEGUNDO * 10;
    private static final long METHOD_B_PROCESS_DURATION = SEGUNDO * 5;
    private static final long METHOD_C_PROCESS_DURATION = SEGUNDO * 7;

    @Scheduled(cron = CRON_METHOD_A, zone = TIME_ZONE)
    public void methodA() {
        String formatedDate = formatToHHMMSS.format(new Date());

        MethodAThread methodAThread = new MethodAThread(formatedDate, METHOD_A_PROCESS_DURATION);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(methodAThread);

        return;
    }

    @Scheduled(cron = CRON_METHOD_B, zone = TIME_ZONE)
    public void methodB() {
        String formatedDate = formatToHHMMSS.format(new Date());

        MethodBThread methodBThread = new MethodBThread(formatedDate, METHOD_B_PROCESS_DURATION);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(methodBThread);

        return;
    }

    @Scheduled(cron = CRON_METHOD_C, zone = TIME_ZONE)
    public void methodC() {
        String formatedDate = formatToHHMMSS.format(new Date());

        MethodCThread methodAThread = new MethodCThread(formatedDate, METHOD_C_PROCESS_DURATION);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(methodAThread);

        return;
    }

}

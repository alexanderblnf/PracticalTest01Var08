package ro.pub.cs.systems.eim.practicaltest01var08;

/**
 * Created by student on 04.04.2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import java.util.Date;
import java.util.Random;

public class ProcessingThread extends Thread {

    private Context context = null;
    private boolean isRunning = true;



    public ProcessingThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (isRunning) {
            Log.d("[Service]", "Hello!");
            sendMessage();
            sleep();
        }
    }

    private void sendMessage() {
        Random generator = new Random();
        Intent intent = new Intent();
        intent.putExtra("nr1", generator.nextInt());
        intent.putExtra("nr2", generator.nextInt());
        intent.putExtra("nr3", generator.nextInt());
        intent.putExtra("nr4", generator.nextInt());
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}

package com.example.machine3.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by machine3 on 3/4/16.
 */
public class MyService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyService() {
        super("myworkerthread");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"service started ...",Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        synchronized (this)
        {
            int i=0;
            while(i<5)
            {
                try {
                    wait(10000);
                    i++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"service stopped ...",Toast.LENGTH_LONG).show();
    }
}

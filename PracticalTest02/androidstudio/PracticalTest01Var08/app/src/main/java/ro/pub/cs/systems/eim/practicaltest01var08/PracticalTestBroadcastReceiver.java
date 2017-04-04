package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;

/**
 * Created by student on 04.04.2017.
 */

public class PracticalTestBroadcastReceiver extends BroadcastReceiver{
    EditText nr1, nr2, nr3, nr4;

    public PracticalTestBroadcastReceiver(EditText nr1, EditText nr2, EditText nr3, EditText nr4) {
        this.nr1 = nr1;
        this.nr2 = nr2;
        this.nr3 = nr3;
        this.nr4 = nr4;
    }

    public void onReceive(Context context, Intent intent) {
        // TODO: exercise 7 - get the action and the extra information from the intent
        // and set the text on the messageTextView

        int n1 = intent.getIntExtra("nr1", 0);
        int n2 = intent.getIntExtra("nr2", 0);
        int n3 = intent.getIntExtra("nr3", 0);
        int n4 = intent.getIntExtra("nr4", 0);

        nr1.setText(n1);
        nr2.setText(n2);
        nr3.setText(n3);
        nr4.setText(n4);

    }
}

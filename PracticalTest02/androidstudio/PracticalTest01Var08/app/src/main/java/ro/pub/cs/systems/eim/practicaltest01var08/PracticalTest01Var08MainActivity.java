package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

    private class SetClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText nr1, nr2, nr3, nr4;
            nr1 = (EditText)findViewById(R.id.nr1);
            nr2 = (EditText)findViewById(R.id.nr2);
            nr3 = (EditText)findViewById(R.id.nr3);
            nr4 = (EditText)findViewById(R.id.nr4);

            if(!isEmpty(nr1) && !isEmpty(nr2) && !isEmpty(nr3) && !isEmpty(nr4)) {
                if(TextUtils.isDigitsOnly(nr1.getText()) && TextUtils.isDigitsOnly(nr2.getText()) && TextUtils.isDigitsOnly(nr3.getText()) && TextUtils.isDigitsOnly(nr4.getText())) {
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08SecondaryActivity.class);
                    int n1 = Integer.parseInt(nr1.getText().toString());
                    int n2 = Integer.parseInt(nr2.getText().toString());
                    int n3 = Integer.parseInt(nr3.getText().toString());
                    int n4 = Integer.parseInt(nr4.getText().toString());
                    intent.putExtra("nr1", n1);
                    intent.putExtra("nr2", n2);
                    intent.putExtra("nr3", n3);
                    intent.putExtra("nr4", n4);
                    startActivityForResult(intent, 100);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        EditText nr1, nr2, nr3, nr4;
        nr1 = (EditText)findViewById(R.id.nr1);
        nr2 = (EditText)findViewById(R.id.nr2);
        nr3 = (EditText)findViewById(R.id.nr3);
        nr4 = (EditText)findViewById(R.id.nr4);

        Button set = (Button)findViewById(R.id.setbtn);
        SetClickListener setClickListener = new SetClickListener();
        set.setOnClickListener(setClickListener);

        Intent intent = new Intent(this, PracticalTest01Var08Service.class);
        startService(intent);

        PracticalTestBroadcastReceiver practicalTestBroadcastReceiver = new PracticalTestBroadcastReceiver(nr1, nr2, nr3, nr4);


    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        EditText nr1, nr2, nr3, nr4;
        nr1 = (EditText)findViewById(R.id.nr1);
        nr2 = (EditText)findViewById(R.id.nr2);
        nr3 = (EditText)findViewById(R.id.nr3);
        nr4 = (EditText)findViewById(R.id.nr4);
        savedInstanceState.putString("nr1", nr1.getText().toString());
        savedInstanceState.putString("nr2", nr2.getText().toString());
        savedInstanceState.putString("nr3", nr3.getText().toString());
        savedInstanceState.putString("nr4", nr4.getText().toString());

        super.onSaveInstanceState(savedInstanceState);
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        String n1 = savedInstanceState.getString("nr1");
        String n2 = savedInstanceState.getString("nr2");
        String n3 = savedInstanceState.getString("nr3");
        String n4 = savedInstanceState.getString("nr4");

        EditText nr1, nr2, nr3, nr4;
        nr1 = (EditText)findViewById(R.id.nr1);
        nr2 = (EditText)findViewById(R.id.nr2);
        nr3 = (EditText)findViewById(R.id.nr3);
        nr4 = (EditText)findViewById(R.id.nr4);

        nr1.setText(n1);
        nr2.setText(n2);
        nr3.setText(n3);
        nr4.setText(n4);


    }
}

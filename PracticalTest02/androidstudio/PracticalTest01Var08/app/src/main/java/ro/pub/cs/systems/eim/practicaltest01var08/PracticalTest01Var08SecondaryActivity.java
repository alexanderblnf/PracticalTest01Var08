package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var08SecondaryActivity extends AppCompatActivity {

    private class SumListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            TextView text1 = (TextView)findViewById(R.id.nr1show);
            TextView text2 = (TextView)findViewById(R.id.nr2show);
            TextView text3 = (TextView)findViewById(R.id.nr3show);
            TextView text4 = (TextView)findViewById(R.id.nr4show);

            int nr1 = Integer.parseInt(text1.getText().toString());
            int nr2 = Integer.parseInt(text2.getText().toString());
            int nr3 = Integer.parseInt(text3.getText().toString());
            int nr4 = Integer.parseInt(text4.getText().toString());

            int sum = nr1 + nr2 + nr3 + nr4;
            Toast.makeText(getApplicationContext(), "Suma: " + sum, Toast.LENGTH_LONG).show();
        }
    }

    private class ProdListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            TextView text1 = (TextView)findViewById(R.id.nr1show);
            TextView text2 = (TextView)findViewById(R.id.nr2show);
            TextView text3 = (TextView)findViewById(R.id.nr3show);
            TextView text4 = (TextView)findViewById(R.id.nr4show);

            int nr1 = Integer.parseInt(text1.getText().toString());
            int nr2 = Integer.parseInt(text2.getText().toString());
            int nr3 = Integer.parseInt(text3.getText().toString());
            int nr4 = Integer.parseInt(text4.getText().toString());

            int prod = nr1 * nr2 * nr3 * nr4;
            Toast.makeText(getApplicationContext(), "Produs: " + prod, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_secondary);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("nr1")) {
            int nr1 = intent.getIntExtra("nr1", 0);
            int nr2 = intent.getIntExtra("nr2", 0);
            int nr3 = intent.getIntExtra("nr3", 0);
            int nr4 = intent.getIntExtra("nr4", 0);
            TextView text1 = (TextView)findViewById(R.id.nr1show);
            TextView text2 = (TextView)findViewById(R.id.nr2show);
            TextView text3 = (TextView)findViewById(R.id.nr3show);
            TextView text4 = (TextView)findViewById(R.id.nr4show);
            text1.setText(Integer.toString(nr1));
            text2.setText(Integer.toString(nr2));
            text3.setText(Integer.toString(nr3));
            text4.setText(Integer.toString(nr4));
        }

        Button sum = (Button)findViewById(R.id.sumbtn);
        Button prod = (Button)findViewById(R.id.prodbtn);

        SumListener sumListener = new SumListener();
        ProdListener prodListener = new ProdListener();
        sum.setOnClickListener(sumListener);
        prod.setOnClickListener(prodListener);
    }
}

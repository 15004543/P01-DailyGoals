package sg.edu.rp.c347.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Button btn = (Button) findViewById(R.id.buttonDone);
        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");
        TextView tv1 = (TextView) findViewById(R.id.textViewSummary);
        tv1.setText("Read up on materials before class : " + info[0] +
                "\nArrive on time so as not to miss important part of the lesson : " + info[1] +
                "\nAttempt the problem myself : " + info[2] +
                "\nReflection : " + info[3]);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    }
}

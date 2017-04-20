package sg.edu.rp.c347.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button1);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = (RadioButton) findViewById(selectedButtonId1);

                RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);

                RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);

                EditText etReflection = (EditText) findViewById(R.id.editText);

                String[] info = {rb1.getText().toString(),
                        rb2.getText().toString(),
                        rb3.getText().toString(),
                        etReflection.getText().toString()};

                Intent i = new Intent(MainActivity.this,
                        SummaryActivity.class);
                i.putExtra("info", info);
                startActivity(i);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        int selectedButtonId1 = rg1.getCheckedRadioButtonId();

        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        int selectedButtonId2 = rg2.getCheckedRadioButtonId();

        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
        int selectedButtonId3 = rg3.getCheckedRadioButtonId();

        EditText etReflection = (EditText) findViewById(R.id.editText);

        String strReflect = etReflection.getText().toString();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putInt("RB1", selectedButtonId1);
        prefEdit.putInt("RB2", selectedButtonId2);
        prefEdit.putInt("RB3", selectedButtonId3);
        prefEdit.putString("etRef", strReflect);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        int crb1 = prefs.getInt("RB1", 0);
        int crb2 = prefs.getInt("RB2", 0);
        int crb3 = prefs.getInt("RB3", 0);
        String strDT = prefs.getString("etRef", "");
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);

        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);

        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);

        EditText etReflection = (EditText) findViewById(R.id.editText);

        etReflection.setText(strDT);
        rg1.check(crb1);
        rg2.check(crb2);
        rg3.check(crb3);
    }
}

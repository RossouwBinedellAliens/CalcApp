package maintest.calcapp;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup rbg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("OnClick", "onStart: " );
        TextView tw = (TextView) findViewById(R.id.textView_Output);
        tw.setText("");
        rbg = (RadioGroup) findViewById(R.id.activity_main_radioGroup);
        rbg.check(R.id.activity_main_radioButton_add);


        Button btnSubmit = (Button) findViewById(R.id.commitButton);
        btnSubmit.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.commitButton) {
            int selection = getSelection();
            Log.d("OnClick", "onClick: Selection: " + selection);
            EditText num1 = (EditText) findViewById(R.id.activity_main_firstNum);
            EditText num2 = (EditText) findViewById(R.id.activity_main_secondNum);
            int total = 0;
            if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter a valid number!", Toast.LENGTH_SHORT).show();
            } else {
                switch (selection) {
                    case 1:
                        total = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
                        break;
                    case 2:
                        total = Integer.parseInt(num1.getText().toString()) - Integer.parseInt(num2.getText().toString());
                        break;
                    case 3:
                        total = Integer.parseInt(num1.getText().toString()) * Integer.parseInt(num2.getText().toString());
                        break;
                    case 4:
                        total = Integer.parseInt(num1.getText().toString()) / Integer.parseInt(num2.getText().toString());
                        break;
                    default:
                        total = -1;
                }
                TextView outputText = (TextView) findViewById(R.id.textView_Output);
               //try {
                   outputText.setText(total+"");
               //} catch ( NullPointerException n){
                 //  System.out.println(n.getMessage());
               //}

            }
        }
    }

    private int getSelection() {
        if (rbg.getCheckedRadioButtonId()==R.id.activity_main_radioButton_add) {
            return 1;
        } else if (rbg.getCheckedRadioButtonId()==R.id.activity_main_radioButton_subtract) {
            return 2;
        } else if (rbg.getCheckedRadioButtonId()==R.id.activity_main_radioButton_multiply) {
            return 3;
        } else if (rbg.getCheckedRadioButtonId()==R.id.activity_main_radioButton_divide) {
            return 4;
        } else {
            return 0;
        }

    }
}

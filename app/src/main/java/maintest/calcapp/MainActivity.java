package maintest.calcapp;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.activity_main_radioButton_add).setSelected(true);
        TextView tw = (TextView) findViewById(R.id.textView_Output);
        tw.setText("");


        Button btnSubmit = (Button) findViewById(R.id.commitButton);
        btnSubmit.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.commitButton) {
            int selection = getSelection();
            EditText num1 = (EditText) findViewById(R.id.activity_main_firstNum);
            EditText num2 = (EditText) findViewById(R.id.activity_main_secondNum);
            int total = 0;
            if (num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter a valid number!", Toast.LENGTH_SHORT);
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
                outputText.setText(total+"");

            }
        }
    }

    private int getSelection() {
        if (findViewById(R.id.activity_main_radioButton_add).isSelected()) {
            return 1;
        } else if (findViewById(R.id.activity_main_radioButton_subtract).isSelected()) {
            return 2;
        } else if (findViewById(R.id.activity_main_radioButton_multiply).isSelected()) {
            return 3;
        } else if (findViewById(R.id.activity_main_radioButton_divide).isSelected()) {
            return 4;
        } else {
            return 0;
        }


    }
}

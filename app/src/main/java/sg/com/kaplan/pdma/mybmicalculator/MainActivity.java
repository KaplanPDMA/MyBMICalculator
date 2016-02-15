package sg.com.kaplan.pdma.mybmicalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textViewStatus = (TextView) findViewById(R.id.textViewStatus);
        final EditText editTextWeight = (EditText) findViewById(R.id.editTextWeight);
        final EditText editTextHeight = (EditText) findViewById(R.id.editTextHeight);
        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the values of weight and height and validate the values
                String weightString = editTextWeight.getText().toString();
                String heightString = editTextHeight.getText().toString();
                double weight = 0, height = 0;
                try {
                    weight = Double.parseDouble(weightString);
                    height = Double.parseDouble(heightString);
                } catch(NumberFormatException ex) {
                    Toast.makeText(getApplicationContext(), "input error",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // calculate the BMI
                double bmi = 0;
                if(height > 0) {
                    bmi = (weight) / (height * height);
                }

                // display status accordingly
                String status =  getStatus(bmi);
                textViewStatus.setText(status);

            }
        });


    }

    private String getStatus(double bmi) {
        String status;
        if(bmi >= 27.5) {
            status = "High Risk";
        } else if(bmi >= 23) {
            status = "Moderate Risk";
        } else if(bmi >= 18.5) {
            status = "Low Risk";
        } else {
            status = "Malnutrition";
        }

        return status;
    }

}

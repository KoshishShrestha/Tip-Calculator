package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the "Calculate" button in the layout and set a listener to it
        Button BtnCal = findViewById(R.id.calculate_button);
        BtnCal.setOnClickListener(v -> {
            tipCalculate();
        });
    }

    // This method calculates the tip and updates with the result
    private void tipCalculate() {
        RadioGroup tipOption = findViewById(R.id.tip_options);
        TextView tipResult = findViewById(R.id.tip_result);
        EditText costAmount = findViewById(R.id.cost_of_service);
        Switch roundUp = findViewById(R.id.round_up_switch);
        boolean RoundUp = roundUp.isChecked();
        double result = 0;
        try {
            //Get the cost amount from input and parse it into Double
            Double amount = Double.parseDouble(costAmount.getText().toString());

            // Get the selected radio button ID
            int selectedOption = tipOption.getCheckedRadioButtonId();

            // Calculate as per selected option and round up Tip
            if (RoundUp) {

                if (selectedOption == R.id.option_twenty_percent) {

                    // Calculate the result and round it up
                    result = Math.ceil(amount * 0.20);

                    // Update the text with the result
                    tipResult.setText("Tip Amount: " + String.valueOf(result));

                } else if (selectedOption == R.id.option_eighteen_percent) {
                    result = Math.ceil(amount * 0.18);
                    tipResult.setText("Tip Amount: " + String.valueOf(result));

                } else if (selectedOption == R.id.option_fifteen_percent) {
                    result = Math.ceil(amount * 0.15);
                    tipResult.setText("Tip Amount: " + String.valueOf(result));
                }
            }
            else{
                // Calculate the result based on selected option, round it up is off
                DecimalFormat f = new DecimalFormat("#.###");

            if (selectedOption == R.id.option_twenty_percent) {

                // Calculate the result
                result = amount * 0.20;

                // Format the result based on the Decimal Format
                String formattedResult = f.format(result);
                double finalResult = Double.parseDouble((formattedResult));

                // Update the text with the result
                tipResult.setText("Tip Amount: " + String.valueOf(finalResult));

            } else if (selectedOption == R.id.option_eighteen_percent) {
                result = amount * 0.18;
                String formattedResult = f.format(result);
                double finalResult = Double.parseDouble((formattedResult));

                // Update the text with the result
                tipResult.setText("Tip Amount: " + String.valueOf(finalResult));

            } else if (selectedOption == R.id.option_fifteen_percent) {

                // Calculate the result
                result = amount * 0.15;

                // Format the result based on the Decimal Format
                String formattedResult = f.format(result);
                double finalResult = Double.parseDouble((formattedResult));

                // Update the text with the result
                tipResult.setText("Tip Amount: " + String.valueOf(finalResult));
            }
        }
    }
        catch (NumberFormatException e) {
            // Show a toast message if the user did not enter a valid cost
            Toast toast = Toast.makeText(this, "Please enter the correct amount", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
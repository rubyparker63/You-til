package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;

public class ConversionLengthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_length);
        //dropdown menu for length from
        final Spinner lengthSpinnerFrom = (Spinner) findViewById(R.id.lengthSpinner1);
        ArrayAdapter<String> lengthAdapter1 = new ArrayAdapter<String>(ConversionLengthActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.DistanceOptions));
        lengthAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lengthSpinnerFrom.setAdapter(lengthAdapter1);

        //dropdown menu for length to
        final Spinner lengthSpinnerTo = (Spinner) findViewById(R.id.lengthSpinner2);
        ArrayAdapter<String> lengthAdapter2 = new ArrayAdapter<String>(ConversionLengthActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.DistanceOptions));
        lengthAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lengthSpinnerTo.setAdapter(lengthAdapter2);

        Button lengthEnterBtn = (Button) findViewById(R.id.lengthEnterButton);
        lengthEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText lengthInputET = (EditText) findViewById(R.id.lengthImputEditText);
                double lengthInput = Double.parseDouble(lengthInputET.getText().toString());
                int from = lengthSpinnerFrom.getSelectedItemPosition();
                int to = lengthSpinnerTo.getSelectedItemPosition();
                convert(from, to, lengthInput);

            }
        });

    }


    public void convert(int from, int to, double origNumber){
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        String unit = "";
        if(to == 0){
            unit = " km";
        }
        else if(to == 1){
            unit = " m";
        }
        else if(to == 2){
            unit = " miles";
        }
        else if(to == 3){
            unit = " y";
        }
        else if(to == 4){
            unit = " ft";
        }
        else{
            unit = " in";
        }

        double answer = 0.0;
        if (from == to){
            answer = origNumber;
        }
        else if (from == 4 && to == 5){
            //feet to Inches(double num)  {
            answer = origNumber * 12.0;
        }
        else if (from == 2 && to == 5){
            //miles to Inches
            answer = origNumber * 63360.0;
        }
        else if (from == 3 && to == 5){
            //yards to Inches
            answer = origNumber * 36.0;
        }
        else if (from == 1 && to == 5){
            //meters to Inches
            answer = origNumber * 39.37;
        }
        else if (from == 0 && to == 5){
            //kilometers to Inches
            answer = origNumber * 39370.07874;
        }
        //to Feet
        else if (from == 5 && to == 4){
            //inches to Feet
            answer = origNumber / 12.0;
        }
        else if (from == 2 && to == 4){
            //miles to Feet
            answer = origNumber * 5280.0;
        }
        else if (from == 3 && to == 4){
            //yards to Feet
            answer = origNumber * 3.0;
        }
        else if (from == 1 && to == 4){
            //meters to Feet
            answer = origNumber * 3.28084;
        }
        else if (from == 0 && to == 4){
            //kilometers to Feet
            answer = origNumber * 3280.84;
        }
        //to Miles
        else if (from == 5 && to == 2){
            //inches to Miles
            answer = origNumber / 63360.0;
        }
        else if (from == 4 && to == 2){
            //feet to Miles
            answer = origNumber / 5280.0;
        }
        else if (from == 3 && to == 2){
            //yards to Miles
            answer = origNumber / 1760.0;
        }
        else if (from == 1 && to == 2){
            //meters to Miles
            answer = origNumber / 1609.0;
        }
        else if (from == 0 && to == 2){
            //kilometers to Miles
            answer = origNumber / 1.6090;
        }
//to Yards
        else if (from == 5 && to == 3){
            //inches to Yards
            answer = origNumber / 36.0;
        }
        else if (from == 4 && to == 3){
            //feet to Yards
            answer = origNumber / 3.0;
        }
        else if (from == 2 && to == 3){
            //miles to Yards
            answer = origNumber * 1760.0;
        }
        else if (from == 1 && to == 3){
            //meters to Yards
            answer = origNumber * 1.09361;
        }
        else if (from == 0 && to == 3){
            //kilometers to Yards
            answer = origNumber * 1093.61;
        }
//to Meters
        else if (from == 5 && to == 1){
            //inches to Meters
            answer = origNumber / 39.37;
        }
        else if (from == 4 && to == 1){
            //feet to Meters
            answer = origNumber / 3.28084;
        }
        else if (from == 2 && to == 1){
            //miles to Meters
            answer = origNumber * 1609.0;
        }
        else if (from == 3 && to == 1){
            //yards to Meters
            answer = origNumber / 1.09361;
        }
        else if (from == 0 && to == 1){
            //kilometers to Meters
            answer = origNumber * 1000;
        }
//to Meters
        else if (from == 5 && to == 0){
            //inches to Kilometers
            answer = origNumber / 39370.07874;
        }
        else if (from == 4 && to == 0){
            //feet to Kilometers
            answer = origNumber / 3280.84;
        }
        else if (from == 2 && to == 0){
            //miles to Kilometers
            answer = origNumber * 1.6090;
        }
        else if (from == 3 && to == 0){
            //yards to Kilometers
            answer = origNumber / 1093.61;
        }
        else if (from == 1 && to == 0){
            //meters to Kilometers
            answer = origNumber / 1000;
        }
        else{
            //error message
            unit = "error";
        }
        BigDecimal round = new BigDecimal(answer);
        round = round.setScale(3, BigDecimal.ROUND_HALF_UP);
        double roundedAnswer = round.doubleValue();
        resultTextView.setText(roundedAnswer + unit);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quick_acess, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.calculatorItem:
                Intent goToCalculatorItem = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivity(goToCalculatorItem);
                return true;
            case R.id.tipCalculatorItem:
                Intent goToTipCalculatorItem = new Intent(getApplicationContext(), TipCalculatorActivity.class);
                startActivity(goToTipCalculatorItem);
                return true;
            case R.id.conversionsItem:
                Intent goToConversionsItem = new Intent(getApplicationContext(), UnitSelectActivity.class);
                startActivity(goToConversionsItem);
                return true;
            case R.id.dieRollItem:
                Intent goToDieRollItem = new Intent(getApplicationContext(), DiceRollSelectActivity.class);
                startActivity(goToDieRollItem);
                return true;
            case R.id.coinFlipItem:
                Intent goToCoinFlipItem = new Intent(getApplicationContext(), CoinFLipActivity.class);
                startActivity(goToCoinFlipItem);
                return true;
            case R.id.settingsItem:
                Intent goToSettingsItem = new Intent(getApplicationContext(), SettingsActivityFix.class);
                startActivity(goToSettingsItem);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


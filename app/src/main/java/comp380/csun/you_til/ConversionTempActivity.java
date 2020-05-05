package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;

public class ConversionTempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_temp);

        //dropdown menu for temperature from
        final Spinner tempSpinnerFrom = (Spinner) findViewById(R.id.tempSpinner1);
        ArrayAdapter<String> tempAdapter1 = new ArrayAdapter<String>(ConversionTempActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.TemeratureOptions));

        tempAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempSpinnerFrom.setAdapter(tempAdapter1);

        //dropdown menu for temperature to
        final Spinner tempSpinnerTo = (Spinner) findViewById(R.id.tempSpinner2);
        ArrayAdapter<String> tempAdapter2 = new ArrayAdapter<String>(ConversionTempActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.TemeratureOptions));

        tempAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempSpinnerTo.setAdapter(tempAdapter2);
        Button tempEnterBtn = (Button) findViewById(R.id.tempEnterButton);
        tempEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tempInputET = (EditText) findViewById(R.id.tempInputEditText);
                double tempInput = Double.parseDouble(tempInputET.getText().toString());
                int from = tempSpinnerFrom.getSelectedItemPosition();
                int to = tempSpinnerTo.getSelectedItemPosition();

                convertTemp(from, to, tempInput);
            }
        });
    }

    public void convertTemp(int from, int to, double origNumber){

        TextView resultTextView = (TextView) findViewById(R.id.convToTempTextView);
        double answer = 0;
        String unit = "";
        if(to == 0){
            unit = " K";
        }
        else if(to == 1){
            unit = " °C";
        }
        else{
            unit = " °F";
        }

        if (from == to){
            answer = origNumber;
        }
        else if (from == 1 && to == 0){
            //celsius to Kelvin
            answer= origNumber + 273.15;
        }
        else if (from == 2 && to == 0){
            //fahrenheit to Kelvin
            answer= (origNumber - 32.0) * (5.0/9.0) + 285.928;
        }
        else if (from == 0 && to == 1){
            //kelvin to Celsius
            answer= origNumber - 273.15;
        }
        else if (from == 2 && to == 1){
            //fahrenheit to Celsius
            answer= (origNumber - 32.0) * (5.0/9.0);
        }
        else if (from == 0 && to == 2){
            //kelvin to Fahrenheit
            answer= (origNumber - 273.15) * (9.0/5.0) + 32;
        }
        else if (from == 1 && to == 2){
            //celsius to Fahrenheit
            answer= (origNumber * 9.0) /5.0 + 32;
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
}

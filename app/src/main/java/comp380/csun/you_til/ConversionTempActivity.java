package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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

    private void sameUnit(double num, int unit)  {
        String degree = "";
        if(unit == 0){
            degree = "K";
        }
        else if(unit == 1){
            degree = "°C";
        }
        else{
            degree = "°F";
        }

        TextView resultTextView = (TextView) findViewById(R.id.convToTempTextView);
        resultTextView.setText(num + " " + degree);
    }
    private void celsiusToKelvin(double num)  {
        double answer = num + 273.15;
        TextView resultTextView = (TextView) findViewById(R.id.convToTempTextView);
        resultTextView.setText(answer + " K");
    }
    private void fahrenheitToKelvin(double num)  {
        double answer = (num - 32.0) * (5.0/9.0) + 285.928;
        TextView resultTextView = (TextView) findViewById(R.id.convToTempTextView);
        resultTextView.setText(answer + " K");
    }
    private void kelvinToCelsius(double num)  {
        double answer = num - 273.15;
        TextView resultTextView = (TextView) findViewById(R.id.convToTempTextView);
        resultTextView.setText(answer + " °C");
    }
    private void fahrenheitToCelsius(double num)  {
        double answer = (num - 32.0) * (5.0/9.0);
        TextView resultTextView = (TextView) findViewById(R.id.convToTempTextView);
        resultTextView.setText(answer + " °C");
    }
    private void kelvinToFahrenheit(double num)  {
        double answer = (num - 273.15) * (9.0/5.0) + 32;
        TextView resultTextView = (TextView) findViewById(R.id.convToTempTextView);
        resultTextView.setText(answer + " °F");
    }
    private void celsiusToFahrenheit(double num)  {
        double answer = (num * 9.0) /5.0 + 32;
        TextView resultTextView = (TextView) findViewById(R.id.convToTempTextView);
        resultTextView.setText(answer + " °F");
    }

    public void convertTemp(int from, int to, double origNumber){

        if (from == to){
            sameUnit(origNumber, from);
        }
        else if (from == 1 && to == 0){
            celsiusToKelvin(origNumber);
        }
        else if (from == 2 && to == 0){
            fahrenheitToKelvin(origNumber);
        }
        else if (from == 0 && to == 1){
            kelvinToCelsius(origNumber);
        }
        else if (from == 2 && to == 1){
            fahrenheitToCelsius (origNumber);
        }
        else if (from == 0 && to == 2){
            kelvinToFahrenheit(origNumber);
        }
        else if (from == 1 && to == 2){
            celsiusToFahrenheit(origNumber);
        }
        else{
                //error message
                TextView resultTextView = (TextView) findViewById(R.id.convToTempTextView);
                resultTextView.setText("Error");

            }
        }
}

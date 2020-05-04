package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
                String unit = lengthSpinnerTo.getSelectedItem().toString();
                convert(from, to, lengthInput, unit);

            }
        });

    }
    //to inches
    private void feetToInches(double num)  {
        double answer = num * 12.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Inches");
    }
    private void milesToInches(double num)  {
        double answer = num * 63360.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Inches");
    }
    private void yardsToInches(double num)  {
        double answer = num * 36.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Inches");
    }
    private void metersToInches(double num)  {
        double answer = num * 39.37;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Inches");
    }
    private void kilometersToInches(double num)  {
        double answer = num * 39370.07874;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Inches");
    }
    private void sameUnit(double num, String unit)  {

        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(num + " " + unit);
    }
    //to feet
    private void milesToFeet(double num)  {
        double answer = num * 5280.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Feet");
    }
    private void yardsToFeet(double num)  {
        double answer = num * 3.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Feet");
    }
    private void metersToFeet(double num)  {
        double answer = num * 3.28084;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Feet");
    }
    private void kilometersToFeet(double num)  {
        double answer = num * 3280.84;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Feet");
    }
    private void inchesToFeet(double num)  {
        double answer = num / 12.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Feet");
    }
    //to miles
    private void feetToMiles(double num)  {
        double answer = num / 5280.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Miles");
    }
    private void yardsToMiles(double num)  {
        double answer = num / 1760.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Miles");
    }
    private void metersToMiles(double num)  {
        double answer = num / 1609.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Miles");
    }
    private void kilometersToMiles(double num)  {
        double answer = num / 1.6090;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Miles");
    }
    private void inchesToMiles(double num)  {
        double answer = num / 63360.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Miles");
    }
    //to Yards
    private void feetToYards(double num)  {
        double answer = num / 3.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Yards");
    }
    private void milesToYards(double num)  {
        double answer = num * 1760.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Miles");
    }
    private void metersToYards(double num)  {
        double answer = num * 1.09361;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Yards");
    }
    private void kilometersToYards(double num)  {
        double answer = num * 1093.61;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Yards");
    }
    private void inchesToYards(double num)  {
        double answer = num / 36.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Yards");
    }
    //to Meters
    private void feetToMeters(double num)  {
        double answer = num / 3.28084;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Meters");
    }
    private void milesToMeters(double num)  {
        double answer = num * 1609.0;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Meters");
    }
    private void yardsToMeters(double num)  {
        double answer = num / 1.09361;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Meters");
    }
    private void kilometersToMeters(double num)  {
        double answer = num * 1000;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Meters");
    }
    private void inchesToMeters(double num)  {
        double answer = num / 39.37;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Meters");
    }
    //to Kilometers
    private void feetToKilometers(double num)  {
        double answer = num / 3280.84;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Kilometers");
    }
    private void milesToKilometers(double num)  {
        double answer = num * 1.6090;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Kilometers");
    }
    private void yardsToKilometers(double num)  {
        double answer = num / 1093.61;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Kilometers");
    }
    private void metersToKilometers(double num)  {
        double answer = num / 1000;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Kilometers");
    }
    private void inchesToKilometers(double num)  {
        double answer = num / 39370.07874;
        TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
        resultTextView.setText(answer + " Kilometers");
    }



    public void convert(int from, int to, double origNumber, String unit){


        if (from == to){
            sameUnit(origNumber, unit);
        }
        else if (from == 4 && to == 5){
            feetToInches(origNumber);
        }
        else if (from == 2 && to == 5){
            milesToInches(origNumber);
        }
        else if (from == 3 && to == 5){
            yardsToInches(origNumber);
        }
        else if (from == 1 && to == 5){
            metersToInches(origNumber);
        }
        else if (from == 0 && to == 5){
            kilometersToInches(origNumber);
        }
//to Feet
        else if (from == 5 && to == 4){
            inchesToFeet(origNumber);
        }
        else if (from == 2 && to == 4){
            milesToFeet(origNumber);
        }
        else if (from == 3 && to == 4){
            yardsToFeet(origNumber);
        }
        else if (from == 1 && to == 4){
            metersToFeet(origNumber);
        }
        else if (from == 0 && to == 4){
            kilometersToFeet(origNumber);
        }
//to Miles
        else if (from == 5 && to == 2){
            inchesToMiles(origNumber);
        }
        else if (from == 4 && to == 2){
            feetToMiles(origNumber);
        }
        else if (from == 3 && to == 2){
            yardsToMiles(origNumber);
        }
        else if (from == 1 && to == 2){
            metersToMiles(origNumber);
        }
        else if (from == 0 && to == 2){
            kilometersToMiles(origNumber);
        }
//to Yards
        else if (from == 5 && to == 3){
            inchesToYards(origNumber);
        }
        else if (from == 4 && to == 3){
            feetToYards(origNumber);
        }
        else if (from == 2 && to == 3){
            milesToYards(origNumber);
        }
        else if (from == 1 && to == 3){
            metersToYards(origNumber);
        }
        else if (from == 0 && to == 3){
            kilometersToYards(origNumber);
        }
//to Meters
        else if (from == 5 && to == 1){
            inchesToMeters(origNumber);
        }
        else if (from == 4 && to == 1){
            feetToMeters(origNumber);
        }
        else if (from == 2 && to == 1){
            milesToMeters(origNumber);
        }
        else if (from == 3 && to == 1){
            yardsToMeters(origNumber);
        }
        else if (from == 0 && to == 1){
            kilometersToMeters(origNumber);
        }
//to Meters
        else if (from == 5 && to == 0){
            inchesToKilometers(origNumber);
        }
        else if (from == 4 && to == 0){
            feetToKilometers(origNumber);
        }
        else if (from == 2 && to == 0){
            milesToKilometers(origNumber);
        }
        else if (from == 3 && to == 0){
            yardsToKilometers(origNumber);
        }
        else if (from == 1 && to == 0){
            metersToKilometers(origNumber);
        }
        else{
            TextView resultTextView = (TextView) findViewById(R.id.lengthTextView2);
            resultTextView.setText("Error");
            //error message
        }




    }
}


package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ConversionSpeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_speed);

        //dropdown menu for speed from
        final Spinner speedSpinnerFrom = (Spinner) findViewById(R.id.speedSpinner1);
        ArrayAdapter<String> speedAdapter1 = new ArrayAdapter<String>(ConversionSpeedActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.SpeedOptions));

        speedAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedSpinnerFrom.setAdapter(speedAdapter1);

        //dropdown menu for speed to
        final Spinner speedSpinnerTo = (Spinner) findViewById(R.id.speedSpinner2);
        ArrayAdapter<String> speedAdapter2 = new ArrayAdapter<String>(ConversionSpeedActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.SpeedOptions));

        speedAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedSpinnerTo.setAdapter(speedAdapter2);

        Button speedEnterBtn = (Button) findViewById(R.id.speedEnterButton);
        speedEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText speedInputET = (EditText) findViewById(R.id.speedInputEditText);
                double speedInput = Double.parseDouble(speedInputET.getText().toString());


                int from = speedSpinnerFrom.getSelectedItemPosition();
                int to = speedSpinnerTo.getSelectedItemPosition();
                convert(from, to, speedInput);
            }
        });

    }


    private void sameUnit(double num, int x)  {
        String unit = "";
        if(x == 0){
            unit = "m/h";
        }
        else if(x == 1){
            unit = "ft/s";
        }
        else if(x == 2){
            unit = "km/hr";
        }
        else{
            unit = "me/s";
        }
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(num + " " + unit);
    }
    private void fpsTOmph(double num)  {
        double answer = num / 1.46667;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " m/h");
    }
    private void kphTOmph(double num)  {
        double answer = num / 1.60934;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " m/h");
    }
    private void mpsTOmph(double num)  {
        double answer = num * 2.23694;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " m/h");
    }
    private void mphTOfps(double num)  {
        double answer = num * 1.46667;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " ft/s");
    }
    private void kphTOfps(double num)  {
        double answer = num / 1.09728;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " ft/s");
    }
    private void mpsTofps(double num)  {
        double answer = num * 3.28084;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " ft/s");
    }
    private void mphTOkph(double num)  {
        double answer = num * 1.06934;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " km/hr");
    }
    private void fpsTOkph(double num)  {
        double answer = num * 1.09728;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " km/hr");
    }
    private void mpsTPkph(double num)  {
        double answer = num * 3.6;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " km/hr");
    }
    private void mphTOmps(double num)  {
        double answer = num / 2.23694;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " me/s");
    }
    private void fpsTOmps(double num)  {
        double answer = num / 3.28084;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " me/s");
    }
    private void kphTOmps(double num)  {
        double answer = num / 3.6;
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        resultTextView.setText(answer + " me/s");
    }


    public void convert(int from, int to, double origNumber){

        if (from == to){
            sameUnit(origNumber, from);
        }
        else if (from == 1 && to == 0){
            fpsTOmph(origNumber);
        }
        else if (from == 2 && to == 0){
            kphTOmph(origNumber);
        }
        else if (from == 3 && to == 0){
            mpsTOmph(origNumber);
        }
        else if (from == 0 && to == 1){
            mphTOfps(origNumber);
        }
        else if (from == 2 && to == 1){
            kphTOfps (origNumber);
        }
        else if (from == 3 && to == 1){
            mpsTofps(origNumber);
        }
        else if (from == 0 && to == 2){
            mphTOkph(origNumber);
        }
        else if (from == 1 && to == 2){
            fpsTOkph(origNumber);
        }
        else if (from == 3 && to == 2){
            mpsTPkph(origNumber);
        }
        else if (from == 0 && to == 3){
            mphTOmps(origNumber);
        }
        else if (from == 1 && to == 3){
            fpsTOmps(origNumber);
        }
        else if (from == 2 && to == 3){
            kphTOmps(origNumber);
        }

        else{
            //error message
            TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
            resultTextView.setText("Error");

        }
    }
}

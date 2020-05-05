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

    public void convert(int from, int to, double origNumber){
        TextView resultTextView = (TextView) findViewById(R.id.speedTextView2);
        String unit = "";
        double answer = 0.0;
        if(to == 0){
            unit = " m/h";
        }
        else if(to == 1){
            unit = " ft/s";
        }
        else if(to == 2){
            unit = " km/hr";
        }
        else{
            unit = " me/s";
        }

        if (from == to){
            answer = origNumber;
        }
        else if (from == 1 && to == 0){
            //fps to mph
            answer = origNumber / 1.46667;
        }
        else if (from == 2 && to == 0){
            //kph to mph
            answer = origNumber / 1.60934;
        }
        else if (from == 3 && to == 0){
            //mps to mph
            answer = origNumber * 2.23694;
        }
        else if (from == 0 && to == 1){
            //mph to fps
            answer = origNumber * 1.46667;
        }
        else if (from == 2 && to == 1){
            //kph to fps
            answer = origNumber / 1.09728;
        }
        else if (from == 3 && to == 1){
            //mps to fps
            answer = origNumber * 3.28084;
        }
        else if (from == 0 && to == 2){
            //mph to kph
            answer = origNumber * 1.06934;
        }
        else if (from == 1 && to == 2){
            //fps to kph
            answer = origNumber * 1.09728;
        }
        else if (from == 3 && to == 2){
           // mps to kph
            answer = origNumber * 3.6;
        }
        else if (from == 0 && to == 3){
            //mph to mps
            answer = origNumber / 2.23694;
        }
        else if (from == 1 && to == 3){
            //fps to mps
            answer = origNumber / 3.28084;
        }
        else if (from == 2 && to == 3){
            //kph to mps
            answer = origNumber / 3.6;
        }

        else{
            //error message
            unit = "error";
        }
        resultTextView.setText(answer + unit);
    }
}

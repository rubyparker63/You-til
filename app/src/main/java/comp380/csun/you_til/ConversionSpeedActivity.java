package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ConversionSpeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_speed);

        //dropdown menu for temperature from
        Spinner speedSpinnerFrom = (Spinner) findViewById(R.id.speedSpinner1);
        ArrayAdapter<String> speedAdapter1 = new ArrayAdapter<String>(ConversionSpeedActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.SpeedOptions));

        speedAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedSpinnerFrom.setAdapter(speedAdapter1);

        //dropdown menu for temperature to
        Spinner speedSpinnerTo = (Spinner) findViewById(R.id.speedSpinner2);
        ArrayAdapter<String> speedAdapter2 = new ArrayAdapter<String>(ConversionSpeedActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.SpeedOptions));

        speedAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        speedSpinnerTo.setAdapter(speedAdapter2);

    }
}

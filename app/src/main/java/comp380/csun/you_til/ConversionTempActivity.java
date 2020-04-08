package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ConversionTempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_temp);

        //dropdown menu for temperature from
        Spinner tempSpinnerFrom = (Spinner) findViewById(R.id.tempSpinner1);
        ArrayAdapter<String> tempAdapter1 = new ArrayAdapter<String>(ConversionTempActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.TemeratureOptions));

        tempAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempSpinnerFrom.setAdapter(tempAdapter1);

        //dropdown menu for temperature to
        Spinner tempSpinnerTo = (Spinner) findViewById(R.id.tempSpinner2);
        ArrayAdapter<String> tempAdapter2 = new ArrayAdapter<String>(ConversionTempActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.TemeratureOptions));

        tempAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempSpinnerTo.setAdapter(tempAdapter2);

    }
}

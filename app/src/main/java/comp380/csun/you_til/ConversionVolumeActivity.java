package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ConversionVolumeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_volume);

        //dropdown menu for volume from
        Spinner volumeSpinnerFrom = (Spinner) findViewById(R.id.volumeSpinner1);
        ArrayAdapter<String> volumeAdapter1 = new ArrayAdapter<String>(ConversionVolumeActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.VolumeOptions));
        volumeAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        volumeSpinnerFrom.setAdapter(volumeAdapter1);

        //dropdown menu for volume to
        Spinner volumeSpinnerTo = (Spinner) findViewById(R.id.volumeSpinner2);
        ArrayAdapter<String> volumeAdapter2 = new ArrayAdapter<String>(ConversionVolumeActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.VolumeOptions));
        volumeAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        volumeSpinnerTo.setAdapter(volumeAdapter2);

    }
}

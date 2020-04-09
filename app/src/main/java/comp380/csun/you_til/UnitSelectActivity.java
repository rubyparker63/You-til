package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import comp380.csun.you_til.R;

public class UnitSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_select);

        Button tempBtn = (Button) findViewById(R.id.tempChooseButton);
        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTemp = new Intent(getApplicationContext(), ConversionTempActivity.class);
                startActivity(goToTemp);
            }
        });

        Button speedBtn = (Button) findViewById(R.id.speedChooseButton);
        speedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToSpeed = new Intent(getApplicationContext(), ConversionSpeedActivity.class);
                startActivity(goToSpeed);
            }
        });

        Button lengthBtn = (Button) findViewById(R.id.lengthChooseButton);
        lengthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLength = new Intent(getApplicationContext(), ConversionLengthActivity.class);
                startActivity(goToLength);
            }
        });

        Button volumeBtn = (Button) findViewById(R.id.volumeChooseButton);
        volumeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToVolume = new Intent(getApplicationContext(), ConversionVolumeActivity.class);
                startActivity(goToVolume);
            }
        });

    }
}

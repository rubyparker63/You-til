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
    }
}

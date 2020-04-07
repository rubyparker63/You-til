package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcActivityBtn = (Button) findViewById(R.id.calcMainButton);
        calcActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToCalc = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivity(goToCalc);
            }
        });

        //main menu
        Button coinFlipActivityBtn = (Button) findViewById(R.id.coinMainButton);
        coinFlipActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToCoin = new Intent(getApplicationContext(), CoinFLipActivity.class);
                startActivity(goToCoin);
            }
        });

        Button conversionActivityBtn = (Button) findViewById(R.id.conversionMainButton);
        conversionActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToConversion = new Intent(getApplicationContext(), ConversionActivity.class);
                startActivity(goToConversion);
            }
        });

        Button diceRollActivityBtn = (Button) findViewById(R.id.diceMainButton);
        diceRollActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDiceSelect = new Intent(getApplicationContext(), DiceRollSelectActivity.class);
                startActivity(goToDiceSelect);
            }
        });

        Button tipCalcActivityBtn = (Button) findViewById(R.id.tipCalcMainButton);
        tipCalcActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTipCalc = new Intent(getApplicationContext(), TipCalculatorActivity.class);
                startActivity(goToTipCalc);
            }
        });






    }
}

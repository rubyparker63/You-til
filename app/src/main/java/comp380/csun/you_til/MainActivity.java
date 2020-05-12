package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import android.widget.Switch;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String CALSWITCH = "calswitch";
    public static final String TISWITCH = "tiswitch";
    public static final String CONVSWITCH = "convswitch";
    public static final String DSWITCH = "dswitch";
    public static final String CSWITCH = "cswitch";

    SharedPreferences sharedPreferences;
    boolean calcState;
    boolean tipState;
    boolean conState;
    boolean diceState;
    boolean coinState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        calcState = sharedPreferences.getBoolean(CALSWITCH, false);
        tipState = sharedPreferences.getBoolean(TISWITCH, false);
        conState = sharedPreferences.getBoolean(CONVSWITCH, false);
        diceState = sharedPreferences.getBoolean(DSWITCH, false);
        coinState = sharedPreferences.getBoolean(CSWITCH, false);


        invalidateOptionsMenu();
        //Button decelerations and assignments for the main page
        Button calcActivityBtn = (Button) findViewById(R.id.calcMainButton);
        Button coinFlipActivityBtn = (Button) findViewById(R.id.coinMainButton);
        Button conversionActivityBtn = (Button) findViewById(R.id.conversionMainButton);
        Button diceRollActivityBtn = (Button) findViewById(R.id.diceMainButton);
        Button tipCalcActivityBtn = (Button) findViewById(R.id.tipCalcMainButton);
        //on click listeners to tell the app what to do when you push a button
        calcActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToCalc = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivity(goToCalc);
            }
        });
        coinFlipActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent goToCoin = new Intent(getApplicationContext(), CoinFLipActivity.class);
                startActivity(goToCoin);
            }
        });
        conversionActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToConversion = new Intent(getApplicationContext(), UnitSelectActivity.class);
                startActivity(goToConversion);
            }
        });
        diceRollActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDiceSelect = new Intent(getApplicationContext(), DiceRollSelectActivity.class);
                startActivity(goToDiceSelect);
            }
        });
        tipCalcActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToTipCalc = new Intent(getApplicationContext(), TipCalculatorActivity.class);
                startActivity(goToTipCalc);
            }
        });

        if(calcState) {
            calcActivityBtn.setVisibility(View.INVISIBLE);
        }
        if(tipState) {
            tipCalcActivityBtn.setVisibility(View.GONE);
        }
        if(conState) {
            conversionActivityBtn.setVisibility(View.GONE);
        }
        if(diceState) {
            diceRollActivityBtn.setVisibility(View.GONE);
        }
        if(coinState) {
            coinFlipActivityBtn.setVisibility(View.GONE);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quick_acess, menu);

        MenuItem dropCalc = menu.findItem(R.id.calculatorItem);
        MenuItem dropTip = menu.findItem(R.id.tipCalculatorItem);
        MenuItem dropConv = menu.findItem(R.id.conversionsItem);
        MenuItem dropDice = menu.findItem(R.id.dieRollItem);
        MenuItem dropCoin = menu.findItem(R.id.coinFlipItem);

        if(calcState) {
            dropCalc.setVisible(false);
        }
        if(tipState) {
            dropTip.setVisible(false);
        }
        if(conState) {
            dropConv.setVisible(false);
        }
        if(diceState) {
            dropDice.setVisible(false);
        }
        if(coinState) {
            dropCoin.setVisible(false);
        }

        return true;
    }
    //Navigation of drop down menu for ease of movement through the app
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.calculatorItem:
                Intent goToCalculatorItem = new Intent(getApplicationContext(), CalculatorActivity.class);
                startActivity(goToCalculatorItem);
                return true;
            case R.id.tipCalculatorItem:
                Intent goToTipCalculatorItem = new Intent(getApplicationContext(), TipCalculatorActivity.class);
                startActivity(goToTipCalculatorItem);
                return true;
            case R.id.conversionsItem:
                Intent goToConversionsItem = new Intent(getApplicationContext(), UnitSelectActivity.class);
                startActivity(goToConversionsItem);
                return true;
            case R.id.dieRollItem:
                Intent goToDieRollItem = new Intent(getApplicationContext(), DiceRollSelectActivity.class);
                startActivity(goToDieRollItem);
                return true;
            case R.id.coinFlipItem:
                Intent goToCoinFlipItem = new Intent(getApplicationContext(), CoinFLipActivity.class);
                startActivity(goToCoinFlipItem);
                return true;
            case R.id.settingsItem:
                Intent goToSettingsItem = new Intent(getApplicationContext(), SettingsActivityFix.class);
                startActivity(goToSettingsItem);
                return true;
            case R.id.homeItem:
                Intent goToHomeItem = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToHomeItem);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}


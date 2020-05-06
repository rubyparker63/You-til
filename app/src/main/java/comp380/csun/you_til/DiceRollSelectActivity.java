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
import android.widget.ImageButton;
import android.widget.ImageView;

import comp380.csun.you_til.R;

public class DiceRollSelectActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_dice_roll_select);

        invalidateOptionsMenu();
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        calcState = sharedPreferences.getBoolean(CALSWITCH, false);
        tipState = sharedPreferences.getBoolean(TISWITCH, false);
        conState = sharedPreferences.getBoolean(CONVSWITCH, false);
        diceState = sharedPreferences.getBoolean(DSWITCH, false);
        coinState = sharedPreferences.getBoolean(CSWITCH, false);

        //dice menu
        Button diceSelect4Btn = (Button) findViewById(R.id.die4button);
        diceSelect4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieFour = new Intent(getApplicationContext(), DiceRollActivity4Fix.class);
                startActivity(goToDieFour);
            }
        });
        Button diceSelect6Btn = (Button) findViewById(R.id.die6Button);
        diceSelect6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieSix = new Intent(getApplicationContext(), DiceRollActivity6fix.class);
                startActivity(goToDieSix);
            }
        });
        Button diceSelect8Btn = (Button) findViewById(R.id.die8Button);
        diceSelect8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieEight = new Intent(getApplicationContext(), DiceRollActivity8Fix.class);
                startActivity(goToDieEight);
            }
        });
        Button diceSelect10Btn = (Button) findViewById(R.id.die10Button);
        diceSelect10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieTen = new Intent(getApplicationContext(), DiceRollActivity10Fix.class);
                startActivity(goToDieTen);
            }
        });
        Button diceSelect12Btn = (Button) findViewById(R.id.die12Button);
        diceSelect12Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieTwelve = new Intent(getApplicationContext(), DiceRollActivity12Fix.class);
                startActivity(goToDieTwelve);
            }
        });
        Button diceSelect20Btn = (Button) findViewById(R.id.die20Button);
        diceSelect20Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieTwenty = new Intent(getApplicationContext(), DiceRollActivity20.class);
                startActivity(goToDieTwenty);
            }
        });


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
        }
        return super.onOptionsItemSelected(item);
    }


}

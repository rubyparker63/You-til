package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivityFix extends AppCompatActivity {

    private Switch calcSwitch;
    private Switch tipSwitch;
    private Switch conSwitch;
    private Switch diceSwitch;
    private Switch coinSwitch;
    private Button setCancelButton;
    private Button setSaveButton;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String CALSWITCH = "calswitch";
    public static final String TISWITCH = "tiswitch";
    public static final String CONVSWITCH = "convswitch";
    public static final String DSWITCH = "dswitch";
    public static final String CSWITCH = "cswitch";

    private boolean calcState;
    private boolean tipState;
    private boolean conState;
    private boolean diceState;
    private boolean coinState;

    private Button mainCalc;
    private Button mainTip;
    private Button mainConv;
    private Button mainDice;
    private Button mainCoin;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_fix);

        calcSwitch = (Switch) findViewById(R.id.hideCalculatorSwitch);
        tipSwitch = (Switch) findViewById(R.id.hideTipCalcSwitch);
        conSwitch = (Switch) findViewById(R.id.hideConversSwitch);
        diceSwitch = (Switch) findViewById(R.id.hideDiceSwitch);
        coinSwitch = (Switch) findViewById(R.id.hideCoinSwitch);
        setCancelButton = (Button) findViewById(R.id.settingsCancelButton);
        setSaveButton = (Button) findViewById(R.id.settingsSaveButton);

        mainCalc = (Button) findViewById(R.id.calcMainButton);
        mainTip = (Button) findViewById(R.id.tipCalcMainButton);
        mainConv = (Button) findViewById(R.id.conversionMainButton);
        mainDice = (Button) findViewById(R.id.diceMainButton);
        mainCoin = (Button) findViewById(R.id.coinMainButton);

        setSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                saveData();
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putBoolean(CALSWITCH, calcSwitch.isChecked());
                editor.putBoolean(TISWITCH, tipSwitch.isChecked());
                editor.putBoolean(CONVSWITCH, conSwitch.isChecked());
                editor.putBoolean(DSWITCH, diceSwitch.isChecked());
                editor.putBoolean(CSWITCH, coinSwitch.isChecked());

                editor.apply();
                Toast.makeText(getApplicationContext(), "Settings Saved!", Toast.LENGTH_SHORT).show();
                Intent goToMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToMain);
            }
        });

        setCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                saveData();
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(calcSwitch.isChecked() != calcState) {
                    calcSwitch.setChecked(calcState);
                }
                if(tipSwitch.isChecked() != tipState) {
                    tipSwitch.setChecked(tipState);
                }
                if(conSwitch.isChecked() != conState) {
                    conSwitch.setChecked(conState);
                }
                if(diceSwitch.isChecked() != diceState) {
                    diceSwitch.setChecked(diceState);
                }
                if(coinSwitch.isChecked() != coinState) {
                    coinSwitch.setChecked(coinState);
                }

                editor.putBoolean(CALSWITCH, calcSwitch.isChecked());
                editor.putBoolean(TISWITCH, tipSwitch.isChecked());
                editor.putBoolean(CONVSWITCH, conSwitch.isChecked());
                editor.putBoolean(DSWITCH, diceSwitch.isChecked());
                editor.putBoolean(CSWITCH, coinSwitch.isChecked());

                editor.apply();
//                Toast.makeText(this, "Settings Saved!", Toast.LENGTH_SHORT).show();
                Intent goToMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToMain);
            }
        });

        loadData();
        updateData();

    }

//    public void saveData() {
//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        editor.putBoolean(CALSWITCH, calcSwitch.isChecked());
//        editor.putBoolean(TISWITCH, tipSwitch.isChecked());
//        editor.putBoolean(CONVSWITCH, conSwitch.isChecked());
//        editor.putBoolean(DSWITCH, diceSwitch.isChecked());
//        editor.putBoolean(CSWITCH, coinSwitch.isChecked());
//
//        editor.apply();
//        Toast.makeText(this, "Settings Saved!", Toast.LENGTH_SHORT).show();
//        Intent goToMain = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(goToMain);
//
//    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        calcState = sharedPreferences.getBoolean(CALSWITCH, false);
        tipState = sharedPreferences.getBoolean(TISWITCH, false);
        conState = sharedPreferences.getBoolean(CONVSWITCH, false);
        diceState = sharedPreferences.getBoolean(DSWITCH, false);
        coinState = sharedPreferences.getBoolean(CSWITCH, false);
    }

    public void updateData() {
        calcSwitch.setChecked(calcState);
        tipSwitch.setChecked(tipState);
        conSwitch.setChecked(conState);
        diceSwitch.setChecked(diceState);
        coinSwitch.setChecked(coinState);
    }
}

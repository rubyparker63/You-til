package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;

public class ConversionSpeedActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_conversion_speed);

        invalidateOptionsMenu();
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        calcState = sharedPreferences.getBoolean(CALSWITCH, false);
        tipState = sharedPreferences.getBoolean(TISWITCH, false);
        conState = sharedPreferences.getBoolean(CONVSWITCH, false);
        diceState = sharedPreferences.getBoolean(DSWITCH, false);
        coinState = sharedPreferences.getBoolean(CSWITCH, false);

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
        BigDecimal round = new BigDecimal(answer);
        round = round.setScale(3, BigDecimal.ROUND_HALF_UP);
        double roundedAnswer = round.doubleValue();
        resultTextView.setText(roundedAnswer + unit);
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

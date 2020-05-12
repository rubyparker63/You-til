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

public class ConversionTempActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_conversion_temp);

        invalidateOptionsMenu();
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        calcState = sharedPreferences.getBoolean(CALSWITCH, false);
        tipState = sharedPreferences.getBoolean(TISWITCH, false);
        conState = sharedPreferences.getBoolean(CONVSWITCH, false);
        diceState = sharedPreferences.getBoolean(DSWITCH, false);
        coinState = sharedPreferences.getBoolean(CSWITCH, false);

        //dropdown menu for temperature from
        final Spinner tempSpinnerFrom = (Spinner) findViewById(R.id.tempSpinner1);
        ArrayAdapter<String> tempAdapter1 = new ArrayAdapter<String>(ConversionTempActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.TemeratureOptions));

        tempAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempSpinnerFrom.setAdapter(tempAdapter1);

        //dropdown menu for temperature to
        final Spinner tempSpinnerTo = (Spinner) findViewById(R.id.tempSpinner2);
        ArrayAdapter<String> tempAdapter2 = new ArrayAdapter<String>(ConversionTempActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.TemeratureOptions));

        tempAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tempSpinnerTo.setAdapter(tempAdapter2);
        Button tempEnterBtn = (Button) findViewById(R.id.tempEnterButton);
        tempEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tempInputET = (EditText) findViewById(R.id.tempInputEditText);
                double tempInput = Double.parseDouble(tempInputET.getText().toString());
                int from = tempSpinnerFrom.getSelectedItemPosition();
                int to = tempSpinnerTo.getSelectedItemPosition();

                convertTemp(from, to, tempInput);
            }
        });
    }

    public void convertTemp(int from, int to, double origNumber){

        TextView resultTextView = (TextView) findViewById(R.id.convToTempTextView);
        double answer = 0;
        String unit = "";
        if(to == 0){
            unit = " K";
        }
        else if(to == 1){
            unit = " °C";
        }
        else{
            unit = " °F";
        }

        if (from == to){
            answer = origNumber;
        }
        else if (from == 1 && to == 0){
            //celsius to Kelvin
            answer= origNumber + 273.15;
        }
        else if (from == 2 && to == 0){
            //fahrenheit to Kelvin
            answer= (origNumber - 32.0) * (5.0/9.0) + 285.928;
        }
        else if (from == 0 && to == 1){
            //kelvin to Celsius
            answer= origNumber - 273.15;
        }
        else if (from == 2 && to == 1){
            //fahrenheit to Celsius
            answer= (origNumber - 32.0) * (5.0/9.0);
        }
        else if (from == 0 && to == 2){
            //kelvin to Fahrenheit
            answer= (origNumber - 273.15) * (9.0/5.0) + 32;
        }
        else if (from == 1 && to == 2){
            //celsius to Fahrenheit
            answer= (origNumber * 9.0) /5.0 + 32;
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
            case R.id.homeItem:
                Intent goToHomeItem = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(goToHomeItem);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

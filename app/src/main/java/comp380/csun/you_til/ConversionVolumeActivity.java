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

public class ConversionVolumeActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_conversion_volume);

        invalidateOptionsMenu();
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        calcState = sharedPreferences.getBoolean(CALSWITCH, false);
        tipState = sharedPreferences.getBoolean(TISWITCH, false);
        conState = sharedPreferences.getBoolean(CONVSWITCH, false);
        diceState = sharedPreferences.getBoolean(DSWITCH, false);
        coinState = sharedPreferences.getBoolean(CSWITCH, false);

        //dropdown menu for volume from
        final Spinner volumeSpinnerFrom = (Spinner) findViewById(R.id.volumeSpinner1);
        ArrayAdapter<String> volumeAdapter1 = new ArrayAdapter<String>(ConversionVolumeActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.VolumeOptions));
        volumeAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        volumeSpinnerFrom.setAdapter(volumeAdapter1);

        //dropdown menu for volume to
        final Spinner volumeSpinnerTo = (Spinner) findViewById(R.id.volumeSpinner2);
        ArrayAdapter<String> volumeAdapter2 = new ArrayAdapter<String>(ConversionVolumeActivity.this,
                android.R.layout.simple_list_item_activated_1, getResources().getStringArray(R.array.VolumeOptions));
        volumeAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        volumeSpinnerTo.setAdapter(volumeAdapter2);

        Button volumeEnterBtn = (Button) findViewById(R.id.volumeEnterButton);
        volumeEnterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText volumeInputET = (EditText) findViewById(R.id.volumeInputEditText);
                double volumeInput = Double.parseDouble(volumeInputET.getText().toString());
                int from = volumeSpinnerFrom.getSelectedItemPosition();
                int to = volumeSpinnerTo.getSelectedItemPosition();
                convert(from, to, volumeInput);
            }
        });
    }
    public void convert(int from, int to, double origNumber){
        TextView resultTextView = (TextView) findViewById(R.id.volumeTextView2);
        String unit = "";
        double answer = 0.0;
        if(to == 0){
            unit = " qt";
        }
        else if(to == 1){
            unit = " oz";
        }
        else if(to == 2){
            unit = " cups";
        }
        else if(to == 3){
            unit = " gals";
        }
        else if(to == 4){
            unit = " l";
        }
        else if(to == 5){
            unit = " ml";
        }
        else if(to == 6){
            unit = " tbsp";
        }
        else{
            unit = " tsp";
        }

        //to Quarts
        if (from == to){
            answer = origNumber;
        }
        else if (from == 1 && to == 0){
            //Ounces to Quarts
            answer = origNumber / 32.0;
        }
        else if (from == 2 && to == 0){
            //Cups to Quarts
            answer = origNumber/ 3.94314;
        }
        else if (from == 3 && to == 0){
            //Gallons to Quarts
            answer = origNumber * 4.0;
        }
        else if (from == 4 && to == 0){
            //Liters to Quarts
            answer = origNumber * 1.05669;
        }
        else if (from == 5 && to == 0){
            //Milliliters to Quarts
            answer = origNumber/ 946.353;
        }
        else if (from == 6 && to == 0){
            //Tablespoon to Quarts
            answer = origNumber / 64.0;
        }
        else if (from == 7 && to == 0){
            //Teaspoon to Quarts
            answer = origNumber / 192.0;
        }


        //to Ounces
        else if (from == 0 && to == 1){
            //Quarts to Ounces
            answer = origNumber * 32.0;
        }
        else if (from == 2 && to == 1){
            // Cups to Ounces
            answer = origNumber * 8.11537;
        }
        else if (from == 3 && to == 1){
            // Gallons to Ounces
            answer = origNumber * 128.0;
        }
        else if (from == 4 && to == 1){
            //Liters to Ounces
            answer = origNumber * 33.814;
        }
        else if (from == 5 && to == 1){
            //Milliliters to Ounces
            answer = origNumber / 29.5735;
        }
        else if (from == 6 && to == 1){
            //Tablespoon to Ounces
            answer = origNumber / 2.0;
        }
        else if (from == 7 && to == 1){
            //Teaspoon to Ounces
            answer = origNumber / 6.0;
        }

        //to Cups
        else if (from == 0 && to == 2){
            // Quarts to Cups
            answer = origNumber * 3.94314;
        }
        else if (from == 1 && to == 2){
            // Ounces to Cups
            answer = origNumber/ 8.11537;
        }
        else if (from == 3 && to == 2){
            // Gallons to Cups
            answer = origNumber * 15.7725;
        }
        else if (from == 4 && to == 2){
            //Liters to Cups
            answer = origNumber * 4.16667;
        }
        else if (from == 5 && to == 2){
            //Milliliters to Cups
            answer = origNumber / 240.0;
        }
        else if (from == 6 && to == 2){
            //Tablespoon to Cups
            answer = origNumber / 16.2307;
        }
        else if (from == 7 && to == 2){
            //Teaspoon to Cups
            answer = origNumber / 48.6922;
        }

        //to Gallons
        else if (from == 0 && to == 3){
            //Quarts to Gallons
            answer = origNumber / 4.0;
        }
        else if (from == 1 && to == 3){
            // Ounces to Gallons
            answer = origNumber / 128.0;
        }
        else if (from == 2 && to == 3){
            // Cups to Gallons
            answer = origNumber / 15.7725;
        }
        else if (from == 4 && to == 3){
            //Liters to Gallons
            answer = origNumber/ 37.8541;
        }
        else if (from == 5 && to == 3){
            //Milliliters to Gallons
            answer = origNumber / 3785.0;
        }
        else if (from == 6 && to == 3){
            //Tablespoon to Gallons
            answer = origNumber / 256.0;
        }
        else if (from == 7 && to == 3){
            //Teaspoon to Gallons
            answer = origNumber / 768;
        }
        //to Liters
        else if (from == 0 && to == 4){
            // Quarts to Liters
            answer = origNumber / 1.05669;
        }
        else if (from == 1 && to == 4){
            // Ounces to Liters
            answer = origNumber / 33.814;
        }
        else if (from == 2 && to == 4){
            //Cups to Liters
            answer = origNumber / 4.16667;
        }
        else if (from == 3 && to == 4){
            //Gallons to Liters
            answer = origNumber * 3.78541;
        }
        else if (from == 5 && to == 4){
            //Milliliters to Liters
            answer = origNumber / 1000.0;
        }
        else if (from == 6 && to == 4){
            //Tablespoon to Liters
            answer = origNumber / 67.628;
        }
        else if (from == 7 && to == 4){
            //Teaspoon to Liters
            answer = origNumber / 203.0;
        }
        //to Milliliters
        else if (from == 0 && to == 5){
            // Quarts to Milliliters
            answer = origNumber * 946.0;
        }
        else if (from == 1 && to == 5){
            //Ounces to Milliliters
            answer = origNumber * 29.5735;
        }
        else if (from == 2 && to == 5){
            //Cups to Milliliters
            answer = origNumber * 240.0;
        }
        else if (from == 3 && to == 5){
            //Gallons to Milliliters
            answer = origNumber * 3785.41;
        }
        else if (from == 4 && to == 5){
            //Liters to Milliliters
            answer = origNumber * 1000.0;
        }
        else if (from == 6 && to == 5){
            //Tablespoon to Milliliters
            answer = origNumber * 14.7868;
        }
        else if (from == 7 && to == 5){
            //Teaspoon to Milliliters
            answer = origNumber * 4.92892;
        }
        //to Tablespoon
        else if (from == 0 && to == 6){
            // Quarts to Tablespoon
            answer = origNumber * 64.0;
        }
        else if (from == 1 && to == 6){
            //Ounces to Tablespoon
            answer = origNumber * 2.0;
        }
        else if (from == 2 && to == 6){
            //Cups to Tablespoon
            answer = origNumber * 16.2307;
        }
        else if (from == 3 && to == 6){
            //Gallons to Tablespoon
            answer = origNumber * 256;
        }
        else if (from == 4 && to == 6){
            //Liters to Tablespoon
            answer = origNumber * 67.628;
        }
        else if (from == 5 && to == 6){
            //Milliliters to Tablespoon
            answer = origNumber / 14.7868;
        }
        else if (from == 7 && to == 6){
            //Teaspoon to Tablespoon
            answer = origNumber / 3.0;
        }
        //to Teaspoon
        else if (from == 0 && to == 7){
            // Quarts to Teaspoon
            answer = origNumber * 192.0;
        }
        else if (from == 1 && to == 7){
            //Ounces to Teaspoon
            answer = origNumber * 6.0;
        }
        else if (from == 2 && to == 7){
            //Cups to Teaspoon
            answer = origNumber * 48.6922;
        }
        else if (from == 3 && to == 7){
            //Gallons to Teaspoon
            answer = origNumber * 768.0;
        }
        else if (from == 4 && to == 7){
            //Liters to Teaspoon
            answer = origNumber * 202.884;
        }
        else if (from == 5 && to == 7){
            //Milliliters to Teaspoon
            answer = origNumber / 4.92892;
        }
        else if (from == 6 && to == 7){
            //Tablespoon to Teaspoon
            answer = origNumber * 3.0;
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

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
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

import java.math.BigDecimal;

public class TipCalculatorActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_tip_calculator);

        invalidateOptionsMenu();
        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        calcState = sharedPreferences.getBoolean(CALSWITCH, false);
        tipState = sharedPreferences.getBoolean(TISWITCH, false);
        conState = sharedPreferences.getBoolean(CONVSWITCH, false);
        diceState = sharedPreferences.getBoolean(DSWITCH, false);
        coinState = sharedPreferences.getBoolean(CSWITCH, false);

        Button tip10Btn = (Button) findViewById(R.id.tip10Button);
        tip10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double ten = 0.10;
                calculateTip(ten);

            }
        });

        Button tip15Btn = (Button) findViewById(R.id.tip15Button);
        tip15Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double fifteen = 0.15;
                calculateTip(fifteen);
            }
        });
        Button tip18Btn = (Button) findViewById(R.id.tip18Button);
        tip18Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double eighteen = 0.18;
                calculateTip(eighteen);
            }
        });
        Button tip20Btn = (Button) findViewById(R.id.tip20Button);
        tip20Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double twenty = 0.20;
                calculateTip(twenty);
            }
        });
        Button customBtn = (Button) findViewById(R.id.tipCustomButton);
        customBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToCustom = new Intent(getApplicationContext(), CustomTipActivity.class);
                startActivity(goToCustom);
            }
        });

    }

    public void calculateTip(double percent){
        DecimalFormat df2 = new DecimalFormat("#.##");
        TextView tipCalcTipTextView = (TextView) findViewById(R.id.tipCalcTipTextView);
        TextView tipCalcNewBillTextView = (TextView) findViewById(R.id.tipCalcNewBillTextView);
        TextView tipCalcSplitTextView = (TextView) findViewById(R.id.tipCalcSplitTextView);
        EditText tipCalcBillET = (EditText) findViewById(R.id.tipCalcBillEditText);
        double tipCalcBillInput = Double.parseDouble(tipCalcBillET.getText().toString());
        EditText tipCalcSplitET = (EditText) findViewById(R.id.tipCalcSplitEditText);
        double tipCalcSplitInput = Double.parseDouble(tipCalcSplitET.getText().toString());
        if(tipCalcBillInput != 0){
            if(tipCalcSplitInput == 1){
                double newBill = (tipCalcBillInput * percent) + tipCalcBillInput;
                double tipCalcTip = tipCalcBillInput * percent;
                tipCalcTipTextView.setText("Your Tip is: $" + tipCalcTip);
                tipCalcNewBillTextView.setText("Your Bill with Tip is: $" + newBill);
            }
            else{
                double newBill = (tipCalcBillInput * percent) + tipCalcBillInput;
                double tipCalcTip = tipCalcBillInput * percent;
                double tipCalcSplit = newBill / tipCalcSplitInput;
                tipCalcTipTextView.setText("Your Tip is: $" + df2.format(tipCalcTip));
                tipCalcNewBillTextView.setText("Your Bill with Tip is: $" + df2.format(newBill));
                tipCalcSplitTextView.setText("Each Person Pays: $" + df2.format(tipCalcSplit));
            }
        }
        else{
            tipCalcTipTextView.setText("Error Please Enter A Bill Amount");
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

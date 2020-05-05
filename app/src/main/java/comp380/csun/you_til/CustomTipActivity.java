package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CustomTipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tip);


        Button customCalBtn = (Button) findViewById(R.id.tipCustomButton);
        customCalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat df2 = new DecimalFormat("#.##");
                TextView tipCalcTipTextView = (TextView) findViewById(R.id.tipCustomTipTextView);
                TextView tipCalcNewBillTextView = (TextView) findViewById(R.id.tipCusNewBillTextView);
                TextView tipCalcSplitTextView = (TextView) findViewById(R.id.tipCustSplitTextView);

                EditText tipCustomBillET = (EditText) findViewById(R.id.tipCustomBillEditText);
                double tipCustomBillInput = Double.parseDouble(tipCustomBillET.getText().toString());

                EditText tipCustomSplitET = (EditText) findViewById(R.id.tipCustomSplitEditText);
                double tipCustomSplitInput = Double.parseDouble(tipCustomSplitET.getText().toString());

                EditText tipCustomET = (EditText) findViewById(R.id.tipCustomEditText);
                double percentCustom = Double.parseDouble(tipCustomET.getText().toString());
                percentCustom = percentCustom / 100.0;
                if(tipCustomBillInput != 0){
                    if(tipCustomSplitInput == 1){
                        double newBill = (tipCustomBillInput * percentCustom) + tipCustomBillInput;
                        double tipCalcTip = tipCustomBillInput * percentCustom;
                        tipCalcTipTextView.setText("Your Tip is: $" + tipCalcTip);
                        tipCalcNewBillTextView.setText("Your Bill with Tip is: $" + newBill);
                    }
                    else{
                        double newBill = (tipCustomBillInput * percentCustom) + tipCustomBillInput;
                        double tipCalcTip = tipCustomBillInput * percentCustom;
                        double tipCalcSplit = newBill / tipCustomSplitInput;
                        tipCalcTipTextView.setText("Your Tip is: $" + df2.format(tipCalcTip));
                        tipCalcNewBillTextView.setText("Your Bill with Tip is: $" + df2.format(newBill));
                        tipCalcSplitTextView.setText("Each Person Pays: $" + df2.format(tipCalcSplit));
                    }
                }
                else{
                    tipCalcTipTextView.setText("Error Please Enter A Bill Amount");
                }

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quick_acess, menu);
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

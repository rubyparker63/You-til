package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiceRollActivity20 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll20);

        final TextView die20Txt = (TextView)findViewById(R.id.die20TextView);
        Button roll20Button = (Button)findViewById(R.id.rollDie20Button);

        roll20Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die20Txt.setText("");
                int rand = (int)(Math.random()*20);

                if(rand == 0) {
                    die20Txt.setText("1");
                }
                else if(rand == 1) {
                    die20Txt.setText("2");
                }
                else if(rand == 2) {
                    die20Txt.setText("3");
                }
                else if(rand == 3) {
                    die20Txt.setText("4");
                }
                else if(rand == 4) {
                    die20Txt.setText("5");
                }
                else if(rand == 5) {
                    die20Txt.setText("6");
                }
                else if(rand == 6) {
                    die20Txt.setText("7");
                }
                else if(rand == 7) {
                    die20Txt.setText("8");
                }
                else if(rand == 8) {
                    die20Txt.setText("9");
                }
                else if(rand == 9) {
                    die20Txt.setText("10");
                }
                else if(rand == 10) {
                    die20Txt.setText("11");
                }
                else if(rand == 11) {
                    die20Txt.setText("12");
                }
                else if(rand == 12) {
                    die20Txt.setText("13");
                }
                else if(rand == 13) {
                    die20Txt.setText("14");
                }
                else if(rand == 14) {
                    die20Txt.setText("15");
                }
                else if(rand == 15) {
                    die20Txt.setText("16");
                }
                else if(rand == 16) {
                    die20Txt.setText("17");
                }
                else if(rand == 17) {
                    die20Txt.setText("18");
                }
                else if(rand == 18) {
                    die20Txt.setText("19");
                }
                else if(rand == 19) {
                    die20Txt.setText("20");
                }
                else {
                    die20Txt.setText("error");
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

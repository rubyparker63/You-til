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

public class DiceRollActivity4Fix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll_activity4_fix);

        final TextView die4Txt = (TextView)findViewById(R.id.die4TextView);
        Button roll4Button = (Button)findViewById(R.id.rollDie4Button);

        roll4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die4Txt.setText("");
                int rand = (int)(Math.random()*4);

                if(rand == 0) {
                    die4Txt.setText("1");
                }
                else if(rand == 1) {
                    die4Txt.setText("2");
                }
                else if(rand == 2) {
                    die4Txt.setText("3");
                }
                else if(rand == 3) {
                    die4Txt.setText("4");
                }
                else {
                    die4Txt.setText("Error");
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

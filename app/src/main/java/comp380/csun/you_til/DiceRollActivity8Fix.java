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

public class DiceRollActivity8Fix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll_activity8_fix);

        final TextView die8Txt = (TextView)findViewById(R.id.die8TextView);
        Button roll8Button = (Button)findViewById(R.id.rollDie8Button);

        roll8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die8Txt.setText("");
                int rand = (int)(Math.random()*8);

                if(rand == 0) {
                    die8Txt.setText("1");
                }
                else if(rand == 1) {
                    die8Txt.setText("2");
                }
                else if(rand == 2) {
                    die8Txt.setText("3");
                }
                else if(rand == 3) {
                    die8Txt.setText("4");
                }
                else if(rand == 4) {
                    die8Txt.setText("5");
                }
                else if(rand == 5) {
                    die8Txt.setText("6");
                }
                else if(rand == 6) {
                    die8Txt.setText("7");
                }
                else if(rand == 7) {
                    die8Txt.setText("8");
                }
                else {
                    die8Txt.setText("error");
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

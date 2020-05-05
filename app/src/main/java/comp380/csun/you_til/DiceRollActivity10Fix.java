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

public class DiceRollActivity10Fix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll_activity10_fix);

        final TextView die10Txt = (TextView)findViewById(R.id.die10TextView);
        Button roll10Button = (Button)findViewById(R.id.rollDie10Button);
        roll10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die10Txt.setText("");
                int rand = (int)(Math.random()*10);

                if(rand == 0) {
                    die10Txt.setText("1");
                }
                else if(rand == 1) {
                    die10Txt.setText("2");
                }
                else if(rand == 2) {
                    die10Txt.setText("3");
                }
                else if(rand == 3) {
                    die10Txt.setText("4");
                }
                else if(rand == 4) {
                    die10Txt.setText("5");
                }
                else if(rand == 5) {
                    die10Txt.setText("6");
                }
                else if(rand == 6) {
                    die10Txt.setText("7");
                }
                else if(rand == 7) {
                    die10Txt.setText("8");
                }
                else if(rand == 8) {
                    die10Txt.setText("9");
                }
                else if(rand == 9) {
                    die10Txt.setText("10");
                }
                else {
                    die10Txt.setText("error");
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
        }
        return super.onOptionsItemSelected(item);
    }
}

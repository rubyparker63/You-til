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

public class DiceRollActivity6fix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll_activity6fix);

        final TextView die6Txt = (TextView)findViewById(R.id.die6TextView);
        Button roll6Button = (Button)findViewById(R.id.RollDie6Button);

        roll6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die6Txt.setText("");
                int rand = (int)(Math.random()*6);

                if(rand == 0) {
                    die6Txt.setText("1");
                }
                else if(rand == 1) {
                    die6Txt.setText("2");
                }
                else if(rand == 2) {
                    die6Txt.setText("3");
                }
                else if(rand == 3) {
                    die6Txt.setText("4");
                }
                else if(rand == 4) {
                    die6Txt.setText("5");
                }
                else if(rand == 5) {
                    die6Txt.setText("6");
                }
                else {
                    die6Txt.setText("error");
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

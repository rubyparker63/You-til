package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiceRollActivity12Fix extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll_activity12_fix);

        final TextView die12Txt = (TextView)findViewById(R.id.die12TextView);
        Button roll12Button = (Button)findViewById(R.id.rollDie12button);

        roll12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                die12Txt.setText("");
                int rand = (int)(Math.random()*8);

                if(rand == 0) {
                    die12Txt.setText("1");
                }
                else if(rand == 1) {
                    die12Txt.setText("2");
                }
                else if(rand == 2) {
                    die12Txt.setText("3");
                }
                else if(rand == 3) {
                    die12Txt.setText("4");
                }
                else if(rand == 4) {
                    die12Txt.setText("5");
                }
                else if(rand == 5) {
                    die12Txt.setText("6");
                }
                else if(rand == 6) {
                    die12Txt.setText("7");
                }
                else if(rand == 7) {
                    die12Txt.setText("8");
                }
                else if(rand == 8) {
                    die12Txt.setText("9");
                }
                else if(rand == 9) {
                    die12Txt.setText("10");
                }
                else if(rand == 10) {
                    die12Txt.setText("11");
                }
                else if(rand == 11) {
                    die12Txt.setText("12");
                }
                else {
                    die12Txt.setText("error");
                }
            }
        });
    }
}

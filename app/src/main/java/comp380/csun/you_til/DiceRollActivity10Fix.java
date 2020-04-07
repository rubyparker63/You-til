package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
}

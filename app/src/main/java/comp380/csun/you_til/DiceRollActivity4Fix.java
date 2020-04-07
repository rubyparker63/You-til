package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
}

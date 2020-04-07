package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
}

package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
}

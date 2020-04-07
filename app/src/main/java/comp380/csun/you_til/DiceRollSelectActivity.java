package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import comp380.csun.you_til.R;

public class DiceRollSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll_select);


        //dice menu
        ImageButton dieSelect4Btn = (ImageButton) findViewById(R.id.dice4Button);
        dieSelect4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieFour = new Intent(getApplicationContext(), DiceRollActivity4Fix.class);
                startActivity(goToDieFour);
            }
        });

        ImageButton dieSelect6Btn = (ImageButton) findViewById(R.id.dice6Button);
        dieSelect6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieSix = new Intent(getApplicationContext(), DiceRollActivity6fix.class);
                startActivity(goToDieSix);
            }
        });
        ImageButton dieSelect8Btn = (ImageButton) findViewById(R.id.dice8Button);
        dieSelect8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieEight = new Intent(getApplicationContext(), DiceRollActivity8Fix.class);
                startActivity(goToDieEight);
            }
        });

    }


}

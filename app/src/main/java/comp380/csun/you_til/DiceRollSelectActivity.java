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
        Button diceSelect4Btn = (Button) findViewById(R.id.die4button);
        diceSelect4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieFour = new Intent(getApplicationContext(), DiceRollActivity4Fix.class);
                startActivity(goToDieFour);
            }
        });
        Button diceSelect6Btn = (Button) findViewById(R.id.die6Button);
        diceSelect6Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieSix = new Intent(getApplicationContext(), DiceRollActivity6fix.class);
                startActivity(goToDieSix);
            }
        });
        Button diceSelect8Btn = (Button) findViewById(R.id.die8Button);
        diceSelect8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieEight = new Intent(getApplicationContext(), DiceRollActivity8Fix.class);
                startActivity(goToDieEight);
            }
        });
        Button diceSelect10Btn = (Button) findViewById(R.id.die10Button);
        diceSelect10Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieTen = new Intent(getApplicationContext(), DiceRollActivity10Fix.class);
                startActivity(goToDieTen);
            }
        });
        Button diceSelect12Btn = (Button) findViewById(R.id.die12Button);
        diceSelect12Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieTwelve = new Intent(getApplicationContext(), DiceRollActivity12Fix.class);
                startActivity(goToDieTwelve);
            }
        });
        Button diceSelect20Btn = (Button) findViewById(R.id.die20Button);
        diceSelect20Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToDieTwenty = new Intent(getApplicationContext(), DiceRollActivity20.class);
                startActivity(goToDieTwenty);
            }
        });


    }


}

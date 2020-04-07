package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

import comp380.csun.you_til.R;

import java.util.Random;

public class CoinFLipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_f_lip);

        final TextView coinTxt = (TextView)findViewById(R.id.textView6);

        ImageView Coin = (ImageView)findViewById(R.id.imageView5);
        Coin.setImageResource(R.drawable.coin);

        Button flipButton = (Button)findViewById(R.id.coinFlipButton);
        flipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coinTxt.setText("");
                int rand = (int)(Math.random()*2);

                if(rand == 0) {
                    coinTxt.setText("Heads");
                }
                else {
                    coinTxt.setText("Tails");
                }
            }
        });
    }
}

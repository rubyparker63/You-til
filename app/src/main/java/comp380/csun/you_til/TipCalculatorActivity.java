package comp380.csun.you_til;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import comp380.csun.you_til.R;

public class TipCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);


        //Button btn = (Button) findViewById(R.id.btn);
        //btn.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
           //     TextView textView = (TextView) findViewById(R.id.tv3);
            //    EditText et1 = (EditText) findViewById(R.id.et1);
              //  EditText et2 = (EditText) findViewById(R.id.et2);
              //  double bill = Double.valueOf(et1.getText().toString());
               // double tipPercent = Double.valueOf(et2.getText().toString());
               // textView.setText("Tip amount is: $" + (bill * tipPercent / 100));
           // }
       // });

    }
}

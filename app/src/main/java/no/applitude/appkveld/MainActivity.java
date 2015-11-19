package no.applitude.appkveld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mSkrift;
    Button mReset;
    TextView mTall;
    int tall = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSkrift = (Button)findViewById(R.id.btnTell);
        mReset = (Button)findViewById(R.id.btnReset);
        mTall = (TextView)findViewById(R.id.txtTall);

        skjulKnapp();

        mSkrift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTall.setText(oekAntall());
            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTall.setText(resetTeller());
            }
        });
    }

    //oeker antall på telleren ved knappetrykk
    public String oekAntall(){
        tall++;
        String retTall = Integer.toString(tall);
        if(tall>0){
            mReset.setVisibility(View.VISIBLE);
        }
        return retTall;
    }

    //resetter telleren
    public String resetTeller(){
        tall=0;
        String retTall= Integer.toString(tall);
        skjulKnapp();
        return retTall;
    }

    public void skjulKnapp(){
        mReset.setVisibility(View.INVISIBLE);
    }
}

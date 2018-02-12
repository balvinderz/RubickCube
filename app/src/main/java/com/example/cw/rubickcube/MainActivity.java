package com.example.cw.rubickcube;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Handler;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int counter = 0;
    public String d = "";
    public int t = -1;
    int l=1;
    int tr;
    public String[] c = {"R", "R\'", "U", "U\'", "L", "L\'", "B", "B\'", "F", "F\'", "D", "D\'", "R2", "U2", "L2", "B2", "F2", "D2"};
String n;
String b;
String abc;
Button start,end;
TextView p,g,h,gd;
long startTime=0L,timeinmilliseconds=0L,timeswapbuff=0L,updatetime=0L;
Handler customhandler=new Handler();
    Runnable updateTimerThread=new Runnable() {
        @Override
        public void run() {

timeinmilliseconds=SystemClock.uptimeMillis()-startTime;
updatetime=timeswapbuff+timeinmilliseconds;
int secs=(int) updatetime/1000;
int mins=secs/60;
secs=secs%60;
if(mins<10)
n="0"+String.valueOf(mins);
else
n=String.valueOf(mins);

if(secs<10)
    b="0"+String.valueOf(secs);
else
   b=String.valueOf(secs);


            int milliseconds=(int)(updatetime %1000);
            tr=milliseconds;
            abc=n+":"+b+":"+String.format("%3d",milliseconds);
p.setText(abc);
customhandler.postDelayed(this,0);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button) findViewById(R.id.start1);
        end=(Button) findViewById(R.id.end);
        end.setEnabled(false);
        p=(TextView) findViewById(R.id.abc);
x();
h=(TextView) findViewById(R.id.below);
h.setText(d);
        start.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                startTime= SystemClock.uptimeMillis();
                start(p);
                customhandler.postDelayed(updateTimerThread,0);
start.setEnabled(false);
end.setEnabled(true);
            }
        }
        );
        end.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                timeswapbuff+=timeinmilliseconds;
                customhandler.removeCallbacks(updateTimerThread);
                startTime=0;
                timeinmilliseconds=0;
                timeswapbuff=0;
                updatetime=0;
                changecolor(p);
                start.setEnabled(true);
                end.setEnabled(false);
                g.setText("press to start");
                d="";
                x();
gd=(TextView) findViewById(R.id.first);
gd.setText(abc);
                h.setText(d);
            }
        });
    }



    public void start(View v) {
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.soja);
        TextView k = (TextView) findViewById(R.id.abc);
g=(TextView) findViewById(R.id.sa);
        g.setText("press to stop");
        rl.setBackgroundColor(Color.YELLOW);
        TextView l = (TextView) findViewById(R.id.below);
        d = "";
        x();
        rand(l);
    }
public void changecolor(View v)
{
    RelativeLayout k=(RelativeLayout) findViewById(R.id.soja);
    k.setBackgroundColor(Color.RED);
}
    public void rand(View v) {
        TextView l = (TextView) findViewById(R.id.below);




    }

    public void x() {
        Random rand = new Random();
        int k;
        int e = -1;
        for (int i = 0; i < 18; i++) {
            k = rand.nextInt(18);


            while(e==k ||e==k+9||e==k-9||e==(k+1)||e==(k+12)||e==(k+11)||e==(k-11)||e==(k+7)||e==(k-7)||e==(k-12)||e==k-1||e==k+6||e==k-6||e==k+10||e==k-10||e==k+8||e==k-8)
            {
                k=rand.nextInt(18);
            }
e=k;

            d = d + c[k];
            d = d + " ";

        }

    }


}

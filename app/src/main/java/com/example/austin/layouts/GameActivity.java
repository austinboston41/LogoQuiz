package com.example.austin.layouts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class GameActivity extends Activity {
    Button butSubmit;
    RadioButton rb1, rb2, rb3, rb4;
    String sToast;
    ImageView image;
    int nCount=0, nScore=0, nAns=1;

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.rb1:
                if (checked&&nAns==1) {
                    sToast = "✓";
                    break;
                }
                sToast="✗";
                break;
            case R.id.rb2:
                if (checked&&nAns==2) {
                    sToast = "✓";
                    break;
                }
                sToast="✗";
                break;
            case R.id.rb3:
                if (checked&&nAns==3) {
                    sToast = "✓";
                    break;
                }
                sToast="✗";
                break;
            case R.id.rb4:
                if (checked&&nAns==4) {
                    sToast = "✓";
                    break;
                }
                sToast="✗";
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);
        rb4 = (RadioButton)findViewById(R.id.rb4);
        image = (ImageView) findViewById(R.id.ivLogo);
        butSubmit = (Button) findViewById(R.id.button);
        butSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nCount++;
                Toast toCred = Toast.makeText(GameActivity.this, sToast,Toast.LENGTH_SHORT);
                toCred.show();
                if(nCount==1){
                    image.setImageResource(R.drawable.i2);
                    nAns=2;
                    rb1.setText("activision");
                    rb2.setText("ubisoft");
                    rb3.setText("rockstar");
                    rb4.setText("rockstar");
                }
                if(nCount==2){
                    image.setImageResource(R.drawable.i3);
                    nAns=3;
                    rb1.setText("steampunk");
                    rb2.setText("ubuntu");
                    rb3.setText("steam");
                    rb4.setText("gears of war");
                }
                if(nCount==3){
                    image.setImageResource(R.drawable.i4);
                    nAns=4;
                    rb1.setText("encore");
                    rb2.setText("eclipse");
                    rb3.setText("elipse");
                    rb4.setText("square enix");
                }
                if(nCount==4){
                    image.setImageResource(R.drawable.i5);
                    nAns=1;
                    rb1.setText("Rockstar Games");
                    rb2.setText("rice");
                    rb3.setText("Rockstar Gaming");
                    rb4.setText("Rockstars");
                }
                if(nCount==5){
                    image.setImageResource(R.drawable.i6);
                    nAns=2;
                    rb1.setText("Ps3");
                    rb2.setText("Playstation");
                    rb3.setText("Sony");
                    rb4.setText("Ps");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

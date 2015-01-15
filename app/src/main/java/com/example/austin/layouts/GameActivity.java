package com.example.austin.layouts;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.HashMap;

public class GameActivity extends Activity {
    Button butSubmit;
    RadioButton rb1, rb2, rb3, rb4;
    String sToast;
    ImageView image;
    int nScore=0, nAns=1,nGuess,i=0;
    Boolean bChecked;

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.rb1:
                if (checked) {
                    bChecked=true;
                    nGuess=1;
                    break;
                }
                break;
            case R.id.rb2:
                if (checked) {
                    bChecked=true;
                    nGuess=2;
                    break;
                }
                break;
            case R.id.rb3:
                if (checked) {
                    bChecked=true;
                    nGuess=3;
                    break;
                }
                break;
            case R.id.rb4:
                if (checked) {
                    bChecked=true;
                    nGuess=4;
                    break;
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.RelativeLayout);
        rl.setBackgroundColor(Color.WHITE);
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);
        rb3 = (RadioButton) findViewById(R.id.rb3);
        rb4 = (RadioButton) findViewById(R.id.rb4);
        image = (ImageView) findViewById(R.id.ivLogo);
        Resources res = getResources();
        String[] srb1 = res.getStringArray(R.array.rb1);
        String[] srb2 = res.getStringArray(R.array.rb2);
        String[] srb3 = res.getStringArray(R.array.rb3);
        String[] srb4 = res.getStringArray(R.array.rb4);
        rb1.setText(srb1[i]);
        rb2.setText(srb2[i]);
        rb3.setText(srb3[i]);
        rb4.setText(srb4[i]);
            butSubmit = (Button) findViewById(R.id.button);
            butSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    i++;
                    Toast toCred;
                    if (bChecked = true) {
                        if (nAns == nGuess) {
                            sToast = "✓";
                        } else {
                            sToast = "✗";
                        }
                    }
                    toCred = Toast.makeText(GameActivity.this, sToast, Toast.LENGTH_SHORT);
                    toCred.show();
                    Resources res = getResources();
                    String[] srb1 = res.getStringArray(R.array.rb1);
                    String[] srb2 = res.getStringArray(R.array.rb2);
                    String[] srb3 = res.getStringArray(R.array.rb3);
                    String[] srb4 = res.getStringArray(R.array.rb4);
                    rb1.setChecked(false);
                    rb2.setChecked(false);
                    rb3.setChecked(false);
                    rb4.setChecked(false);
                    nAns = i + 1;
                    rb1.setText(srb1[i]);
                    rb2.setText(srb2[i]);
                    rb3.setText(srb3[i]);
                    rb4.setText(srb4[i]);
                    if (i == 1) {
                        image.setImageResource(R.drawable.i2);
                    }
                    if (i == 2) {
                        image.setImageResource(R.drawable.i3);
                    }
                    if (i == 3) {
                        image.setImageResource(R.drawable.i4);
                    }
                    if (i == 4) {
                        image.setImageResource(R.drawable.i5);
                    }
                    if (i == 5) {
                        image.setImageResource(R.drawable.i6);
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

package com.example.austin.layouts;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;


public class MenuActivity extends Activity {
    Button butPlay;
    MediaPlayer mpMusic;

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.rbL1|R.id.rbL2|R.id.rbL3|R.id.rbL4|R.id.rbL5|
                    R.id.rbL6|R.id.rbL7|R.id.rbL8|R.id.rbL9|R.id.rbL10:
                if (checked) {
                    break;
                }
                break;
    }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        butPlay = (Button) findViewById(R.id.butPlay);
        butPlay.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent nextScreen=new Intent(getApplicationContext(), GameActivity.class);
                startActivity(nextScreen);


            }
        });
        Switch toggle = (Switch) findViewById(R.id.switchSound);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mpMusic = MediaPlayer.create(MenuActivity.this, R.raw.musicfile);
                    mpMusic.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.reset();
                            mp.release();

                        }

                    });
                    mpMusic.start();
                    String sToast = "Now Playing: Re-Birthday";
                    Toast toMusic = Toast.makeText(MenuActivity.this, sToast,Toast.LENGTH_SHORT);
                    toMusic.show();
                } else {
                    mpMusic.pause();
                    String sToast = "Stopped";
                    Toast toMusic = Toast.makeText(MenuActivity.this, sToast,Toast.LENGTH_SHORT);
                    toMusic.show();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent nextScreen=new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(nextScreen);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

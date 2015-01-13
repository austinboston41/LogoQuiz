package com.example.austin.layouts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;import java.lang.Override;




public class imgScratch extends Activity {
    Button butSubmit;
    ImageView image;
    int nCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scratch_img);
        image = (ImageView) findViewById(R.id.ivImg);
        butSubmit = (Button) findViewById(R.id.butSwitch);
        butSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nCount++;
                if(nCount==1){
                    image.setImageResource(R.drawable.i2);
                }
                if(nCount==2){
                    image.setImageResource(R.drawable.i3);
                }
                if(nCount==3){
                    image.setImageResource(R.drawable.i4);
                }
                if(nCount==4){
                    image.setImageResource(R.drawable.i5);
                }
                if(nCount==5){
                    image.setImageResource(R.drawable.i6);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



package com.owen.imageseekers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 1 . find the IDs from XML and add image.
        //Adding image from here because we want it only to appear at run time.
        final ImageView img_large = findViewById(R.id.image_view_large);
        //Step 2. find the seeker and associate a onClick listener
        SeekBar seekBar = findViewById(R.id.seek_bar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //step 3. declare a variable to hold our last value
            int lastprogress;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lastprogress = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //set the color filter using argb.
                img_large.setColorFilter(Color.argb(255,0,lastprogress,255-lastprogress));
            }
        });
    }
}
package com.jkapps.readtextfile;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        textView = findViewById(R.id.textView);

        textView.setMovementMethod(new ScrollingMovementMethod());

        String data = "";

        StringBuffer sb = new StringBuffer();

        InputStream is = this.getResources().openRawResource(R.raw.sample_dummy);

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        if (is != null) {
            try {
                while ((data = br.readLine()) != null) {
                    sb.append(data + "\n" + "\t");
                }
                textView.setText(sb);
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package com.example.dan_09;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Credits extends AppCompatActivity {
    Intent gi;
    TextView text;
    float sum;
    int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        text = findViewById(R.id.sumView);
        gi = getIntent();
        counter = 0;
        sum = gi.getFloatExtra("sum", 0);
        text.setText("sum = "+sum);
    }

    public void goBack(View view) {
        gi.putExtra("sum", sum);
        finish();
    }

    public void onBackPressed()
    {
        counter = counter + 1;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();

        if(counter > 1)
        {
            finish();
        }
    }
}
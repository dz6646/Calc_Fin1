package com.example.dan_09;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Variable Definition
    Button plus, minus, equals, divide, credits, clear;
    EditText input;
    Intent si;
    float num1 = 0;
    float sum = 0;
    int first = 1;
    int peoola = 0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Variable Marriage
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        equals = findViewById(R.id.equals);
        divide = findViewById(R.id.divide);
        credits = findViewById(R.id.credits);
        clear = findViewById(R.id.clear);
        input = findViewById(R.id.input);
        si = new Intent(this, Credits.class); // Source Intent
    }

    public void Plus(View view) {
        String st = "";
        st = input.getText().toString();

        if(first == 1)
        {
            first = 0;
        }
        if(!isNumeric(st)) // Input check
        {
            sum = 0;
            num1 = 0;
            first = 1;
            input.setText("");
            input.setHint("");
        }
        else if(!st.equals("")) // If it's empty don't do anything
        {
            num1 = Float.parseFloat(st);
            sum += num1;
        }

        input.setText("");
        input.setHint(sum + " + "); // Show the final output
        peoola = 1;
    }

    public void minus(View view) {
        String st = "";
        st = input.getText().toString();

        if(!isNumeric(st))
        {
            sum = 0;
            num1 = 0;
            first = 1;
            input.setText("");
            input.setHint("");
            Toast.makeText(this, "Wrong input!", Toast.LENGTH_LONG).show();
        }
        if(first == 1)
        {
            num1 = Float.parseFloat(st);
            sum = num1;
            first = 0;
        }
        else if(!st.equals("")) {
            num1 = Float.parseFloat(st);
            sum -= num1;
        }

        input.setText("");
        input.setHint(sum + " - ");
        peoola = 2;
    }

    public void multiple(View view) {
        if(first == 1 && sum == 0)
        {
            sum = 1;
            first = 0;
        }

        String st = "";
        st = input.getText().toString();

        if(!isNumeric(st))
        {
            sum = 0;
            num1 = 0;
            first = 1;
            input.setText("");
            input.setHint("");
            Toast.makeText(this, "Wrong input!", Toast.LENGTH_LONG).show();
        }
        else if(!st.equals("")) {
            num1 = Float.parseFloat(st);
            sum *= num1;
        }

        input.setText("");
        input.setHint(sum + " * ");
        peoola = 3;
    }

    public void divide(View view) {
        String st = "";
        st = input.getText().toString();

        if(!isNumeric(st))
        {
            sum = 0;
            num1 = 0;
            first = 1;
            input.setText("");
            input.setHint("");
            Toast.makeText(this, "Wrong input!", Toast.LENGTH_LONG).show();
        }
        else if(!st.equals("")) {
            num1 = Float.parseFloat(st);
            if (num1 == 0 || sum == 0) {
                sum = 0;
            }
        }

        input.setText("");
        input.setHint(sum + " / ");
        peoola = 4;
    }

    public void equals(View view) {
        String st = "";
        st = input.getText().toString();

        if(!isNumeric(st))
        {
            sum = 0;
            num1 = 0;
            first = 1;
            input.setText("");
            input.setHint("");
            Toast.makeText(this, "Wrong input!", Toast.LENGTH_LONG).show();
        }
        else if(!st.equals(""))
        {
            num1 = Float.parseFloat(st);
        }
        if(peoola == 1)
        {
            sum += num1;
        }
        else if(peoola == 2)
        {
            sum -= num1;
        }
        else if(peoola == 3)
        {
            sum *= num1;
        }
        else if(peoola == 4)
        {
            sum /= num1;
        }
        else
        {
            input.setHint("Error");
        }

        input.setText("");
        input.setHint("" + sum);
    }

    public void clear(View view) {
        sum = 0;
        num1 = 0;
        first = 1;
        input.setText("");
        input.setHint("");
        Toast.makeText(this, "Cleared successfully", Toast.LENGTH_LONG).show();
    }

    public void pass2Creds(View view) {
        si.putExtra("sum", sum);
        startActivityForResult(si, 8);
    }

    public static boolean isNumeric(String st)
    {
        int i = 0;
        if(st.equals(""))
        {
            return true;
        }
        for( i = 0 ; i < st.length(); i++)
        {
            if((st.charAt(i) < '0' || st.charAt(i) > '9') && st.charAt(i) != '-'
            && st.charAt(i) != '.')
            {
                return false;
            }
        }
        return true;
    }
}
package com.example.dan_09; // Calculator 11th class :D

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

    /* *****************************************
    This is the function for the addition method
    ********************************************* */
    public void Plus(View view) {
        String st = "";
        st = input.getText().toString(); // Getting the input
        if(!st.isEmpty()) // Input check 1
        {
            if (isNumeric(st))  // Input check 2
            {
                num1 = Float.parseFloat(st);
                if (peoola == 0) // Calculations
                {
                    sum = num1;
                }
                else
                {
                    peoolot(peoola);
                }

            }
            else {
                Toast.makeText(this, "Error with the input", Toast.LENGTH_SHORT).show();
            }
        }
        input.setText("");
        input.setHint(sum + " +"); // Update the screen
        peoola = 1; // Update the calculation flag
    }

    /* *****************************************
    This is the function for the removal method
    ********************************************* */
    public void minus(View view) {
        String st = "";
        st = input.getText().toString();
        if(!st.isEmpty())
        {
            if (isNumeric(st))
            {
                num1 = Float.parseFloat(st);
                if (peoola == 0)
                {
                    sum = num1;
                }
                else
                {
                    peoolot(peoola);
                }
            } else {
                Toast.makeText(this, "Error with the input", Toast.LENGTH_SHORT).show();
            }
        }
        input.setText("");
        input.setHint(sum + " -");
        peoola = 2;
    }

    /* *****************************************
    This is the function for the multiplation method
    ********************************************* */
    public void multiple(View view) {
        String st = "";
        st = input.getText().toString();
        if(!st.isEmpty())
        {
            if (isNumeric(st))
            {
                num1 = Float.parseFloat(st);
                if (peoola == 0)
                {
                    sum = num1;
                }
                else
                {
                    peoolot(peoola);
                }

            }
            else
            {
                Toast.makeText(this, "Error with the input", Toast.LENGTH_SHORT).show();
            }
        }
        input.setText("");
        input.setHint(sum + " *");
        peoola = 3;
    }

    /* *****************************************
    This is the function for the divide method
    ********************************************* */
    public void divide(View view) {
        String st = "";
        st = input.getText().toString();
        if(!st.isEmpty())
        {
            if (isNumeric(st))
            {
                num1 = Float.parseFloat(st);
                if (peoola == 0)
                {
                    sum = num1;
                }
                else
                {
                    peoolot(peoola);
                }
            }
            else
            {
                Toast.makeText(this, "Error with the input", Toast.LENGTH_SHORT).show();
            }
        }
        input.setText("");
        input.setHint(sum + " /");
        peoola = 4;
    }

    /* **************************************************************************
    This function will check everything and calculate the final sum then show it
    ***************************************************************************** */
    public void equals(View view) {
        String st = "";
        st = input.getText().toString();
        if(!st.isEmpty())
        {
            if (isNumeric(st))
            {
                num1 = Float.parseFloat(st);
                if (peoola == 0)
                {
                    sum = num1;
                }
                else
                {
                    peoolot(peoola);
                }
            }
            else
            {
                Toast.makeText(this, "Error with the input", Toast.LENGTH_SHORT).show();
            }
        }
        input.setText("");
        input.setHint(sum + "");
        peoola = 0;
    }

    /* ****************************
    clear numbers and screen method
    ******************************* */
    public void clear(View view) {
        sum = 0;
        num1 = 0;
        first = 1;
        input.setText("");
        input.setHint("0");
        Toast.makeText(this, "Cleared successfully", Toast.LENGTH_LONG).show();
    }

    /* ******************************
    The Intent activity pass function
    ********************************** */
    public void pass2Creds(View view) {
        si.putExtra("sum", sum);
        startActivityForResult(si, 8);
    }

    /* ********************
    Input checking function
    ************************ */
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

    /* **************************************************************************************
    This function will check what method needs to be done on the sum and do it (Calculations)
    ***************************************************************************************** */
    public void peoolot(int peula)
    {
        switch(peula)
        {
            case 1:
                sum += num1;
                break;
            case 2:
                sum -= num1;
                break;
            case 3:
                sum *= num1;
                break;
            case 4:
                sum /= num1;
                break;
            default:
                sum = num1;
                break;
        }
    }
}


package com.example.calcease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView userinput, ans;
    private String curr, res;
    private Boolean OperatorUsed, DecimalUsed;
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,decimal,clear,backspace,equal,divide,multiply,add,sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userinput = findViewById(R.id.UserInput);
        ans = findViewById(R.id.Result);
        curr = "";
        res = "";
        OperatorUsed = false;
        DecimalUsed = false;
        b0 = findViewById(R.id.N0);
        b1 = findViewById(R.id.N1);
        b2 = findViewById(R.id.N2);
        b3 = findViewById(R.id.N3);
        b4 = findViewById(R.id.N4);
        b5 = findViewById(R.id.N5);
        b6 = findViewById(R.id.N6);
        b7 = findViewById(R.id.N7);
        b8 = findViewById(R.id.N8);
        b9 = findViewById(R.id.N9);
        decimal = findViewById(R.id.decimal);
        equal = findViewById(R.id.equal);
        divide = findViewById(R.id.divide);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        clear = findViewById(R.id.clear_text);
        backspace = findViewById(R.id.backspace);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "0";
                display();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "1";
                display();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "2";
                display();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "3";
                display();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "4";
                display();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "5";
                display();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "6";
                display();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "7";
                display();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "8";
                display();
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curr = curr + "9";
                display();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backspace();
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!OperatorUsed){
                    if(!curr.substring(curr.length()-1,curr.length()).equals(".")){
                        curr = curr + " / ";
                        OperatorUsed = true;
                        DecimalUsed = false;
                    }
                }
                display();
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!OperatorUsed){
                    if(!curr.substring(curr.length()-1,curr.length()).equals(".")){
                        curr = curr + " * ";
                        OperatorUsed = true;
                        DecimalUsed = false;
                    }
                }
                display();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!OperatorUsed){
                    if(!curr.substring(curr.length()-1,curr.length()).equals(".")){
                        curr = curr + " + ";
                        OperatorUsed = true;
                        DecimalUsed = false;
                    }
                }
                display();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!OperatorUsed){
                    if(!curr.substring(curr.length()-1,curr.length()).equals(".")){
                        curr = curr + " - ";
                        OperatorUsed = true;
                        DecimalUsed = false;
                    }
                }
                display();;
            }
        });
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curr.isEmpty()){
                    curr = "0.";
                    DecimalUsed = true;
                }
                if(!DecimalUsed){
                    if(curr.substring(curr.length()-1,curr.length()).equals(" ")){
                        curr = curr + "0.";
                    }
                    else{
                        curr = curr + ".";
                    }
                    DecimalUsed = true;
                }
                display();
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] tokens = curr.split(" ");
                switch (tokens[1]){
                    case "/":
                        res = Double.toString((Double.parseDouble(tokens[0])) / (Double.parseDouble(tokens[2])));
                        break;
                    case "*":
                        res = Double.toString((Double.parseDouble(tokens[0])) * (Double.parseDouble(tokens[2])));
                        break;
                    case "+":
                        res = Double.toString((Double.parseDouble(tokens[0])) + (Double.parseDouble(tokens[2])));
                        break;
                    case "-":
                        res = Double.toString((Double.parseDouble(tokens[0])) - (Double.parseDouble(tokens[2])));
                        break;
                }
                result();
                OperatorUsed = false;
                DecimalUsed = true;
                curr = res;
            }
        });
    }
    void display(){
        userinput.setText(curr);
    }
    void result(){
        ans.setText(res);
    }
    void clear(){
        curr = "";
        res = "";
        DecimalUsed = false;
        OperatorUsed = false;
        display();
        result();
    }
    void backspace(){
        if(curr.substring(curr.length()-1,curr.length()).equals(" ")){
            curr = curr.substring(0,curr.length()-3);
            OperatorUsed = false;
        }
        else if(curr.substring(curr.length()-1,curr.length()).equals(".")){
            curr = curr.substring(0,curr.length()-1);
            DecimalUsed = false;
        }
        else{
            curr = curr.substring(0,curr.length()-1);
        }
        display();
        result();
    }
}
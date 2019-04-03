package com.example.vipuloswal.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,plus,minus,del,div,dot,equal,mult;
    String str="",str1="";
    int i,j;
    float ans;
    char c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=(TextView)findViewById(R.id.tv1);
        t2=(TextView)findViewById(R.id.tv2);
        b0=(Button)findViewById(R.id.zero);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString()+0);
            }
        });
        b1=(Button)findViewById(R.id.one);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString()+1);
            }
        });
        b2=(Button)findViewById(R.id.two);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString()+2);
            }
        });
        b3=(Button)findViewById(R.id.three);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString()+3);
            }
        });
        b4=(Button)findViewById(R.id.four);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString()+4);
            }
        });
        b5=(Button)findViewById(R.id.five);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString()+5);
            }
        });
        b6=(Button)findViewById(R.id.six);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString()+6);
            }
        });
        b7=(Button)findViewById(R.id.seven);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString()+7);
            }
        });
        b8=(Button)findViewById(R.id.eight);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString()+8);
            }
        });
        b9=(Button)findViewById(R.id.nine);
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(t1.getText().toString()+9);
            }
        });
        del=(Button)findViewById(R.id.del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=t1.getText().toString();
                if(!str.isEmpty())
                t1.setText(str.substring(0,str.length()-1));
                t2.setText("");
            }
        });
        plus=(Button)findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=t1.getText().toString();
                if(!str.isEmpty() && !str.endsWith("+") && !str.endsWith(".")) {
                    if (str.endsWith("/") || str.endsWith("x") || str.endsWith("-"))
                        str = str.substring(0, str.length() - 1) + "+";
                    else
                        str = t1.getText().toString() + "+";
                    t1.setText(str);
                }
            }
        });
        minus=(Button)findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=t1.getText().toString();
                if(!str.isEmpty() && !str.endsWith("-") && !str.endsWith(".")) {
                    if (str.endsWith("/") || str.endsWith("x") || str.endsWith("+"))
                        str = str.substring(0, str.length() - 1) + "-";
                    else
                        str = t1.getText().toString() + "-";
                }
                t1.setText(str);
            }
        });
        mult=(Button)findViewById(R.id.mult);
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=t1.getText().toString();
                if(!str.isEmpty() && !str.endsWith("x") && !str.endsWith(".")) {
                    if (str.endsWith("/") || str.endsWith("+") || str.endsWith("-"))
                        str = str.substring(0, str.length() - 1) + "x";
                    else
                        str = t1.getText().toString() + "x";
                }
                t1.setText(str);
            }
        });
        div=(Button)findViewById(R.id.div);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=t1.getText().toString();
                if(!str.isEmpty() && !str.endsWith("/") && !str.endsWith(".")) {
                    if (str.endsWith("+") || str.endsWith("x") || str.endsWith("-"))
                        str = str.substring(0, str.length() - 1) + "/";
                    else
                        str = t1.getText().toString() + "/";
                }
                t1.setText(str);
            }
        });
        dot=(Button)findViewById(R.id.dot);
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=t1.getText().toString();
                if(!str.isEmpty() && !str.endsWith(".") && !str.endsWith("+") && !str.endsWith("-") && !str.endsWith("x") && !str.endsWith("/")) {
                    {
                        str = t1.getText().toString() + ".";
                        t1.setText(str);
                    }
                }
            }
        });
        equal=(Button)findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str=t1.getText().toString();
                ArrayList<Float> a=new ArrayList<Float>();
                ArrayList<Character> b=new ArrayList<Character>();
                a.clear();
                b.clear();
                str1="";
                for(i=0;i<str.length();i++)
                {
                    c=str.charAt(i);
                    if(Character.isDigit(c) || c=='.')
                        str1+=c;
                    else
                    {
                        a.add(Float.parseFloat(str1));
                        str1="";
                        b.add(str.charAt(i));
                    }
                }
                a.add(Float.parseFloat(str1));
                while(!b.isEmpty()) {
                    if (b.contains('/') || b.contains('x')) {
                        i=b.indexOf('/');
                        j=b.indexOf('x');
                        if((j!=-1 && j<i)||i==-1) {
                            ans = a.get(j) * a.get(j + 1);
                            i=j;
                        }
                        else
                            ans=a.get(i)/a.get(i+1);
                        a.remove(i);
                        a.remove(i);
                        b.remove(i);
                        a.add(i,ans);
                    }
                    else if (b.contains('+') || b.contains('-')) {
                        i=b.indexOf('+');
                        j=b.indexOf('-');
                        if((j!=-1 && j<i)||i==-1) {
                            ans = a.get(j) - a.get(j + 1);
                            i=j;
                        }
                        else
                            ans=a.get(i)+a.get(i+1);
                        a.remove(i);
                        a.remove(i);
                        b.remove(i);
                        a.add(i,ans);
                    }
                }
                if(a.isEmpty())
                t2.setText("");
                else if(a.size()>1)t2.setText("null");
                else {
                    t2.setText("" + a.get(0));
                    a.clear();
                }
            }
        });
    }
}

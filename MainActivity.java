package com.example.user.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    Button b1,b2,b3,b,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    EditText ed1;
    String s;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.ID1);
        b2=(Button)findViewById(R.id.ID2);
        b3=(Button)findViewById(R.id.ID3);
        b4=(Button)findViewById(R.id.ID4);
        b5=(Button)findViewById(R.id.ID5);
        b6=(Button)findViewById(R.id.ID6);
        b7=(Button)findViewById(R.id.ID7);
        b8=(Button)findViewById(R.id.ID8);
        b9=(Button)findViewById(R.id.ID9);
        b10=(Button)findViewById(R.id.ID10);
        b11=(Button)findViewById(R.id.ID11);
        b12=(Button)findViewById(R.id.ID12);
        b13=(Button)findViewById(R.id.ID13);
        b14=(Button)findViewById(R.id.ID14);
        b15=(Button)findViewById(R.id.ID15);
        b16=(Button)findViewById(R.id.ID16);
        ed1=(EditText) findViewById(R.id.TV1);
        b1.setOnClickListener(new View.OnClickListener()
                              {
                                  @Override
                                  public void onClick(View v) {
                                      s=ed1.getText().toString();
                                    ed1.setText(s+"1");
                                  }
                              });
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"1");
                pos=s.length()+1;
                ed1.setSelection(pos);}});
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"2");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"3");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"4");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"5");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"6");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"7");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"8");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b9.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"9");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b10.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                int n1,n2;
                String str;
                s=ed1.getText().toString();
                char ch[]=new char[100];
                Stack sc=new Stack();
                StackChar stc=new StackChar();
                ch=s.toCharArray();
                StringTokenizer st=new StringTokenizer(s,"+,*,/,-");
                while(st.hasMoreTokens())
                {
                    str=st.nextToken();
                    sc.push(Integer.parseInt(str));
                }
                while(stc.top!=-1)
                {
                    int n=stc.pop();
                 ed1.setText(Integer.toString(n)+ed1.getText().toString());
                }
                int p=s.length();
                for(int i=0;i<p;i++)
                {
                    if(ch[i]=='*'||ch[i]=='+'||ch[i]=='-'||ch[i]=='/'||ch[i]=='%')
                        stc.push(ch[i]);
                }
                while(stc.top!=-1)
                {
                    int n=0;
                    n2=sc.pop();
                    n1=sc.pop();
                    char op=stc.pop();
                    char op2='0',temp;
                    if(stc.top!=-1)
                        op2=stc.pop();
                    if((priority(op2)<priority(op))&&(priority(op2)!=0))
                    {
                        int n3=n2;
                        n2=n1;
                        n1=sc.pop();
                        temp=op2;
                        op2=op;
                        op=temp;
                        if(op=='+')
                            n=n1+n2;
                        else if(op=='-')
                            n=n1-n2;
                        else if(op=='*')
                            n=n1*n2;
                        else if(op=='/')
                            try{
                                n=n1/n2;
                            }
                            catch(ArithmeticException ae)
                            {
                                ed1.setText("infinite");
                            }
                        stc.push(op2);
                        sc.push(n3);
                        sc.push(n);
                    }
                    else
                    {
                        if(op=='+')
                            n=n1+n2;
                        else if(op=='-')
                            n=n1-n2;
                        else if(op=='*')
                            n=n1*n2;
                        else if(op=='/')
                            try{
                                n=n1/n2;
                            }
                            catch(ArithmeticException ae)
                            {
                                ed1.setText("infinite");
                            }
                        if(op2!='0')
                            stc.push(op2);
                        sc.push(n);
                    }
                }
                String s5=Integer.toString(sc.pop());
                ed1.setText(s5);
                pos=s5.length();
               ed1.setSelection(pos);
                }
        });
        b11.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"*");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b12.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"/");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b13.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"-");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b14.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"+");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b15.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText(s+"0");pos=s.length()+1;
                ed1.setSelection(pos);            }
        });
        b16.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                s=ed1.getText().toString();
                ed1.setText("");
                ed1.setSelection(0);}
        });
    }
    int priority(char ch)
    {
        if(ch=='*'||ch=='/'||ch=='%')
            return 1;
        else if(ch=='+'||ch=='-')
            return 2;
        return 0;
    }

}

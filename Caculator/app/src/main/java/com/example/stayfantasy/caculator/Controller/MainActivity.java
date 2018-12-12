package com.example.stayfantasy.caculator.Controller;

import android.graphics.Region;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.stayfantasy.caculator.Model.Operation;
import com.example.stayfantasy.caculator.R;

public class MainActivity extends AppCompatActivity {
    final int numberKey = 10;
    Button[] btnNumber ;
    Button btnAC,btnMinus,btnPersent,btnEqual,btnAdd,btnSubtract,btnMultiply,btnDivide,btnDot;
    Double result,value1,value2;
    String strCurrent,strResult;
    Character Op;
    TextView txtResult;
    Boolean Dot;
    Operation operation;
    int OPCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dot = false;
        result = 0.0;
        value1 = 0.0;
        value2 = 0.0;
        OPCount = 0;
        strCurrent = "";
        strResult = "";
        txtResult = findViewById(R.id.txtResult);
        btnNumber = new Button[numberKey];
        operation = new Operation();
        //宣告功能按鍵
        btnAC       = findViewById(R.id.btnAC);
        btnMinus    = findViewById(R.id.btnMinus);
        btnEqual    = findViewById(R.id.btnEqual);
        btnPersent  = findViewById(R.id.btnPersent);
        btnAdd      = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide   = findViewById(R.id.btnDivide);
        btnDot      = findViewById(R.id.btnDot);

        //宣告數字按鍵
        for(int i = 0 ; i < numberKey; i++) {
           String buttonID = "btnNum" + i;
           int resID = getResources().getIdentifier(buttonID,"id",getPackageName());
           btnNumber[i] = ((Button)findViewById(resID));
           btnNumber[i].setTag(i);
        }
    }

    public void KeyBtnClick(View v)
    {
        String strNumKey = v.getTag().toString();
        strCurrent = strCurrent + strNumKey;
        SetClick();
        if(strCurrent.charAt(0)=='0' && strCurrent.length()==1)
        {
            strCurrent = "";
        } else {
            txtResult.setText(strCurrent);
        }
    }

    public void DotbtnClick(View v)
    {
        if(strCurrent == "")
        {
            Dot = true;
            strCurrent = "0.";
            txtResult.setText(strCurrent);
        }else if(Dot == false){
            strCurrent = strCurrent + ".";
            txtResult.setText(strCurrent);
            Dot = true;
        }
    }

    public void ClearbtnClick(View v)
    {
        strCurrent = "";
        txtResult.setText("0");
        result = 0.0;
        operation.Clear();
        OPCount = 0;
        SetClick();
        Dot = false;
    }

    public void AddBtnClick(View v)
    {
        btnAdd.setEnabled(false);
        SetOperation('+');
    }

    public void SubstractBtnClice(View v)
    {
        btnSubtract.setEnabled(false);
        SetOperation('-');
    }

    public void MultiplyBtnClick(View v)
    {
        btnMultiply.setEnabled(false);
        SetOperation('*');
    }

    public void DivideBtnClick(View v)
    {
        btnDivide.setEnabled(false);
        SetOperation('/');
    }

    public void EqualBtnClick(View v)
    {
        btnEqual.setEnabled(false);
         if (OPCount == 1) {
            if(strCurrent ==""){ value2 = 0.0; }
            else { value2 = Double.parseDouble(strCurrent); }
            operation.setValue2(value2);
            Result();
            strCurrent = "";
            OPCount ++;
          }else if(OPCount > 1)
          {
            value1 = Double.parseDouble(strResult);
            operation.setValue1(value1);
            value2 = Double.parseDouble(strCurrent);
            operation.setValue2(value2);
            Result();
            strCurrent = "";
            OPCount++;
          }
    }

    public void SetClick()
    {
          btnAdd.setEnabled(true);
          btnSubtract.setEnabled(true);
          btnMultiply.setEnabled(true);
          btnDivide.setEnabled(true);
          btnEqual.setEnabled(true);
    }

    public void Result()
    {
        switch (Op)
        {
            case '+':
                strResult = operation.Add();
                txtResult.setText(strResult);
                break;
            case '-':
                strResult = operation.Substract();
                txtResult.setText(strResult);
                break;
            case '*':
                strResult = operation.Multiply();
                txtResult.setText(strResult);
                break;
            case '/':
                strResult = operation.Divide();
                txtResult.setText(strResult);
                break;
        }
    }

    public void SetOperation(Character op)
    {
        if(OPCount == 0) {
            Op = op;
            if(strCurrent == "") { value1 = 0.0; }
            else { value1 = Double.parseDouble(strCurrent); }
            operation.setValue1(value1);
            strCurrent = "";
            OPCount++;
        }else if (OPCount == 1) {
            if(strCurrent ==""){ value2 = 0.0; }
            else { value2 = Double.parseDouble(strCurrent); }
            operation.setValue2(value2);
            Result();
            strCurrent = "";
            OPCount ++;
            Op = op;
        }else if(OPCount > 1)
        {
            value1 = Double.parseDouble(strResult);
            operation.setValue1(value1);
            if(strCurrent =="")
            {
                if(Op =='*' || Op =='/'){
                    value2 = 1.0;
                }else {
                    value2 = 0.0;
                }
            }
            else { value2 = Double.parseDouble(strCurrent); }
            operation.setValue2(value2);
            Result();
            strCurrent = "";
            OPCount++;
            Op = op;
        }
    }
}

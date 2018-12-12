package com.example.stayfantasy.caculator.Model;

public class Operation {



    double value1,value2,result;
    String strResult;

    //region Number Setter & Getter
    public double getValue1() {
        return value1;
    }

    public void setValue1(double value1) {
        this.value1 = value1;
    }

    public double getValue2() {
        return value2;
    }

    public void setValue2(double value2) {
        this.value2 = value2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    //endregion


    public Operation()
    {
        value1 = 0;
        value2 = 0;
        result = 0;
    }

    public void Clear()
    {
        value1 = 0;
        value2 = 0;
        result = 0;
    }

    public String Add()
    {
        result = value1 + value2;
        strResult = String.valueOf(result);
        return strResult;
    }


    public String Substract()
    {
        result = value1 - value2;
        strResult = String.valueOf(result);
        return strResult;
    }

    public String Multiply()
    {
        result = value1 * value2;
        strResult = String.valueOf(result);
        return  strResult;
    }

    public String Divide()
    {
        result = value1 / value2;
        strResult = String.valueOf(result);
        return  strResult;
    }

}

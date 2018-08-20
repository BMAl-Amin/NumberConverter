package com.example.alamin.numberconverter;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

public class NumberConvertService {
    private String inputNumber, result;
    private int inNumType, outNumType, iNumber;
    private String numberType;

    public NumberConvertService(){
        inputNumber=null;
        inNumType=0;
        outNumType=0;
        result=null;
    }

    public String convertNumber(String inputNumber, int inNumType, int outNumType){

        if(inNumType==0){ //decimal to others
            iNumber=Integer.parseInt(inputNumber); //convert inputNumber String to Integer
            switch (outNumType){
                case 1:{
                    result=Integer.toBinaryString(iNumber);
                    numberType= "Binary Number is ";
                    break;
                }
                case 2:{
                    result=Integer.toOctalString(iNumber);
                    numberType= "Octal Number is ";
                    break;
                }
                case 3:{
                    result=Integer.toHexString(iNumber);
                    numberType= "Hexadecimal Number is";
                    break;
                }
                default: {
                    result=inputNumber;
                    numberType= "Decimal Number is ";
                }
            }
        }else if(inNumType==1){ //binary to others
            iNumber=Integer.parseInt(inputNumber, 2); //convert inputnumber binary to integer
            switch (outNumType){
                case 0:{
                    result= String.valueOf(iNumber);
                    numberType= "Decimal Number is ";
                    break;
                }
                case 2:{
                    result= Integer.toOctalString(iNumber);
                    numberType= "Octal Number is ";
                    break;
                }
                case 3:{
                    result= Integer.toHexString(iNumber);
                    numberType= "Hexadecimal Number is";
                    break;
                }
                default: {
                    result=inputNumber;
                    numberType= "Binary Number is ";
                }
            }
        }else if(inNumType==2){ //octal to others
            iNumber=Integer.parseInt(inputNumber, 8); //convert inputnumber octal to decimal
            switch (outNumType){
                case 0:{
                    result= String.valueOf(iNumber);
                    numberType= "Decimal Number is ";
                    break;
                }
                case 1:{
                    result= Integer.toBinaryString(iNumber);
                    numberType= "Binary Number is ";
                    break;
                }
                case 3:{
                    result= Integer.toHexString(iNumber);
                    numberType= "Hexadecimal Number is";
                    break;
                }
                default: {
                    result=inputNumber;
                    numberType= "Octal Number is ";
                }
            }
        }else { //hex to others
            iNumber=Integer.parseInt(inputNumber, 16); //convert inputnumber hex to decimal
            switch (outNumType){
                case 0:{
                    result= String.valueOf(iNumber);
                    numberType= "Decimal Number is ";
                    break;
                }
                case 1:{
                    result= Integer.toBinaryString(iNumber);
                    numberType= "Binary Number is ";
                    break;
                }
                case 2:{

                    result= Integer.toOctalString(iNumber);
                    numberType= "Octal Number is";
                    break;
                }
                default: {
                    result=inputNumber;
                    numberType= "Hexadecimal Number is ";
                }
            }
        }
        return inputNumber+"\'s "+ numberType+" "+result.toUpperCase();
    }
}

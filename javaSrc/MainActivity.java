package com.example.alamin.numberconverter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private Button oNe, tWo, tHree, fOur, fIve, sIx, sEven, eIght, nIne, zEro, backSpace, convertBtn;
    private Spinner inputSpnr, resultSpnr;
    private int inNumType, outNumType;
    private String inputNumber, outputSentence;
    SpannableString outColoredSentence;
    ForegroundColorSpan outColorA, outColorB;
    private NumberConvertService numberConvertService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        numberConvertService= new NumberConvertService();
        addListenerOnButton();
    }
    private void setupUI(){
        textView= findViewById(R.id.result);
        editText= findViewById(R.id.input);
        oNe = findViewById(R.id.one);
        tWo = findViewById(R.id.two);
        tHree = findViewById(R.id.three);
        fOur = findViewById(R.id.four);
        fIve = findViewById(R.id.five);
        sIx = findViewById(R.id.six);
        sEven = findViewById(R.id.seven);
        eIght = findViewById(R.id.eight);
        nIne = findViewById(R.id.nine);
        zEro = findViewById(R.id.zero);
        backSpace= findViewById(R.id.bspace);
        inputSpnr= findViewById(R.id.cwspnr);
        resultSpnr= findViewById(R.id.ctspnr);
        convertBtn= findViewById(R.id.btnconvert);
    }
    private void addListenerOnButton(){
        zEro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + zEro.getText().toString());
                if (editText.getText().toString().equals("0")) {
                    editText.setText(null);
                    textView.setText(null);
                }
            }
        });
        oNe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + oNe.getText().toString());
            }
        });
        tWo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + tWo.getText().toString());
            }
        });
        tHree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + tHree.getText().toString());
            }
        });
        fOur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + fOur.getText().toString());
            }
        });
        fIve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + fIve.getText().toString());
            }
        });
        sIx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + sIx.getText().toString());
            }
        });
        sEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + sEven.getText().toString());
            }
        });
        eIght.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText.setText(editText.getText().toString() + eIght.getText().toString());

            }
        });
        nIne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText().toString() + nIne.getText().toString());
            }
        });
        backSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputNumber=editText.getText().toString();
                editText.setText(inputNumber.substring(0, inputNumber.length()-1));
            }
        });
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inNumType= inputSpnr.getSelectedItemPosition();
                outNumType= resultSpnr.getSelectedItemPosition();
                inputNumber=editText.getText().toString();
                outputSentence= numberConvertService.convertNumber(inputNumber, inNumType, outNumType);
                outColoredSentence= new SpannableString(outputSentence);
                outColorA= new ForegroundColorSpan(Color.RED);
                outColorB= new ForegroundColorSpan(Color.GREEN);
                outColoredSentence.setSpan(outColorA, 0, inputNumber.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                outColoredSentence.setSpan(outColorB, outputSentence.indexOf("is")+2, outputSentence.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText(outColoredSentence);
            }
        });
    }
}

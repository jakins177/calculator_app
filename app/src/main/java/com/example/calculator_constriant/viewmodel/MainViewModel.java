package com.example.calculator_constriant.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.math.BigDecimal;
//review
public class MainViewModel extends ViewModel {

    //mutablelivedata
    private MutableLiveData<String> displayString = new MutableLiveData<>();

    private String beforeOpValue = "";
    private String afterOpValue = "";
    private String currentOperator = "";
    private boolean isAfterOp = false;
    private boolean resultShowing = true;

    private static final String MSG_TAG = "MainViewModel";

    public void setDisplayString(MutableLiveData<String> displayString) {
        this.displayString = displayString;
    }

    public LiveData<String> getDisplayString() {
        return displayString;
    }

    public void resetForNextCalc() {
        beforeOpValue = "";
        afterOpValue = "";
        currentOperator = "";
        isAfterOp = false;
        resultShowing = true;

    }

    public void calculateSomething(int num) {

        displayString.setValue(("my num is " + num));
    }

    public void processInput(String input) {


        final boolean isANumber = input.equals("0") || input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5")
                || input.equals("6") || input.equals("7") || input.equals("8") || input.equals("9");


        if (currentOperator.equals("") || isANumber || input.equals(".")) {
            if (resultShowing) {
                displayString.setValue("");
                resultShowing = false;
            }

            updateDisplay(input);
        }

        if (!isAfterOp) {
            if (input.equals("+") || input.equals("-") || input.equals("x") || input.equals("÷")) {
                setAfterOp(true);
                setOperator(input);
            } else if (isANumber || input.equals(".")) {

                setBeforeOpValue(getBeforeOpValue() + input);

                Log.d(MSG_TAG, "getBeforeOpValue is: " + getBeforeOpValue());

            }
        } else {
            if (isANumber || input.equals(".")) {
                setAfterOpValue(getAfterOpValue() + input);
                Log.d(MSG_TAG, "getAfterOpValue is: " + getAfterOpValue());
            } else if (input.equals("=")) {

                if (currentOperator.equals("+")) {

                    BigDecimal numOne = new BigDecimal(getBeforeOpValue());
                    BigDecimal numTwo = new BigDecimal(getAfterOpValue());

                    BigDecimal result = addition(numOne, numTwo);
                    Log.d(MSG_TAG, "the result is: " + result);
                    displayString.setValue("");
                    updateDisplay(result.toString());
                    resetForNextCalc();
                } else if (currentOperator.equals("-")) {
                    BigDecimal numOne = new BigDecimal(getBeforeOpValue());
                    BigDecimal numTwo = new BigDecimal(getAfterOpValue());

                    BigDecimal result = substraction(numOne, numTwo);
                    Log.d(MSG_TAG, "the result is: " + result);
                    displayString.setValue("");
                    updateDisplay(result.toString());
                    resetForNextCalc();
                } else if (currentOperator.equals("÷")) {
                    BigDecimal numOne = new BigDecimal(getBeforeOpValue());
                    BigDecimal numTwo = new BigDecimal(getAfterOpValue());

                    BigDecimal result = division(numOne, numTwo);
                    Log.d(MSG_TAG, "the result is: " + result);
                    displayString.setValue("");
                    updateDisplay(result.toString());
                    resetForNextCalc();

                } else if (currentOperator.equals("x")) {
                    BigDecimal numOne = new BigDecimal(getBeforeOpValue());
                    BigDecimal numTwo = new BigDecimal(getAfterOpValue());

                    BigDecimal result = multiplication(numOne, numTwo);
                    Log.d(MSG_TAG, "the result is: " + result);
                    displayString.setValue("");
                    updateDisplay(result.toString());
                    resetForNextCalc();

                }

            }

        }
        if (input.equals("⌫")) {
            resetForNextCalc();
            displayString.setValue("0");
        }

    }


    public void updateDisplay(String msg) {

        if (displayString.getValue() == null) {
            displayString.setValue(msg);
        } else {
            displayString.setValue(displayString.getValue() + msg);
        }

    }


    public String getOperator() {
        return currentOperator;
    }

    public void setOperator(String operator) {
        this.currentOperator = operator;
    }

    public BigDecimal addition(BigDecimal param1, BigDecimal param2) {
        return param1.add(param2);
    }


    public BigDecimal substraction(BigDecimal param1, BigDecimal param2) {
        return param1.subtract(param2);
    }

    public BigDecimal division(BigDecimal param1, BigDecimal param2) {
        return param1.divide(param2);
    }

    public BigDecimal multiplication(BigDecimal param1, BigDecimal param2) {
        return param1.multiply(param2);
    }

    public void setBeforeOpValue(String beforeOpValue) {
        this.beforeOpValue = beforeOpValue;
    }

    public void setAfterOpValue(String afterOpValue) {
        this.afterOpValue = afterOpValue;
    }

    public String getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(String currentOperator) {
        this.currentOperator = currentOperator;
    }

    public String getBeforeOpValue() {
        return beforeOpValue;
    }

    public String getAfterOpValue() {
        return afterOpValue;
    }


    public boolean isAfterOp() {
        return isAfterOp;
    }

    public void setAfterOp(boolean afterOp) {
        isAfterOp = afterOp;
    }


}

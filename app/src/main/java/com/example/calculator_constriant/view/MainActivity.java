package com.example.calculator_constriant.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;

import com.example.calculator_constriant.R;
import com.example.calculator_constriant.databinding.ActivityMainBinding;
import com.example.calculator_constriant.viewmodel.MainViewModel;

import android.text.TextUtils;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainViewModel viewModel;
    private ActivityMainBinding binding;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "was created");
        // NEW WAY: Initialize Binding class
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // NEW WAY: Pass binding root to content view
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getDisplayString().observe(this, s -> binding.calculation.setText(s));

        binding.button1007.setOnClickListener(view -> viewModel.processInput("2"));
        binding.button6.setOnClickListener(view -> viewModel.processInput("INV"));
        binding.button7.setOnClickListener(view -> viewModel.processInput("RAD"));
        binding.button8.setOnClickListener(view -> viewModel.processInput("SIN"));
        binding.button9.setOnClickListener(view -> viewModel.processInput("COS"));
        binding.button10.setOnClickListener(view -> viewModel.processInput("TAN"));
        binding.button11.setOnClickListener(view -> viewModel.processInput("%"));
        binding.button12.setOnClickListener(view -> viewModel.processInput("✓"));
        binding.button13.setOnClickListener(view -> viewModel.processInput("LN"));
        binding.button14.setOnClickListener(view -> viewModel.processInput("LOG"));
        binding.button15.setOnClickListener(view -> viewModel.processInput("^"));
        binding.button16.setOnClickListener(view -> viewModel.processInput("π"));
        binding.button17.setOnClickListener(view -> viewModel.processInput("E"));
        binding.button18.setOnClickListener(view -> viewModel.processInput("("));
        binding.button19.setOnClickListener(view -> viewModel.processInput(")"));
        binding.button20.setOnClickListener(view -> viewModel.processInput("!"));
        binding.button21.setOnClickListener(view -> viewModel.processInput("7"));
        binding.button22.setOnClickListener(view -> viewModel.processInput("4"));
        binding.button23.setOnClickListener(view -> viewModel.processInput("0"));
        binding.button24.setOnClickListener(view -> viewModel.processInput("1"));
        binding.button25.setOnClickListener(view -> viewModel.processInput("8"));
        binding.button26.setOnClickListener(view -> viewModel.processInput("9"));
        binding.button27.setOnClickListener(view -> viewModel.processInput("÷"));
        binding.button28.setOnClickListener(view -> viewModel.processInput("⌫"));
        binding.button29.setOnClickListener(view -> viewModel.processInput("5"));
        binding.button31.setOnClickListener(view -> viewModel.processInput("6"));
        binding.button32.setOnClickListener(view -> viewModel.processInput("x"));
        binding.button34.setOnClickListener(view -> viewModel.processInput("3"));
        binding.button35.setOnClickListener(view -> viewModel.processInput("-"));
        binding.button36.setOnClickListener(view -> viewModel.processInput("."));
        binding.button38.setOnClickListener(view -> viewModel.processInput("+"));
        binding.button39.setOnClickListener(view -> viewModel.processInput("="));

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();


        Log.d(TAG, id + " was clicked");


    }

    public void updateDisplay(String msg) {

        binding.calculation.append(msg);

    }
}
package com.crisspian.fragment_guide_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.crisspian.fragment_guide_01.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }

}
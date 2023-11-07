package com.example.superquiz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.superquiz.databinding.ActivityMainBinding;
import com.example.superquiz.databinding.FragmentWelcomeBinding;

public class MainActivity extends AppCompatActivity {

    //CLASSE AFFICHANT L'ACTIVITE PRINCIPALE, ELLE INFLATE L'XML QUI AFFICHE L'UI
    // DE CETTE ACTIVITE (QUI ELLE MEME CONTIENT UN CONTAINER DE FRAGMENT
    // QUI ELLE AFFICHE LE PREMIER FRAGMENT)
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}
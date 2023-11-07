package com.example.superquiz.ui.welcome;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.superquiz.R;
import com.example.superquiz.databinding.FragmentWelcomeBinding;
import com.example.superquiz.ui.quiz.QuizFragment;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WelcomeFragment extends Fragment {

    //public WelcomeFragment() {Required empty public constructor }

    //classe qui represente le premier fragment qui est lancé par le container situé dans l'XML
    // de mainactivity

    private FragmentWelcomeBinding binding;
    public static WelcomeFragment newInstance() {
        WelcomeFragment fragment = new WelcomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*@Override
    public void onStart() {
        super.onStart();
        binding.buttonWelcome.setEnabled(false);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //j'active le bouton de lancement du quizz et je le verouille
        // de base et je lui indique une couleur (celle du fond pour que le bouton soit invisible)
        binding.buttonWelcome.setEnabled(false);
        binding.buttonWelcome.setBackgroundColor(0);

        //j'active le textedit pour que l'utilisateur mette son nom
        binding.messageInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            // lorsque le texte est incrit, j'active le bouton de lancement du quizz
            // lorsque l'utilisateur inscrit un text et je lui donne une couleur (jaune)
            @Override
            public void afterTextChanged(Editable s) {
                binding.buttonWelcome.setEnabled(!s.toString().isEmpty());
                binding.buttonWelcome.setBackgroundColor(-256);

                // conditionnelle pour verifier que tant que le champs de texte est vide le bouton
                // reste verouillé et invisible sinon le bouton est activé et
                // apparait avec la couleur jaune
                if (s.toString().isEmpty()) {
                    binding.buttonWelcome.setEnabled(false);
                    binding.buttonWelcome.setBackgroundColor(0);
                } else {
                    binding.buttonWelcome.setEnabled(true);
                    binding.buttonWelcome.setBackgroundColor(-256);
                }


            }
        });

        // j'ajoute le fonctionnement du bouton lors du clique sur le bouton de lancement du quizz
        // et je lance le fragment suivant celui qui affiche le quizz
        binding.buttonWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //USER JUST CLICK
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                QuizFragment quizFragment = QuizFragment.newInstance();
                fragmentTransaction.add(R.id.fragment_container, quizFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }
}
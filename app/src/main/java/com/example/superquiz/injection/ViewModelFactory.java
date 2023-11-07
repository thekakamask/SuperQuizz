package com.example.superquiz.injection;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.superquiz.data.QuestionBank;
import com.example.superquiz.data.QuestionRepository;
import com.example.superquiz.ui.quiz.QuizViewModel;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory implements ViewModelProvider.Factory {

    //Cette classe en un factory qui creer une instance de QuizzViewModel
    //elle garantis que le QuizzViewModel sont creer avec les dependances
    // necessaire , ici le QuestionRepository

    private final QuestionRepository questionRepository;
    // reference immuable a QuestionRepository
    private static ViewModelFactory factory;
    //instance static de ViewModelFactory (singleton)
    //singleton garantit qu'une classe n'a qu'une seule instance
    // et fournit un point d'accès global à cette instance.
    // Le modèle Singleton est souvent utilisé pour des
    // cas où une seule instance d'une classe est nécessaire
    // pour coordonner des actions à travers un système.


    //Méthode statique fournit un moyen
    // d'accéder à l'instance unique de ViewModelFactory
    public static ViewModelFactory getInstance() {
        if (factory == null) {
            synchronized (ViewModelFactory.class) {
                if (factory == null) {
                    factory = new ViewModelFactory();
                }
            }
        }
        return factory;
    }

    //Constructeur privé pour empêcher l'instanciation
    // directe de la classe et pour soutenir le modèle
    // Singleton. À l'intérieur du constructeur, il initialise
    // questionRepository en utilisant une instance de
    // QuestionBank, qui est également obtenue en suivant
    // le modèle Singleton.
    private ViewModelFactory() {
        QuestionBank questionBank = QuestionBank.getInstance();
        this.questionRepository = new QuestionRepository(questionBank);
    }


    //Cette méthode est une implémentation de l'interface
    // ViewModelProvider.Factory et est appelée pour
    // instancier des ViewModels. Elle vérifie si la
    // modelClass passée en paramètre est assignable depuis
    // QuizViewModel.class et, dans ce cas, elle crée et
    // retourne une instance de QuizViewModel en lui passant
    // le questionRepository. Si modelClass ne correspond
    // pas à un ViewModel géré par cette fabrique, elle lance
    // une IllegalArgumentException
    @Override
    @NotNull
    public <T extends ViewModel>  T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(QuizViewModel.class)) {
            return (T) new QuizViewModel(questionRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}

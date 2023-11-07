package com.example.superquiz.ui.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.superquiz.data.Question;
import com.example.superquiz.data.QuestionRepository;

import java.util.List;

public class QuizViewModel extends ViewModel {

    // declaration de 3 variables : le repository, une liste de question avec
    // en parametre la classe question et un index d'une question ( la question utilisé)
    private QuestionRepository questionRepository;
    private List<Question> questions;
    private Integer currentQuestionIndex = 0;

    //cette classe recupere le repository et elle construit un objet QuizzViewModel
    // avec en parametre le repository et l'initialise
    public QuizViewModel(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    /*public QuestionRepository getQuestionRepository() {
        return questionRepository;
    }*/

    //declaration de livedata (qui sont des données changeantes). celle de la question sur
    // le modele de la question,
    // celle du score (chiffre) et celle de la derniere question (boolean)
    // initialisé de base a false
    MutableLiveData<Question> currentQuestion= new MutableLiveData<>();
    MutableLiveData<Integer> score = new MutableLiveData<>(0);
    MutableLiveData<Boolean> isLastQuestion = new MutableLiveData<>(false);

    //
    public void startQuiz() {
        // j'inscrit dans la variable de la liste de question, la liste des donnéés
        // des questions par le repository qui lui meme recupere la liste des données
        // dans la base de données
        questions = questionRepository.getQuestions();
        // je recupere la premiere question et la met a jour dans la live data currentquestion
        currentQuestion.postValue(questions.get(0));
    }

    public void nextQuestion() {

        // ajoute +1 a la variable index de la current question et la met dans une nouvelle
        // variable nextIndex

        Integer nextIndex = currentQuestionIndex + 1;

        // contionnelle des actions en fonction de la valeur de l'index
        // si jamais la variable nextIndex est égale a l'index de la derniere question
        // alors la livedata boolean isLastQuestion passe en true
        if(nextIndex>=questions.size()) {
            return; // should not happened as the "Next" button is not
            //displayed at the last question
        } else if (nextIndex==questions.size() -1){
            isLastQuestion.postValue(true);
        }
        // l'index de la currentQuestionIndex égale la variable nextIndex
        // la livedata prend la donnée de la question de l'index de la current question.
        currentQuestionIndex=nextIndex;
        currentQuestion.postValue(questions.get(currentQuestionIndex));
    }

    // fonction qui renvoit une vrai ou faux avec en parametre l'answerIndex
    // recupere la valeur de la live data de la question et l'integre
    // dans une variable question. La fonction verifie ensuite que la
    // question n'est pas null et si l'index de la reponse correcte
    // correspond a l'index de la reponse fournie. le resultat de la verification
    // est stocké dans isValid
    //current score recupere la score stocké dans la livedata score
    // conditionnelle qui verifie que isValid est vrai et que le score n'est pas null
    // ajoute la valeur de la livedata score +1
    //retourne la valeur de isvalid de la reponse correcte.
    public boolean isAnswerValid (Integer answerIndex) {
        Question question = currentQuestion.getValue();
        boolean isValid = question != null && question.getAnswerIndex() == answerIndex;
        Integer currentScore = score.getValue();
        if(currentScore != null && isValid) {
            score.setValue(currentScore + 1);
        }
        return isValid;
    }
}

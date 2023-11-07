package com.example.superquiz.data;

import java.util.List;

public class Question {

    //CLASSE REPRESENTANT LE MODELE D'UNE QUESTION : AVEC LA QUESTION, LA LISTE DES REPONSES
    // ET L'INDEX DE LA BONNE REPONSE

    private final String question;
    private final List<String> choiceList;
    private final Integer answerIndex;


    public Question(String question, List<String> choiceList, int answerIndex) {

        this.question = question;
        this.choiceList = choiceList;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoiceList() {
        return choiceList;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }
    /*public String setQuestion() {
        return question;
    }

    public List<String> setChoiceList() {
        return choiceList;
    }

    public int setAnswerIndex() {
        return answerIndex;
    }*/
}

package com.example.superquiz.data;

import java.util.List;

public class QuestionRepository {

    //cette classe recupere la banque de questions et elle construit un objet QuestionRepository
    //avec en parametre la banque de questions et l'initialise
    private final QuestionBank questionBank;

    public QuestionRepository(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }

    //elle retourne egalement la liste de questions
    // contenue dans la banque de question
    public List<Question> getQuestions() {
        return questionBank.getQuestions();
    }

}

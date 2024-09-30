package com.playquiz.quizapp.service;

import com.playquiz.quizapp.Question;
import com.playquiz.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }

    public List<Question> getQestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }

    public String deleteQuestion(Integer id) {
        if(questionDao.existsById(id)){
            questionDao.deleteById(id);
            return "Delete Success";
        }
        else{
            return "Id Not Found";
        }
    }

    //error in update API ??
    public String updateQuestion(Question question) {
        System.err.println("Id is: "+ question.getId());
        try {
            if (questionDao.existsById(question.getId())) {
                questionDao.save(question);
                return "update success";
            } else {
                return "question not found";
            }
        } catch (Exception e) {
            System.err.println("Error updating question: " + e.getMessage());
            return "update failed";
        }
    }

}

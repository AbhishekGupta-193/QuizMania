package com.playquiz.quizapp.service;

import com.playquiz.quizapp.model.Question;
import com.playquiz.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        if(questionDao.existsById(id)){
            questionDao.deleteById(id);
            return new ResponseEntity<>("Delete Success",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Id Not Found",HttpStatus.NOT_FOUND);
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

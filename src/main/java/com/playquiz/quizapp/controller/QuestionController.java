package com.playquiz.quizapp.controller;

import com.playquiz.quizapp.Question;
import com.playquiz.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
//        return "Here are the Qns...";
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{cat}")
    public List<Question> getQuestionsByCategory(@PathVariable("cat") String category){
        return questionService.getQestionsByCategory(category);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

    @PutMapping("/update")
    public String updateQuestion(Question question){
        return questionService.updateQuestion(question);
    }
}

# Documentation #

# FOR ADMIN USE :

## Get All Questions 
GET : http://localhost:8080/question/allQuestions

## Get Questions By Category
GET : http://localhost:8080/question/category/{category}

## Add Question
POST : http://localhost:8080/question/add
BODY TYPE :
  {
        "questionTitle": "Work done is the product of force and ?",
        "option1": "Momentum",
        "option2": "Dsiplacement",
        "option3": "Distance",
        "option4": "Energy",
        "rightAnswer": "Dsiplacement",
        "difficultyLevel": "Easy",
        "category": "Science"
    }

## Delete Question
DELETE : http://localhost:8080/question/delete/{Question_Id}

## Update Question
PUT : http://localhost:8080/question/update
BODY TYPE:
[
    {
        "id": 14,
        "questionTitle": "Work done is the product of force and ?",
        "option1": "Momentum",
        "option2": "Dsiplacement",
        "option3": "Distance",
        "option4": "Energy",
       "rightAnswer": "Dsiplacement",
        "difficultyLevel": "Hard",
        "category": "Science"
    }
]


# FOR USER USE :

## Create Quiz
POST : http://localhost:8080/quiz/create?category=Math&noOfQns=2&title=quiz1
KEY REQUIRED: category , noOfQns , title

## Get Quiz Questions 
GET : http://localhost:8080/quiz/get/{Quiz_Id}

## Get Quiz Score
POST : http://localhost:8080/quiz/submit/{Quiz_Id}
BODY TYPE :
[
    {
        "id": 2,
        "response": "4"
    },
    {
        "id": 7,
        "response": "4"
    }
]

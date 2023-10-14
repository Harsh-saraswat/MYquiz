package com.example.myquizapp

object Constants {

    const val USER_NAME:String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWER:String = "correct_answers"


    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val ques1 = Question(
            1,"What Country Does this flag belong to?"
        ,R.drawable.ic_flag_of_argentina,
            "Argentina"
        ,   "Australia",
            "Armenia",
            "Austria",
            1
        )
        questionList.add(ques1)
        val ques2 = Question(
            2,"What Country Does this flag belong to?"
            ,R.drawable.ic_flag_of_belgium,
            "Denmark"
            ,   "Belgium",
            "Armenia",
            "Spain",
            2
        )
        questionList.add(ques2)
        val ques3 = Question(
            3,"What Country Does this flag belong to?"
            ,R.drawable.ic_flag_of_australia,
            "Argentina"
            ,   "Europe",
            "America",
            "Australia",
            4
        )
        questionList.add(ques3)
        val ques4 = Question(
            4,"What Country Does this flag belong to?"
            ,R.drawable.ic_flag_of_brazil,
            "Kenya"
            ,   "Kuwait",
            "Brazil",
            "Nepal",
            3
        )
        questionList.add(ques4)
        val ques5 = Question(
            5,"What Country Does this flag belong to?"
            ,R.drawable.ic_flag_of_denmark,
            "SriLanka"
            ,   "Denmark",
            "Armenia",
            "Romania",
            2
        )
        questionList.add(ques5)
        val ques6 = Question(
            6,"What Country Does this flag belong to?"
            ,R.drawable.ic_flag_of_fiji,
            "Fiji"
            ,   "China",
            "Canada",
            "Austria",
            1
        )
        questionList.add(ques6)
        val ques7 = Question(
            7,"What Country Does this flag belong to?"
            ,R.drawable.ic_flag_of_germany,
            "New ZealLad"
            ,   "Germany",
            "Armenia",
            "Japan",
            2
        )
        questionList.add(ques7)
        val ques8 = Question(
            8,"What Country Does this flag belong to?"
            ,R.drawable.ic_flag_of_india,
            "India"
            ,   "Australia",
            "Australia",
            "Austria",
            1
        )
        questionList.add(ques8)
        val ques9 = Question(
            9,"What Country Does this flag belong to?"
            ,R.drawable.ic_flag_of_kuwait,
            "London"
            ,   "Kuwait",
            "France",
            "Austria",
            2
        )
        questionList.add(ques9)
        val ques10 = Question(
            10,"What Country Does this flag belong to?"
            ,R.drawable.ic_flag_of_new_zealand,
            "Russia"
            ,   "France",
            "New Zealand",
            "America",
            3
        )
        questionList.add(ques10)
        return questionList
    }
}
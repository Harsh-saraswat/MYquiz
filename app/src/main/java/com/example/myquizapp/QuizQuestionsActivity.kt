package com.example.myquizapp

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Contactables
import android.service.autofill.OnClickAction
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener{
    private var mCurrentPosition:Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int= 0
    private var btnSumbit : Button?= null
    private var progressBar: ProgressBar?=null
    private var tvProgressBar : TextView?=null
    private var tvQuestion: TextView?= null
    private var ivimage: ImageView?=null
    private var tvOption1: TextView?= null
    private var tvOption2: TextView?= null
    private var tvOption3: TextView?= null
    private var tvOption4: TextView?= null
    private var mUserName:String? =null
    private var mCorrectanswer:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progessbar)
        tvProgressBar= findViewById(R.id.tv_progess)
        tvQuestion = findViewById(R.id.tv_question)
        ivimage = findViewById(R.id.iv_image)
        tvOption1 = findViewById(R.id.tv_option_one)
        tvOption2  =findViewById(R.id.tv_option_two)
        tvOption3 = findViewById(R.id.tv_option_three)
        tvOption4 = findViewById(R.id.tv_option_four)
        btnSumbit = findViewById(R.id.btn_submit)
        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSumbit?.setOnClickListener(this)
        mQuestionList = Constants.getQuestions()
        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivimage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgressBar?.text = "${mCurrentPosition}/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour

        if(mCurrentPosition==mQuestionList!!.size){
            btnSumbit?.text = "FINISH"
        }
        else{
            btnSumbit?.text = "SUMBIT"
        }
    }
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOption1?.let{
            options.add(0,it)
        }
        tvOption2?.let{
            options.add(1,it)
        }
        tvOption3?.let{
            options.add(2,it)
        }
        tvOption4?.let{
            options.add(3,it)
        }
        for(option in options){
//            option.setTextColor(Color.parseColor("#7A8089"))
            option.setTextColor(Color.parseColor("#363A43"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.design_option_border_bg
            )
        }
    }
    private fun selectedOptionView(tv:TextView ,selectedOptionnum: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionnum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selector_option_border_bg
        )
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option_one->{
                tvOption1?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.tv_option_two->{
                tvOption2?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.tv_option_three->{
                tvOption3?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.tv_option_four->{
                tvOption4?.let{
                    selectedOptionView(it,4)
                }

            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            setQuestion()
                        }
                        else->{
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER,mCorrectanswer)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!= mSelectedOptionPosition){
                        answerview(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectanswer++
                    }
                    answerview(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if(mCurrentPosition==mQuestionList!!.size){
                        btnSumbit?.text= "FINISH"
                    }
                    else{
                        btnSumbit?.text= "GOTO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }

        }
    }
    private fun answerview(answer:Int , drawableView: Int){
        when(answer){
            1->{
                tvOption1?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2->{
                tvOption2?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3->{
                tvOption3?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4->{
                tvOption4?.background = ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }
}
package com.kjy.quizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

// AppCompat 액티비티에서 QuizQuestions 액티비티를 상속받는 동시에 리스너를 구현
// 안에 있는 아이템을 누를 수 있음. 구현 가능.
class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null      // OnCreate 메소드를 벗어나서 사용불가
    private var mSelectedOptionPosition: Int = 0


    // 필요한 아이템 가져오기
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null

    private var tvOptionOne: TextView? = null
    private var tvOptionTwo: TextView? = null
    private var tvOptionThree: TextView? = null
    private var tvOptionFour: TextView? = null
    private var btnSubmit: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)


        // findViewByid로 연동하기
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tvOptionOne = findViewById(R.id.tv_option_one)
        tvOptionTwo = findViewById(R.id.tv_option_two)
        tvOptionThree = findViewById(R.id.tv_option_three)
        tvOptionFour = findViewById(R.id.tv_option_four)
        btnSubmit = findViewById(R.id.btn_submit)


        // 일일이 리스너를 구현하면 너무 많은 코드가 생기기 때문에 this를 사용.
        // nullable이기 때문에 ?
        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        mQuestionList = Constants.getQuestions()


        setQuestion()
        defaultOptionsView()
    }

    private fun setQuestion() {

        // mQuestionList가 nullable인데 변수가 지워지지 않을 것이기 때문에 !! 표시
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        // 프로그래스바 수치 구현(프로그래스바 옆 작은 텍스트뷰)
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour


        // 문제가 마지막에 도달했을 때는 FINISH 나머지는 제출버튼
        if(mCurrentPosition == mQuestionList!!.size) {
            btnSubmit?.text = "FINISH"
        }else {
            btnSubmit?.text = "SUBMIT"
        }
    }


    // 기본설정 기능 뷰
    private fun defaultOptionsView() {
        // 각 옵션에 해당하는 텍스트뷰
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)          // it = 실제 텍스트뷰
        }

        tvOptionTwo?.let {
            options.add(1, it)
        }

        tvOptionThree?.let {
            options.add(2, it)
        }

        tvOptionFour?.let {
            options.add(3, it)
        }

        for(option in options) {
            // 기본 컬러 지정
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )

        }
    }

    // 클릭했을 때 상태를 지정하는 메서드
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()            // 모든 버튼을 기본으로 돌아가게함.

        // 선택한 옵션의 위치
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    // 정답 클릭시 이벤트를 구현하는 메서드
    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.tv_option_one -> {
                tvOptionOne?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_option_two -> {
                tvOptionTwo?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_option_three -> {
                tvOptionThree?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_option_four -> {
                tvOptionFour?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btn_submit -> {
                // TODO "Implement btn submit"
            }
        }
    }
}
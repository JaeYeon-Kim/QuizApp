package com.kjy.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart: Button = findViewById(R.id.btn_start)
        val etName: EditText = findViewById(R.id.et_name)
        btnStart.setOnClickListener {

            // 이름적는 칸이 비어 있다면 텍스트를 입력하고
            // 비어있지 않다면 다음 화면으로 넘어감
            if(etName.text.isEmpty()) {
                // 이름을 입력해달라는 토스트 메시지
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                // intent로 추가적인 정보값을 한 액티비티에서 다른 액티비티로 보냄.
                // 문자열을 가지고 와야하기 때문에 toString()
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent)
                finish()
            }

        }


    }
}
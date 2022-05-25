package com.kjy.quizapp


// 질문에 사용할 매개변수 정의
data class Question(
    // 어떤 질문인지
    val id: Int,
    val question: String,
    val image: Int,             // 안드로이드 에서는 integer 속성으로 이미지를 가져옴
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFour: String,
    val correctAnswer: Int          // 정답 속성: index를 포함.  ex) 인덱스가 0이면 1번, 1이면 2번

)

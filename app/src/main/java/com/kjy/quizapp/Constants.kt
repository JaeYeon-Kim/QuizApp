package com.kjy.quizapp

// 앞으로 만들 정수를 전부 저장.
// 사용자 이름, 퀴즈에 사용할 질문, 정답
object Constants {

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        // question에 필요한 세부사항 입력
        val que1 = Question(
            // 첫번째 id = 1
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia", "Armenia", "Austria",
            1
        )
        questionsList.add(que1)

        // question에 필요한 세부사항 입력
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina", "Belgium", "South Korea", "Austria",
            2
        )
        questionsList.add(que2)

        // question에 필요한 세부사항 입력
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "NewZealand", "Australia", "Denmark", "China",
            3
        )
        questionsList.add(que3)

        // question에 필요한 세부사항 입력
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "kuwait", "Germany", "North Korea", "Austria",
            2
        )
        questionsList.add(que4)

        // question에 필요한 세부사항 입력
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Figi", "India", "Brazil", "Australia",
            1
        )
        questionsList.add(que5)

        // question에 필요한 세부사항 입력
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina", "Republic of South Africa",
            "Armenia", "Brazil",
            4
        )
        questionsList.add(que6)

        // question에 필요한 세부사항 입력
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Indonesia", "Kazakhstan", "India", "Saudi Arabia",
            3
        )
        questionsList.add(que7)

        // question에 필요한 세부사항 입력
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina", "Vietnam", "Kuwait", "Austria",
            3
        )
        questionsList.add(que8)

        // question에 필요한 세부사항 입력
        val que9= Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "NewZealand", "Australia", "Armenia", "Austria",
            1
        )
        questionsList.add(que9)
        return questionsList

    }


}
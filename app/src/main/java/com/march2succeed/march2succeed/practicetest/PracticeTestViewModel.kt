package com.march2succeed.march2succeed.practicetest

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.google.gson.stream.JsonReader
import com.march2succeed.march2succeed.R
import java.io.InputStream
import java.lang.Exception

//ViewModel for General Science Questions
class PracticeTestViewModel : ViewModel() {

    data class Question(
        val question: String,
        val answer: String,
        val choices: List<String>
    )

    var jsonParse: String? = null

    private lateinit var questionList: MutableList<Question>

    //The current section
    var section = MutableLiveData<String>()
    //The current question
    var question = MutableLiveData<String>()
    //The answer for current question
    var answer = MutableLiveData<String>()
    //The current choices
    var choice1 = MutableLiveData<String>()
    var choice2 = MutableLiveData<String>()
    var choice3 = MutableLiveData<String>()
    var choice4 = MutableLiveData<String>()
    //The current score
    var score = MutableLiveData<Int>()



    init {
        Log.i("PracticeTestViewModel", "PracticeTestVewModel created.")
        resetQuestionList()
        nextQuestion()

        section.value = "General Science"
        /*
        question.value = questionList[0].question
        answer.value = questionList[0].answer
        choice1.value = questionList[0].choices[0]
        choice2.value = questionList[0].choices[1]
        choice3.value = questionList[0].choices[2]
        choice4.value = questionList[0].choices[3]
        */

        score.value = 0

    }
    override fun onCleared(){
        super.onCleared()
        Log.i("PracticeTestViewModel", "PracticeTestViewModel destroyed.")
    }

    fun resetQuestionList(){
        questionList = createQuestions()
        questionList.shuffle()
    }

    fun nextQuestion(){
        question.value = questionList[0].question
        answer.value = questionList[0].answer
        choice1.value = questionList[0].choices[0]
        choice2.value = questionList[0].choices[1]
        choice3.value = questionList[0].choices[2]
        choice4.value = questionList[0].choices[3]
        questionList.removeAt(0)
    }

    //The test questions - this could be put in JSON file and parsed (ton of boilerplate code currently...), will do this perhaps at a later time to incorporate more questions
    private fun createQuestions(): MutableList<Question> {
        val question1 = Question(
            "Which of these reduces friction?",
            "ball bearings",
            listOf("tire tread", "sandpaper", "ball bearings", "car brakes")
        )
        val question2= Question(
            "Which of these undergoes metamorphosis",
            "butterfly",
            listOf("butterfly", "bacteria", "snake", "chicken")
        )
        val question3= Question(
            "Which of these is the best explanation of how a smooth round stone became smooth?",
            "It was in a stream for a long time",
            listOf(
                "continuous freezing and thawing",
                "volcanic action",
                "It fell off the side of a cliff.",
                "It was in a stream for a long time."
            )
        )
        val question4 = Question(
            "Mollusks typically have",
            "shells",
            listOf("wings", "shells", "scales", "backbones")
        )
        val question5 = Question(
            "Weight is a measure of a body’s",
            "gravitational attraction to the Earth",
            listOf(
                "energy",
                "momentum",
                "rotational equilibrium",
                "gravitational attraction to the Earth"
            )
        )
        val question6 = Question(
            "Which of these systems enable oxygen to reach an individual cell in the human body?",
            "circulatory",
            listOf("digestive", "circulatory", "nervous", "excretory")
        )
        val question7 = Question(
            "The changing of any kind of matter from one form to another absorbs or releases",
            "energy",
            listOf("dust", "inertia", "gravity", "energy")
        )
        val question8 = Question(
            "Citrus fruits include",
            "oranges",
            listOf("apples", "oranges", "bananas", "peaches")
        )
        val question9 = Question(
            "An example of kinetic energy is a ",
            "pendulum swinging in a grandfather clock",
            listOf(
                "car sitting up on blocks",
                "flag hanging on a flagpole",
                "pillow leaning against the back of a chair",
                "pendulum swinging in a grandfather clock"
            )
        )
        val question10 = Question(
            "Which of the following can be spread from one person to another?",
            "hepatitis",
            listOf("allergy", "arthritis", "hepatitis", "epilepsy")
        )
        val question11 = Question(
            "Which of the following is NOT a part of an atom?",
            "molecule",
            listOf("neutron", "molecule", "electron", "proton")
        )
        val question12 =
            Question("The pancreas is a", "gland", listOf("cell", "gland", "cancer", "catalyst"))
        val question13 = Question(
            "Why do we see different areas of the sky during the Fall versus the Spring?",
            "Earth’s tilt and its orbiting around the Sun",
            listOf(
                "the Moon blocking part of the sky",
                "the daily rotation of Earth",
                "Earth’s tilt and its orbiting around the Sun",
                "stars’ extremely rapid motion in space"
            )
        )
        val question14 = Question(
            "Marrow is a soft tissue found in the",
            "bones",
            listOf("brain", "bones", "muscles", "ligaments")
        )
        val question15 = Question(
            "Water droplets forming on the inside of a cold windshield is an example of",
            "condensation",
            listOf("evaporation", "conduction", "vaporization", "condensation")
        )
        return mutableListOf(question1,question2, question3, question4, question5, question6, question7, question8, question9, question10, question11, question12, question13, question14, question15)
    }
}



/*
private fun loadJson(context: Context): String?{
    var input: InputStream? = null
    var jsonString: String
    //var jsonElement1: JsonElement

    try{
        //Create InputStream
        input = context.resources?.openRawResource(R.raw.science_questions)
        val size = input!!.available()

        //Create buffer with the size
        val buffer = ByteArray(size)

        //Read data from InputStream into the buffer
        input.read(buffer)

        //Create a JSON String
        jsonString = String(buffer)

        return jsonString
        //Log.d("loadJson", "loadJson parsed!")
    } catch (ex: Exception){
        ex.printStackTrace()
    } finally {
        input?.close()
    }
    return null
}
*/

/*
private fun parseJson(reader: JsonReader): List<PracticeTestViewModel.Question>{
    val result = mutableListOf<PracticeTestViewModel.Question>()

    reader.beginArray()
    while (reader.hasNext()) {
        var question: String = ""
        var answer: String = ""


        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "question" -> question = reader.nextString()
                "answer" -> answer = reader.nextString()
                else -> reader.skipValue()
            }
        }
        reader.endObject()

        if (question == "" || answer == ""){
            throw Exception("Missing required field")
        }
    }
    reader.endArray()
    return result
}
fun changeQuestion(question: MutableLiveData<String>, question2: PracticeTestViewModel.Question){
    Log.d("PracticeTestViewMode", "changeQuestion has updated the question")
    question.value = question2.question

}
*/
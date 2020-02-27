package com.march2succeed.march2succeed.practicetest

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.march2succeed.march2succeed.R
import com.march2succeed.march2succeed.databinding.FragmentGeneralScienceQuestionsBinding
import kotlinx.android.synthetic.main.fragment_general_science_questions.*
import java.io.InputStream
import java.lang.Exception


class GeneralScienceQuestionsFragment : Fragment() {

    private lateinit var viewModel: PracticeTestViewModel

    //private val mContext: Context? = it.context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGeneralScienceQuestionsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_general_science_questions, container, false
        )
        binding.scienceSubmitBtn.setOnClickListener { view: View ->
            viewModel.nextQuestion()
            binding.radioGroup.clearCheck()
            binding.scienceSubmitBtn.visibility = View.INVISIBLE
        }

        binding.radioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { radio_group, i ->
                science_submit_btn.visibility = View.VISIBLE
            })

        viewModel = ViewModelProvider(this).get(PracticeTestViewModel::class.java)


        //Update the UI with LiveData
        viewModel.question.observe(this, Observer { newQuestion ->
            binding.questionText.text = newQuestion.toString()
        })

        viewModel.choice1.observe(this, Observer { newChoice ->
            binding.radioAnswer1.text = newChoice.toString()
        })

        viewModel.choice2.observe(this, Observer { newChoice ->
            binding.radioAnswer2.text = newChoice.toString()
        })

        viewModel.choice3.observe(this, Observer { newChoice ->
            binding.radioAnswer3.text = newChoice.toString()
        })

        viewModel.choice4.observe(this, Observer { newChoice ->
            binding.radioAnswer4.text = newChoice.toString()
        })

        viewModel.section.observe(this, Observer { newChoice ->
            binding.sectionText.text = newChoice.toString()
        })


        //viewModel.jsonParse = loadJson(activity!!.applicationContext)
        //println(viewModel.jsonParse.toString())
        /*
        binding.scienceSubmitBtn.setOnClickListener { view: View ->
            val radioId = binding.radioGroup.getCheckedRadioButtonId()
            if( radioId ==  binding.radioAnswer3.id) {
                val currentScore = viewModel.score.value
                viewModel.score = (currentScore + 1).toInt()
                Log.d("GeneralScienceQuestions", "The answer was right!")
            }
            else Log.d("GeneralScienceQuestions", "The answer was wrong!")
        }
        */
        return binding.root
    }
}
/*
private fun loadJson(context: Context): String?{
    var input: InputStream? = null
    var jsonString: String
    //var jsonElement1: JsonElement

    try{
        //Create InputStream
        input = context.resources.openRawResource(R.raw.science_questions)
        val size = input.available()

        //Create buffer with the size
        val buffer = ByteArray(size)

        //Read data from InputStream into the buffer
        input.read(buffer)

        //Create a JSON String
        jsonString = String(buffer)
        Log.d("GeneralScienceQuestions", "loadJson worked")
        return jsonString
    } catch (ex: Exception){
        Log.d("GeneralScienceQuestions", "loadJson failed")
        ex.printStackTrace()
    } finally {
        input?.close()
    }
    return null
}
*/
/*
private fun loadJson(context: Context): JSONObject?{
    var jsonText: String
    var tokener: JSONTokener

    try{
        jsonText = context.resources.openRawResource(R.raw.science_questions).bufferedReader().use{
            it.readText() }

        tokener = JSONTokener(jsonText)

        return JSONObject(tokener)
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
    return null
}
*/
/*
private fun loadJson(): JsonObject?{

    var parser = JSONParser()

    try{
        parser.parse(FileReader("res/raw/science_questions.json"))

    } catch (ex: Exception){
        ex.printStackTrace()
    }
    return null
}
 */

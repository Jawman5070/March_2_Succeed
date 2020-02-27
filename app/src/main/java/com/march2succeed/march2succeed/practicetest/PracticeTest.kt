package com.march2succeed.march2succeed.practicetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.march2succeed.march2succeed.R
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.gson.JsonObject
import com.google.gson.stream.JsonReader
import kotlinx.android.synthetic.main.fragment_general_science_questions.*
import org.json.JSONObject
import org.json.JSONTokener
import java.io.ByteArrayInputStream
import java.io.FileReader
import java.io.InputStream
import java.lang.Exception

//import com.march2succeed.march2succeed.databinding.FragmentPrePracticeTestBinding

class PracticeTest : AppCompatActivity() {

    private lateinit var viewModel: PracticeTestViewModel

    var jsonString: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice_test)

        viewModel = ViewModelProvider(this).get(PracticeTestViewModel::class.java)

        //viewModel.jsonQuestion = loadJson(applicationContext)


        //val binding = DataBindingUtil.setContentView<FragmentPrePracticeTestBinding>(this, R.layout.activity_practice_test)
        //setContentView(R.layout.activity_practice_test)
    }
}
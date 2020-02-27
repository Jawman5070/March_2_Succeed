package com.march2succeed.march2succeed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.march2succeed.march2succeed.lessons.Lessons
import com.march2succeed.march2succeed.practicetest.PracticeTest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Link buttons with ids
        val lessonsButton: Button = findViewById(R.id.lessons_btn)
        val practiceTestButton: Button = findViewById(R.id.practice_test_btn)

        //set onClickListeners for buttons
        lessonsButton.setOnClickListener{
            intent = Intent(this, Lessons::class.java)
            startActivity(intent)
        }
        practiceTestButton.setOnClickListener{
            intent = Intent(this,
                PracticeTest::class.java)
            startActivity(intent)
        }
    }
}

package com.timplesoft.appofthrones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btnTest: Button = findViewById(R.id.btnTest)
        btnTest.setOnClickListener {
            Toast.makeText(this@DetailActivity, "Winter is coming!", Toast.LENGTH_SHORT).show()
        }
    }

}

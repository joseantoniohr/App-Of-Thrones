package com.timplesoft.appofthrones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getStringExtra("key_id")
        val character = CharactersRepo.findCharacterById(id)

        val btnTest: Button = findViewById(R.id.btnTest)
        btnTest.setOnClickListener {
            Toast.makeText(this@DetailActivity, character?.house?.words, Toast.LENGTH_SHORT).show()
        }

        character?.let { 
            with ( character ) {
                labelName.text = name
                labelTitle.text = title
                labelActor.text = actor
                labelBorn.text = born
                labelParents.text = "${father} & ${mother}"
                labelQuote.text = quote
                labelSpouse.text = spouse
                btnTest.text = house.name
            }
        }
    }

}

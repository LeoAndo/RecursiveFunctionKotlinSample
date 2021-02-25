package com.template.recursivefunctionkotlinsample

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewUtil.setOnClickListenerForToggleButton(findViewById(R.id.content)) { view ->
            if (view !is TextView) return@setOnClickListenerForToggleButton
            Toast.makeText(this@MainActivity, "${view.text}", Toast.LENGTH_SHORT).show()
        }
    }
}
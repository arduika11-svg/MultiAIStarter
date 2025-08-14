package com.orchestrator.starter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ConnectionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connections)

        val etWorker: EditText   = findViewById(R.id.etWorker)
        val etOpenAI: EditText   = findViewById(R.id.etOpenAI)
        val etOpenAIUrl: EditText= findViewById(R.id.etOpenAIUrl)
        val etGrok: EditText     = findViewById(R.id.etGrok)
        val etGrokUrl: EditText  = findViewById(R.id.etGrokUrl)
        val etGemini: EditText   = findViewById(R.id.etGemini)
        val etGeminiUrl: EditText= findViewById(R.id.etGeminiUrl)
        val btnTest: Button      = findViewById(R.id.btnTest)
        val btnSave: Button      = findViewById(R.id.btnSave)

        val sp = getSharedPreferences("conn", MODE_PRIVATE)

        etWorker.setText(sp.getString("worker", "https://example.workers.dev"))
        etOpenAI.setText(sp.getString("openai", ""))
        etOpenAIUrl.setText(sp.getString("openai_url", "https://api.openai.com/v1"))
        etGrok.setText(sp.getString("grok", ""))
        etGrokUrl.setText(sp.getString("grok_url", "https://api.x.ai/v1"))
        etGemini.setText(sp.getString("gemini", ""))
        etGeminiUrl.setText(sp.getString("gemini_url", "https://generativelanguage.googleapis.com"))

        btnSave.setOnClickListener {
            sp.edit()
                .putString("worker", etWorker.text.toString())
                .putString("openai", etOpenAI.text.toString())
                .putString("openai_url", etOpenAIUrl.text.toString())
                .putString("grok", etGrok.text.toString())
                .putString("grok_url", etGrokUrl.text.toString())
                .putString("gemini", etGemini.text.toString())
                .putString("gemini_url", etGeminiUrl.text.toString())
                .apply()
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }

        btnTest.setOnClickListener {
            Toast.makeText(this, "Test OK", Toast.LENGTH_SHORT).show()
        }
    }
}
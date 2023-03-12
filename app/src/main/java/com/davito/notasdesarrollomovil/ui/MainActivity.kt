package com.davito.notasdesarrollomovil.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davito.notasdesarrollomovil.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val df = DecimalFormat("#.##")

        binding.calcularButton.setOnClickListener {
            if (!(binding.nota60EditText.text.isNullOrEmpty() || binding.nota7EditText.text.isNullOrEmpty() || binding.nota8EditText.text.isNullOrEmpty() || binding.notaFinalEditText.text.isNullOrEmpty())){
                val nota60 = binding.nota60EditText.text.toString().toDouble()
                val nota7 = binding.nota7EditText.text.toString().toDouble()
                val nota8 = binding.nota8EditText.text.toString().toDouble()
                val notaFinal = binding.notaFinalEditText.text.toString().toDouble()
                val resultado = df.format((nota60*0.60)+(nota7*0.07)+(nota8*0.08)+(notaFinal*0.25))
                binding.textView2.text=resultado.toString()
            } else {
                binding.textView2.text=""
            }

        }
    }
}
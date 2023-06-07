package com.davito.notasdesarrollomovil.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.davito.notasdesarrollomovil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val view = binding.root
        setContentView(view)

        viewModel.errorMsg.observe(this) {
            Toast.makeText(applicationContext, "debe digitar todos los datos", Toast.LENGTH_LONG)
                .show()
        }
        viewModel.Msg.observe(this) {
            binding.textView2.text = buildString {
                append("la nota final es: ")
                append(it)
            }
        }

        binding.calcularButton.setOnClickListener {

            viewModel.validateData(
                binding.nota60EditText.text.toString(),
                binding.nota7EditText.text.toString(),
                binding.nota8EditText.text.toString(),
                binding.notaFinalEditText.text.toString()
            )
        }
    }
}
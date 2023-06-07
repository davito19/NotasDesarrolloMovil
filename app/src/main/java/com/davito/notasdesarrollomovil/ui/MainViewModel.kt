package com.davito.notasdesarrollomovil.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class MainViewModel : ViewModel() {

    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String> = _errorMsg

    private val _Msg: MutableLiveData<String> = MutableLiveData()
    val Msg: LiveData<String> = _Msg

    fun validateData(nota1: String, nota2: String, nota3: String, nota4: String) {
        val df = DecimalFormat("#.##")
        if (nota1.isEmpty() || nota2.isEmpty() || nota3.isEmpty() || nota4.isEmpty()) {
            _errorMsg.value = "debe digitar todos los campos"
        } else {
            val resultado =
                df.format((nota1.toDouble() * 0.60) + (nota2.toDouble() * 0.07) + (nota3.toDouble() * 0.08) + (nota4.toDouble() * 0.25))
            _Msg.value = resultado.toString()
        }
    }
}
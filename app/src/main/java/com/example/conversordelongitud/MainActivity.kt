package com.example.conversordelongitud

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversordelongitud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKm.setOnClickListener {
            convertirMetros("km")
        }

        binding.btnCm.setOnClickListener {
            convertirMetros("cm")
        }

        binding.btnMm.setOnClickListener {
            convertirMetros("mm")
        }
    }

    private fun convertirMetros(unidad: String) {
        val metrosStr = binding.etMetros.text.toString()
        if (metrosStr.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese un valor en metros", Toast.LENGTH_SHORT).show()
            return
        }

        val metros = metrosStr.toDouble()
        val resultado = when (unidad) {
            "km" -> metros / 1000
            "cm" -> metros * 100
            "mm" -> metros * 1000
            else -> 0.0
        }

        val resultadoTexto = when (unidad) {
            "km" -> "$metros metros son $resultado kilómetros"
            "cm" -> "$metros metros son $resultado centímetros"
            "mm" -> "$metros metros son $resultado milímetros"
            else -> ""
        }

        binding.tvResultado.text = resultadoTexto
    }
}

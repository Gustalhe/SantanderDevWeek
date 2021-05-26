package com.Gustavo.santander

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bt1 = findViewById<Button>(R.id.botao1)

        bt1.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        var caixaTexto = findViewById<EditText>(R.id.cxTexto)
        val texto = caixaTexto.text.toString();

        var mostraTx = findViewById<TextView>(R.id.texto)

        mostraTx.text = texto

    }

}

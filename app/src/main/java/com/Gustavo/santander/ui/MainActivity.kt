package com.Gustavo.santander.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.Gustavo.santander.R
import com.Gustavo.santander.data.Conta

class MainActivity : AppCompatActivity(){

    //carrega ele de forma atrasada(no futuro)
    private lateinit var mainViewModel: MainViewModel

    //Usado MVVM e LiveData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayShowTitleEnabled(false)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }
    private fun buscarContaCliente(){
        //verificar se os dados estão chegando até a activity em questão e buscar os mesmos da classe MainViewModel
        mainViewModel.buscarContaCliente().observe(this, Observer {
                result -> bindOnView(result)})
    }


    private  fun bindOnView(conta : Conta){

            findViewById<TextView>(R.id.tv_conta_corrente).text = conta.numero
            findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
            findViewById<TextView>(R.id.tv_numero_agencia).text = conta.agencia
            findViewById<TextView>(R.id.tv_saldoElimite).text = conta.limite
            findViewById<TextView>(R.id.name_usuario).text = conta.cliente.nome
            findViewById<TextView>(R.id.tv_cartao_final_value).text = conta.cartao.numeroCartao
    }

    //para inflar(mostrar) as opções do menu na tela
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)

        return true
    }

    //Esse método vai meio que escutar do menu, para executar tal ação (gerencia cliks)
     override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_1 -> {
                Log.d("CLICK","Click no item 1")
                //abrir activity do menu 1
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }

}

package com.Gustavo.santander.local

import com.Gustavo.santander.data.Cartao
import com.Gustavo.santander.data.Cliente
import com.Gustavo.santander.data.Conta

class FakeData{

    fun getLocalData() : Conta {
        val cliente = Cliente("Gustavo")
        val cartao = Cartao("436541259856")

        return Conta("0549782-9",
                "6552-4",
                "R$: 3.486,00",
                "R$: 7.120,00",
                cliente,
                cartao);
    }


}
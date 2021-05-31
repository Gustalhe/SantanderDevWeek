package com.Gustavo.santander.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.Gustavo.santander.data.Conta
import com.Gustavo.santander.local.FakeData

class MainViewModel : ViewModel(){

    //LiveData = só repassa dados
    //live data mutavel
    //Tem a responsavilidade de setar um valor
    private val mutableLiveData : MutableLiveData<Conta> = MutableLiveData()

    //busca os dados com o LiveData da classe/tipo Conta
    fun buscarContaCliente() : LiveData<Conta>{

        mutableLiveData.value = FakeData().getLocalData()

        return mutableLiveData
    }

}
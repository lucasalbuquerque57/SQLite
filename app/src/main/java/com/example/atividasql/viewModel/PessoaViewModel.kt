package com.example.atividasql.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.atividasql.roomDB.Pessoa
import kotlinx.coroutines.launch

class PessoaViewModel(private val repository : Repository):ViewModel() {

    fun upsertPessoa(pessoa: Pessoa){
        viewModelScope.launch {
            repository.upsertPessoa(pessoa)
        }
    }

    fun getPessoa() = repository.getAllPessoas().asLiveData(viewModelScope.coroutineContext)

    fun deletePessoa(pessoa : Pessoa) {
        viewModelScope.launch {
            repository.deletePessoa(pessoa)
        }
    }

}

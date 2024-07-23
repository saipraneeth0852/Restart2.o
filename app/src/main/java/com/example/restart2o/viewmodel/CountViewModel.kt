package com.example.restart2o.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {

    private var mutableCount = MutableLiveData<Int>()

    fun getMutableCount() : LiveData<Int>{
        return mutableCount
    }

    init {
        mutableCount.value = 0
    }

    fun increment(){
        mutableCount.value = mutableCount.value!! + 1
    }

    fun decrement(){
        mutableCount.value = mutableCount.value!! - 1
    }
}

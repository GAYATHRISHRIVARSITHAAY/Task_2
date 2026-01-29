package com.example.task_2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DigitcodeViewModel : ViewModel() {
    private val _conformStatus = MutableLiveData<String>()
    val conformStatus: LiveData<String> = _conformStatus
    private val _cancelStatus = MutableLiveData<String>()
    val cancelStatus: LiveData<String> = _cancelStatus
    private val _navigateBack = MutableLiveData<Boolean>()
    val navigateBack: LiveData<Boolean> = _navigateBack
    fun conform(n1: String, n2: String, n3: String, n4: String) {
        if (n1.isEmpty() || n2.isEmpty() || n3.isEmpty() || n4.isEmpty()) {
            _conformStatus.value = "Pin value should be entered"
        } else {
            _conformStatus.value = "Submitted successfully"
        }
    }
    fun cancel() {
        _cancelStatus.value = "Canceled"
        _navigateBack.value = true
    }

}

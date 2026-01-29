package com.example.task_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ForgotPasswordViewModel : ViewModel() {
    private val _msg = MutableLiveData<String>()
    val msg: LiveData<String> = _msg
    private val _navigateNext = MutableLiveData<Boolean>()
    val navigateNext: LiveData<Boolean> = _navigateNext
    fun conti(mail:String) {
        if(mail.isEmpty()){
            _msg.value="Email must be filled"
        }
        else if(!mail.contains("@"))
        {
            _msg.value="Invalid email"
        }
        else{
            _navigateNext.value=true
        }
    }

}

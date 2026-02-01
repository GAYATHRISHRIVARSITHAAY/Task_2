package com.example.task_2.forgot_password

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
            _msg.value="no mail"
        }
        else if(!mail.contains("@"))
        {
            _msg.value="invalid"
        }
        else{
            _navigateNext.value=true
        }
    }
    fun next(){
        _navigateNext.value=false
    }

}
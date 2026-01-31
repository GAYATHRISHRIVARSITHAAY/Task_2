package com.example.task_2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    private val _signUpStatus = MutableLiveData<String>()
    val signUpStatus: LiveData<String> = _signUpStatus

    fun signUp(
        name: String,
        email: String,
        password: String,
        isChecked: Boolean
    ) {
        if(name.isEmpty())
        {
            _signUpStatus.value="no name"
        }
        else if(email.isEmpty()){
            _signUpStatus.value="no mail"
        }
        else if(password.isEmpty()){
            _signUpStatus.value="no password"
        }
        else if(!isChecked)
        {
            _signUpStatus.value="no check"
        }
        else if(!email.contains("@"))
        {
            _signUpStatus.value="invalid mail"
        }
        else if(password.length<5){
            _signUpStatus.value="short"
        }
        else{
            _signUpStatus.value="Signed up successfully!!"
        }

    }
}

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
        if(name.isEmpty() ||email.isEmpty() || password.isEmpty()){
            _signUpStatus.value="Fields should not be empty"
        }
        else if(!email.contains("@"))
        {
            _signUpStatus.value="Invalid Email"
        }
        else if(password.length<5){
            _signUpStatus.value="Password must be minimum of 6 characters"
        }
        else if(!isChecked)
        {
            _signUpStatus.value="Tick the check box"
        }
        else{
            _signUpStatus.value="Signed up successfully!!"
        }

    }
}

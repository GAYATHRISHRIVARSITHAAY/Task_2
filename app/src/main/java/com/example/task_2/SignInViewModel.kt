package com.example.task_2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {

    private val _signInStatus = MutableLiveData<String>()
    val signInStatus: LiveData<String> = _signInStatus
    private val _forgotStatus=MutableLiveData<Boolean>()
    val forgotStatus: LiveData<Boolean> = _forgotStatus
    fun forgot(){
        _forgotStatus.value=true
    }
    fun signin(mail:String,password:String){
        if(mail.isEmpty() || password.isEmpty())
        {
            _signInStatus.value="Fields must be filled"

        }
        else if(!mail.contains("@"))
        {
            _signInStatus.value="Invalid email"
        }
        else if(mail.equals("user@gmail.com") && password.equals("userpassword"))
        {
            _signInStatus.value="Signed in successful"
        }
        else{
            _signInStatus.value="Email or password is incorrect"

        }

    }
}

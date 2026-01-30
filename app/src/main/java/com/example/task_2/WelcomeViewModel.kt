package com.example.task_2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    private val _navigateToSignIn = MutableLiveData<Boolean>()
    val navigateToSignIn: LiveData<Boolean> = _navigateToSignIn

    private val _navigateToSignUp = MutableLiveData<Boolean>()
    val navigateToSignUp: LiveData<Boolean> = _navigateToSignUp
    fun onSignInClicked() {
        _navigateToSignIn.value = true
    }

    fun onCreateAccountClicked() {
        _navigateToSignUp.value = true
    }
    fun onNavigationDone() {
        _navigateToSignIn.value = false
        _navigateToSignUp.value = false
    }
}

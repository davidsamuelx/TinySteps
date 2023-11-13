package com.aa.tinysteps.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import com.aa.models.UserSignUpAuth
import com.aa.ui.main.TinyStepsApp
import com.aa.usecase.LoginUseCase
import com.aa.usecase.SignupUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var signupUseCase: SignupUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TinyStepsApp()
            }
        }
    }



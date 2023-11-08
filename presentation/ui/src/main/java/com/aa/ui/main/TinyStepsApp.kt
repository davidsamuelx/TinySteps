package com.aa.ui.main

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.aa.ui.theme.TinyStepsTheme


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TinyStepsApp(){
    TinyStepsTheme {
        Scaffold {
            val navController = rememberNavController()
        }
    }
}
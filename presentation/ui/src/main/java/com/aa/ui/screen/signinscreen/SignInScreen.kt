package com.aa.ui.screen.signinscreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.ui.R
import com.aa.ui.navigation.TinyStepsDestination
import com.aa.ui.screen.composable.AppBar
import com.aa.ui.screen.composable.AuthCard
import com.aa.ui.screen.composable.HorizontalSpacer
import com.aa.ui.screen.composable.NextButton
import com.aa.ui.screen.composable.PassCard
import com.aa.ui.screen.composable.VerticalSpacer
import com.aa.ui.screen.signUp.navigateToSignUpScreen
import com.aa.ui.screen.signinscreen.composable.ForgetText
import com.aa.ui.theme.BackgroundOrangeColor
import com.aa.ui.theme.SecondHintTextColor
import com.aa.ui.theme.space24
import com.aa.ui.theme.space48
import com.aa.ui.theme.space62
import com.aa.viewmodel.signin.LoginUIEffect
import com.aa.viewmodel.signin.SignInUiState
import com.aa.viewmodel.signin.SignInViewModel

@Composable
fun  SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel()

){
        val state by viewModel.state.collectAsState()
        val effect by viewModel.effect.collectAsState(null)

    var errorMessage: String? = null

    when(effect){
        is LoginUIEffect.LoginSuccess -> {
            navController.navigate(TinyStepsDestination.StateScreen)
        }

        is LoginUIEffect.LoginFailed -> {
            Log.e(
                "SignInScreen",
                "Error: ${(effect as LoginUIEffect.LoginFailed).errorMessage?.errorCode}"
            )
            errorMessage = (effect as LoginUIEffect.LoginFailed).errorMessage?.errorCode

        }

        else -> {}
    }

    SignInContent(
            onClickBack = navController::backToIntroScreen,
            onClick = navController::navigateToSignUpScreen,
            onClickNext =navController::backToIntroScreen ,
            state =state,
            errorMessage = errorMessage,

            onChangeEmail = viewModel::onChangedEmail,
            onChangePassword = viewModel::onChangedPassword,
            onDeleteEmail = viewModel::onDeleteEmail,
            onDeletePassword = viewModel::onDeletePassword,
            onClickSave = {viewModel.login(state.name,state.password)}
        )
}



@Composable
private fun SignInContent(
    onClickBack: () ->Unit={},
    onClick: () -> Unit,
    onClickSave:()->Unit,
    onClickNext:()->Unit,
    state: SignInUiState,
    errorMessage: String?,
    onChangeEmail:(String)->Unit,
    onChangePassword:(String)->Unit,
    onDeleteEmail:()->Unit,
    onDeletePassword:()->Unit


) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    )
    {
        AppBar(
            onClick = onClickBack,
            titleAppBar = stringResource(R.string.continue_with_e_mail),
            backPainter = painterResource(id = R.drawable.left_icon)
        )


        AuthCard(
            title = stringResource(R.string.e_mail),
            email = state.name,
            onTextChanged = {
                onChangeEmail(it)
            },
            onTextDelete = onDeleteEmail,
            error = if (!state.isUserNameValid) state.userNameError.toString() else null
        )

        PassCard(
            title = stringResource(R.string.password),
            email = state.password,
            onTextChanged = {
                onChangePassword(it)
            },
            onTextDelete = onDeletePassword,
            error = if (!state.isPasswordValid) state.passwordError.toString() else null
        )

        ForgetText(
            stringResource(R.string.i_forgot_my_password),
            TextAlign.Start,
            SecondHintTextColor,
            onClick = {}

        )
        if (!errorMessage.isNullOrBlank()) {
            Snackbar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                action = {
                    // You can add an action here, e.g., to dismiss the Snackbar
                    // onClickDismiss
                }
            ) {
                if (errorMessage == "Unauthorized") {
                    Text(
                        text = "Invalid password or email",
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    )
                }
                if (errorMessage == "null") {
                            Text(
                                text = "write a correct password or username",
                                color = Color.White,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )


                    }
                }
            }



        VerticalSpacer(space = space48)
        Row(
        ) {
            HorizontalSpacer(space = space62)
            ForgetText(
                stringResource(R.string.don_t_have_account_let_s_create),
                TextAlign.Center,
                BackgroundOrangeColor,
                onClick = onClick
            )
        }
        Row(
        ) {
            HorizontalSpacer(space = space24)
            NextButton(
                stringResource(R.string.next),
                onClickSave,
                onClickNext

            )

        }


    }

}



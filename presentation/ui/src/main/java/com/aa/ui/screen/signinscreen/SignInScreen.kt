package com.aa.ui.screen.signinscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.viewmodel.signin.SignInViewModel
import com.aa.viewmodel.signin.SignInUiState
import com.aa.ui.R
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

@Composable
fun  SignInScreen(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel()

){
        val state by viewModel.state.collectAsState()
        SignInContent(
            onClickBack = navController::backToIntroScreen,
            onClick = navController::navigateToSignUpScreen
            ,
            state =state,
            onChangeEmail = viewModel::onChangedEmail,
            onChangePassword = viewModel::onChangedPassword,
            onDeleteEmail = viewModel::onDeleteEmail,
            onDeletePassword = viewModel::onDeletePassword
        )
}



@Composable
private fun SignInContent(
    onClickBack: () ->Unit={},
    onClick: () -> Unit,
    state: SignInUiState,
    onChangeEmail:(String)->Unit,
    onChangePassword:(String)->Unit,
    onDeleteEmail:()->Unit,
    onDeletePassword:()->Unit


) {
    Column(

        modifier= Modifier
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
            email = state.email,
            onTextChanged = onChangeEmail,
            onTextDelete = onDeleteEmail,
        )
        PassCard(
            title = stringResource(R.string.password),
            email = state.password,
            onTextChanged = onChangePassword,
            onTextDelete = onDeletePassword,
            )
           ForgetText(
               stringResource(R.string.i_forgot_my_password),
               TextAlign.Start,
               SecondHintTextColor,
               onClick={}

               )
        VerticalSpacer(space = space48)
        Row(
        ){
            HorizontalSpacer(space = space62)
            ForgetText(
                stringResource(R.string.don_t_have_account_let_s_create),
                TextAlign.Center,
                BackgroundOrangeColor,
                onClick=onClick
            )
        }
        Row(
        ) {
            HorizontalSpacer(space = space24)
            NextButton(
                stringResource(R.string.next)
                ,
                onClick

            )
        }

    }

}

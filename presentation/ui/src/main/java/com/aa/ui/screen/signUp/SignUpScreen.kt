package com.aa.ui.screen.signUp

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aa.viewmodel.signup.SignUpUiState
import com.aa.viewmodel.signup.SignUpViewModel
import com.aa.ui.R
import com.aa.ui.screen.composable.AppBar
import com.aa.ui.screen.composable.AuthCard
import com.aa.ui.screen.composable.HorizontalSpacer
import com.aa.ui.screen.composable.NextButton
import com.aa.ui.screen.composable.PassCard
import com.aa.ui.theme.space24

@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()

){
    val state by viewModel.state.collectAsState()
    SignUpContent(
        navController::backToSignInScreen,
        //onClickSave = navController::backToSignInScreen,
        onClickSave={viewModel.signUp(state.name,state.email,state.password,state.pregnancyDate)},
        state=state,
        onChangeName =viewModel::onChangedName,
        onChangeSurname=viewModel::onChangedSurname,
        onChangeEmail = viewModel::onChangedEmail,
        onChangePassword = viewModel::onChangedPassword,
        onChangeDate=viewModel::onChangedPregnancyDate,
        onDeleteName=viewModel::onDeleteName,
        onDeleteSurname=viewModel::onDeleteSurname,
        onDeleteEmail = viewModel::onDeleteEmail,
        onDeletePassword = viewModel::onDeletePassword,
        onDeleteDate =viewModel::onDeleteDatePregnancy
    )
}
@Composable
private fun SignUpContent(
    onClickBack: () ->Unit={},
    state: SignUpUiState,
    //onClickNext:()->Unit,
    onClickSave:()->Unit,
    onChangeName:(String)->Unit,
    onChangeSurname:(String)->Unit,
    onChangeEmail:(String)->Unit,
    onChangePassword:(String)->Unit,
    onChangeDate:(String)->Unit,
    onDeleteName:()->Unit,
    onDeleteSurname:()->Unit,
    onDeleteEmail:()->Unit,
    onDeletePassword:()->Unit,
    onDeleteDate:()->Unit
){
    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(Color.White)

    )
    {
        AppBar(
            onClick = onClickBack,
            titleAppBar = stringResource(R.string.create_account),
            backPainter = painterResource(id = R.drawable.left_icon)
        )
        AuthCard(
            title = stringResource(R.string.name),
        email = state.name,
        onTextChanged = onChangeName,
        onTextDelete = onDeleteName,
        )
        AuthCard(
            title = stringResource(R.string.surname),
            email = state.surname,
            onTextChanged = onChangeSurname,
            onTextDelete = onDeleteSurname,
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
        AuthCard(
            title = stringResource(R.string.pregnancy_date),
            email = state.pregnancyDate,
            onTextChanged = onChangeDate,
            onTextDelete = onDeleteDate,
        )
        Row(
        ) {
            HorizontalSpacer(space = space24)
            NextButton(
                stringResource(R.string.next),
                onClickSave,

            )
    }

    }
}

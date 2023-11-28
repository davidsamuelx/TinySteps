package com.aa.ui.screens.phase_1.IntroScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aa.ui.R
import com.aa.ui.screens.phase_1.IntroScreen.composable.AllLogo
import com.aa.ui.screens.phase_1.IntroScreen.composable.ButtonsAuth
import com.aa.ui.screens.phase_1.IntroScreen.composable.ConditionText
import com.aa.ui.screens.phase_1.IntroScreen.composable.Dots
import com.aa.ui.screens.phase_1.IntroScreen.composable.OnlineButtons
import com.aa.ui.screens.phase_1.IntroScreen.composable.TitleText
import com.aa.ui.screens.phase_1.composable.VerticalSpacer
import com.aa.ui.screens.phase_1.signinscreen.navigateToSignInScreen
import com.aa.ui.theme.PrimaryColor
import com.aa.ui.theme.SecondaryColor
import com.aa.ui.theme.space24
import com.aa.ui.theme.space294
import com.aa.ui.theme.space32
import com.aa.ui.theme.space40
import com.aa.ui.theme.space8


@Composable
fun IntroScreen(
    navController: NavController,

){
IntroContent(
onClick =navController::navigateToSignInScreen
)
}
@Composable
private fun IntroContent(
        onClick: () ->Unit={}
) {
    val background= Brush.linearGradient(
        0.0f to PrimaryColor,
        500.0f to  SecondaryColor,

        )
    Box(
        modifier= Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = space40)
        ) {
            Box {
                Dots(painter = painterResource(id = R.drawable.dots))
                Column {
                  VerticalSpacer(space = space40)
                    AllLogo(state= painterResource(id = R.drawable.stats),
                        avatar1 =  painterResource(id = R.drawable.avatar1),
                        avatar2 =  painterResource(id = R.drawable.avatar2),
                        avatar3 =  painterResource(id = R.drawable.avatar3),
                        avatar4 =  painterResource(id = R.drawable.avatar4),
                       gradiant1 = painterResource(id = R.drawable.linear_gradient_03),
                        gradient2 = painterResource(id = R.drawable.linear_gradient_01)

                        )

                   }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = space24)
                    ) {
                        VerticalSpacer(space = space294)
                        TitleText(
                            title = stringResource(R.string.Title) ,
                            subtitle = stringResource(R.string.subtitleIntroScreen)
                        )
                        VerticalSpacer(space = space32)

                        ButtonsAuth(email = "Continue with E-mail",
                            login=painterResource(id =R.drawable.login)
                            ,onClick=onClick
                        )
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Box(modifier = Modifier.weight(1f)) {
                                OnlineButtons(email = "Google",
                                    painterResource(id = R.drawable.google))
                            }
                            Spacer(modifier = Modifier.width(16.dp))
                            Box(modifier = Modifier.weight(1f)) {
                                OnlineButtons(email = "Facebook",
                                    painterResource(id = R.drawable.facebook))
                            }
                        }
                        VerticalSpacer(space = space8)
                       ConditionText(condtion = stringResource(R.string.by_continuing_you_agree_terms_of_services_privacy_policy))
                    }
            }




        }
    }
}


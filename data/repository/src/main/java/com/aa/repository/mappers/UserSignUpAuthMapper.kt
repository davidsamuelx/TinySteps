package com.aa.repository.mappers

import com.aa.models.UserRegisterInformation
import com.aa.models.UserSignUpAuth
import com.aa.repository.resources.SignUpResource
import com.aa.repository.resources.SignUpResponseResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orZero

internal fun UserSignUpAuth.toResource(): SignUpResource {
    return SignUpResource(
        username = name.orEmpty(),
        email = email.orEmpty(),
        password = password.orEmpty(),
        startDate = pregnancyDate.orEmpty(),
        ageBaby = age.orZero(),
        confirmPassword = confirm.orEmpty()
    )
}

internal fun SignUpResponseResource.toEntity():UserRegisterInformation{
    return UserRegisterInformation(
     message=message.orEmpty(),
        email = user?.email.orEmpty(),
        username = user?.username.orEmpty(),
        startDate = user?.startDate.orEmpty(),

    )
}
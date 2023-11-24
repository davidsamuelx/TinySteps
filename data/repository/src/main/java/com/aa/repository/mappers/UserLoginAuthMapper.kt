package com.aa.repository.mappers

import com.aa.models.UserInformation
import com.aa.models.UserLoginAuth
import com.aa.repository.resources.LoginResource
import com.aa.repository.resources.LoginResponseResource
import com.aa.repository.utils.orEmpty
import com.aa.repository.utils.orEmptyList

internal fun UserLoginAuth.toResource():LoginResource{
    return LoginResource(
        identifier = name.orEmpty(),
        password = password.orEmpty()
    )
}

internal fun LoginResponseResource.toEntity():UserInformation{
    return UserInformation(
        username = user?.username.orEmpty(),
        phases = user?.phases.orEmpty(),
        gender = user?.gender.orEmpty(),
        token = accessToken.orEmpty(),
        error = error.orEmpty(),
        password = password.orEmptyList()
    )
}
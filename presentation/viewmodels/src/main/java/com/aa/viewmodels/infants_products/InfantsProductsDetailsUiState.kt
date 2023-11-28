package com.aa.viewmodels.infants_products

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.InfantsProductsEntity


data class InfantsProductsDetailsUiState(
    val infantsProducts:InfantsProductsDetailsItemUiState = InfantsProductsDetailsItemUiState(),
    val isLoading: Boolean = false,
    val error: BaseErrorUiState? = null
): BaseUiState

data class  InfantsProductsDetailsItemUiState(
    val id: Int? = 0,
    val detailsEN: String? = "",
    val nameProductEN: String? = "",
    val pathImg: String? = "",
    val adviceId: Int? = 0,
    val doctorName: String? = "",
    val phoneDoctor: String? = "",
    val profileDoctor: String? = "",
    val doctorLocation: String? = ""
)

fun InfantsProductsEntity.toDetailsUiState() =InfantsProductsDetailsItemUiState(
    id = iD,
    detailsEN = detailsEN,
    nameProductEN = nameProductEN,
    pathImg = pathImg,
    adviceId = adviceId,
    doctorName=doctorName,
    phoneDoctor=phoneDoctor,
    profileDoctor = profileDoctor ,
    doctorLocation = doctorLocation

)
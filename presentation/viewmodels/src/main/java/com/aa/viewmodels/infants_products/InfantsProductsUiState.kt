package com.aa.viewmodels.infants_products

import com.aa.base.BaseErrorUiState
import com.aa.base.BaseUiState
import com.aa.models.infants.InfantsProductsEntity

data class InfantsProductsUiState(
    val infantsProductsList:List<InfantsProductsItemUiState> = emptyList(),
    val query: String = "",
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null
):BaseUiState
data class  InfantsProductsItemUiState(
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
fun InfantsProductsEntity.toUiState() =InfantsProductsItemUiState(
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
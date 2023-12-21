package com.aa.models.kids

data class KidsFoodEntity(
    val id:Int,
    val detailsOfFood: String,
    val imgFood: String,
    val nameFood: String,
    val doctorName: String,
    val nameProblem: String ,
    val phoneDoctor: String,
    val profileDoctor: String,
    val solveProblem: String,
    val doctorLocation:String,
    val specificFood: String?

)

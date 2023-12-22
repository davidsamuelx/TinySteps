package com.aa.usecase.diagnosis

import com.aa.models.DiagnosisData
import com.aa.models.DiagnosisEntity
import java.util.*
import javax.inject.Inject

class GetDiagnosisUseCase @Inject constructor() {

    operator fun invoke(
        firstSymptom: String?,
        secondSymptom: String?,
        thirdSymptom: String?,
        fourthSymptom: String?,
        fifthSymptom: String?
    ): DiagnosisEntity {
        val symptoms = listOfNotNull(
            firstSymptom,
            secondSymptom,
            thirdSymptom,
            fourthSymptom,
            fifthSymptom
        ).filter { it.isNotEmpty() }

        var maxMatchingCount = 0
        var bestMatchingDiagnosis: DiagnosisEntity? = null

        for (diagnosis in DiagnosisData.data) {
            val matchingCount = symptoms.count { symptom ->
                diagnosis.symptoms.map { it.lowercase(Locale.getDefault()) }
                    .contains(symptom.lowercase(Locale.getDefault()))
            }

            if (matchingCount > maxMatchingCount) {
                maxMatchingCount = matchingCount
                bestMatchingDiagnosis = diagnosis
            }
        }

        bestMatchingDiagnosis?.percentage =
            (maxMatchingCount.toDouble() / bestMatchingDiagnosis?.symptoms?.size!!) * 100

        return bestMatchingDiagnosis
    }
}
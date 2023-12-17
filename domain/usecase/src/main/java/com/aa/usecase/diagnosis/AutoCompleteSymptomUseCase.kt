package com.aa.usecase.diagnosis

import com.aa.models.DiagnosisData
import javax.inject.Inject

class AutoCompleteSymptomUseCase @Inject constructor() {

    operator fun invoke(query: CharSequence): String {
        if (query.length < 3) {
            return query.toString()
        }

        val firstThreeLetters = query.take(3)

        for (diagnosis in DiagnosisData.data) {
            for (symptom in diagnosis.symptoms) {
                if (symptom.startsWith(firstThreeLetters, ignoreCase = true)) {
                    return symptom
                }
            }
        }
        return query.toString()
    }
}
package com.aa.models


object DiagnosisData {
    val data = listOf(
        DiagnosisEntity(
            name = "Anemia",
            symptoms = listOf(
                "Fatigue",
                "Weakness",
                "Shortness of breath",
                "Dizziness",
                "Pale skin",
                "Headache",
                "Cold hands and feet"
            ),
            cause = "Iron deficiency due to the increased demand for iron during pregnancy",
            treatment = listOf("Iron supplements", "Dietary changes to include iron-rich foods")
        ),
        DiagnosisEntity(
            name = "Gestational Diabetes",
            symptoms = listOf("Increased thirst and urination", "Fatigue", "Blurred vision", "Slow-healing sores"),
            cause = "Inability of the body to produce enough insulin to manage blood sugar levels",
            treatment = listOf("Dietary changes", "Exercise", "Blood sugar monitoring", "Medication if necessary")
        ),
        DiagnosisEntity(
            name = "Depression and Anxiety",
            symptoms = listOf(
                "Sadness",
                "Hopelessness",
                "Lack of interest in activities",
                "Changes in appetite or sleep",
                "Difficulty concentrating",
                "Thoughts of self-harm"
            ),
            cause = "Hormonal changes, stress, personal or family history of mental illness",
            treatment = listOf("Psychotherapy", "Medication", "Support groups")
        ),
        DiagnosisEntity(
            name = "Preeclampsia",
            symptoms = listOf(
                "High blood pressure",
                "Protein in the urine",
                "Severe headaches",
                "Vision problems",
                "Upper abdominal pain",
                "Nausea and vomiting"
            ),
            cause = "Unknown, but likely related to insufficient blood flow to the placenta",
            treatment = listOf("Close monitoring", "Medication", "Bed rest", "Delivery of the baby, if necessary")
        ),
        DiagnosisEntity(
            name = "Hyperemesis Gravidarum (HG)",
            symptoms = listOf("Severe nausea and vomiting", "Dehydration", "Weight loss", "Electrolyte imbalance"),
            cause = "Unknown, but thought to be related to hormonal changes",
            treatment = listOf("Medication", "Fluids", "Hospitalization in severe cases")
        ),
        DiagnosisEntity(
            name = "Urinary Tract Infections (UTIs)",
            symptoms = listOf("Painful urination", "Frequent urination", "Urgency to urinate", "Blood in the urine"),
            cause = "Bacteria entering the urinary tract",
            treatment = listOf("Antibiotics")
        ),
        DiagnosisEntity(
            name = "Heartburn and Indigestion",
            symptoms = listOf("Burning sensation in the chest", "Stomach pain", "Belching", "Bloating"),
            cause = "Increased progesterone levels relaxing the esophageal sphincter, allowing stomach acid to back up into the esophagus",
            treatment = listOf(
                "Lifestyle changes, such as eating smaller meals more frequently and avoiding certain foods",
                "Antacids"
            )
        ),
        DiagnosisEntity(
            name = "Varicose Veins and Hemorrhoids",
            symptoms = listOf("Swollen, twisted veins in the legs", "Pain", "Itching", "Bleeding"),
            cause = "Increased blood volume and pressure on veins during pregnancy",
            treatment = listOf("Compression stockings", "Elevating legs", "Stool softeners")
        ),
        DiagnosisEntity(
            name = "Morning Sickness",
            symptoms = listOf("Nausea and vomiting, usually in the morning but can occur at any time"),
            cause = "Unknown, but thought to be related to hormonal changes",
            treatment = listOf(
                "Eating small, frequent meals",
                "Avoiding triggers",
                "Ginger",
                "Medication in severe cases"
            )
        ),
        DiagnosisEntity(
            name = "Insomnia",
            symptoms = listOf("Difficulty falling asleep", "Staying asleep", "Waking up too early"),
            cause = "Hormonal changes, anxiety, physical discomfort",
            treatment = listOf(
                "Relaxation techniques",
                "Establishing a regular sleep schedule",
                "Avoiding caffeine and alcohol"
            )
        )
    )
}
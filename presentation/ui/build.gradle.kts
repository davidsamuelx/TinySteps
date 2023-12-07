plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.aa.ui"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
//    implementation(project(":app"))
    implementation(project(":presentation:viewmodels"))
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.compose.ui:ui-util:1.5.4")
    implementation("androidx.compose.material3:material3")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation ("androidx.navigation:navigation-compose:2.7.5")
    implementation ("io.coil-kt:coil-compose:2.0.0")
    implementation("com.google.android.exoplayer:exoplayer-core:2.19.0")
    implementation("com.google.android.exoplayer:exoplayer-dash:2.19.0")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.19.0")
    implementation ("com.airbnb.android:lottie-compose:6.0.1")
}
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // Added for DAGGER HILT
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.albanda.playandrate"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.albanda.playandrate"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Added for NAVIGATION between screens
    implementation("androidx.navigation:navigation-compose:2.9.0")

    // Added for DAGGER HILT
    implementation("com.google.dagger:hilt-android:2.56.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation(libs.firebase.auth)
    kapt("com.google.dagger:hilt-android-compiler:2.56.1")

    // Added for Firebase Auth
//    implementation(libs.firebase.auth)

    // Added for Firebase Database
    implementation(platform("com.google.firebase:firebase-bom:33.13.0"))
    // Declare the dependency for the Cloud Firestore library
    implementation("com.google.firebase:firebase-firestore")
    // Added for Firebase Storage
    implementation("com.google.firebase:firebase-storage")

    // GSON - Converts objects to string
    implementation("com.google.code.gson:gson:2.11.0")

    // Async image
    implementation("io.coil-kt.coil3:coil-compose:3.2.0")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.2.0")
    implementation("commons-io:commons-io:2.19.0")

    // Added for lottie
    implementation("com.airbnb.android:lottie-compose:6.6.10")

    // Add to change automatically the status bar color
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.36.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
plugins {
    alias(libs.plugins.androidApplication)
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.todolist"
    compileSdk = 34
    buildFeatures{
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.todolist"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.lifecycle.viewmodel.android)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation("androidx.core:core-ktx:+")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("org.jetbrains:annotations-java5:15.0")
    // ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")

    // Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")


    // Room for database
    implementation ("androidx.room:room-runtime:2.5.0")
    implementation ("androidx.room:room-compiler:2.5.0")
    implementation ("androidx.room:room-ktx:2.5.0")
}


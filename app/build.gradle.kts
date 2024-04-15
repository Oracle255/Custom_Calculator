plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.custom_calculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.custom_calculator"
        minSdk = 26
        targetSdk = 34
        versionCode = 2
        versionName = "BuggyMess"

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
    buildFeatures {
        compose = true
        buildConfig = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }

    kotlinOptions {
        jvmTarget = "19"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    val version_lifecycle = "2.7.0"
    val version_room = "2.6.1"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Lifecycle Viewmodel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$version_lifecycle")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$version_lifecycle")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$version_lifecycle")
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$version_lifecycle")
    implementation("androidx.lifecycle:lifecycle-common-java8:$version_lifecycle")

    //compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$version_lifecycle")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //Room
    implementation("androidx.room:room-runtime:$version_room")
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    implementation("androidx.room:room-ktx:$version_room")
    implementation("androidx.room:room-rxjava3:$version_room")
}
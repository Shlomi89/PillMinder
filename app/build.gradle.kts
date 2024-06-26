plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.pillminderapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pillminderapp"
        minSdk = 26
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.7.4"))
    implementation("com.google.firebase:firebase-analytics")
    // Firebase Auth
    implementation ("com.firebaseui:firebase-ui-auth:7.2.0")
    implementation ("com.google.android.gms:play-services-auth:20.7.0")
    //Firebase Database
    implementation("com.google.firebase:firebase-database")
    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    //Gson
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("androidx.appcompat:appcompat:1.4.0")
    //Lottie
    implementation ("com.airbnb.android:lottie:6.4.0")
}
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("maven-publish")
}

android {
    namespace = "com.test.room_crud"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.7.0")
    implementation("androidx.activity:activity-ktx:1.8.2")

    implementation(project(":app"))
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.kapilkori"
            artifactId = "room-crud"
            version = "0.0.9"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

//configure<PublishingExtension> {
//    publications.create<MavenPublication>("room-crud") {
//        groupId = "com.github.kapilkori"
//        artifactId = "room-crud"
//        version = "0.0.6"
//    }
//    repositories {
//        mavenLocal()
//    }
//}

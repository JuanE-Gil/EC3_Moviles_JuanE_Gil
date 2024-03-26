plugins {
	alias(libs.plugins.androidApplication)
	alias(libs.plugins.jetbrainsKotlinAndroid)
	id("org.jetbrains.kotlin.kapt")
}

android {
	namespace = "com.juane.ec3_juane_gil"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.juane.ec3_juane_gil"
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
		jvmTarget = "1.8"
	}

	buildFeatures{
		viewBinding = true
	}
}

dependencies {

	val roomVersion = "2.2.6"
	val lifecycleVersion = "2.3.0"

	//Room
	implementation("androidx.room:room-runtime:$roomVersion")
	implementation("androidx.room:room-ktx:$roomVersion")
	kapt("androidx.room:room-compiler:$roomVersion")

	//Livecycle
	implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
	implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
	implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
	kapt("androidx.lifecycle:lifecycle-compiler:$lifecycleVersion")

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.constraintlayout)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}
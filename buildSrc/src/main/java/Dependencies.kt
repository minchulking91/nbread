object Versions {
    val kotlin_version = "1.2.30"
    val support_lib = "27.1.0"
    val retrofit = "2.3.0"
    val rxjava = "2.1.9"
    val constraint_version = "1.0.2"
    val junit = "4.12"
    val runner: String = "1.0.1"
    val espresso: String = "3.0.1"
    val dagger: String = "2.11"
    val rxkotlin: String = "2.2.0"
    val gson: String = "2.8.2"
    val guava: String = "24.0-android"
    val arch: String = "1.1.0"
    val room: String = "1.0.0"
}

object Paths {
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
    val android_gradle_plugin = "com.android.tools.build:gradle:3.0.1"
}

object Deps {
    //kotlin
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"

    //android support
    val support_annotations = "com.android.support:support-annotations:${Versions.support_lib}"
    val support_appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support_lib}"
    val constraint_layout = "com.android.support.constraint:constraint-layout:${Versions.constraint_version}"

    //retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_rxjava_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"

    //reactive x
    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"

    //google
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val guava = "com.google.guava:guava:${Versions.guava}"

    //dagger
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val dagger_android = "com.google.dagger:dagger-android:${Versions.dagger}"
    val dagger_android_support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val dagger_android_processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

    //android arch
    val android_arch = "android.arch.lifecycle:extensions:${Versions.arch}"
    val android_arch_compiler = "android.arch.lifecycle:compiler:${Versions.arch}"

    //android room
    val android_room_runtime = "android.arch.persistence.room:runtime:${Versions.room}"
    val android_room_compiler = "android.arch.persistence.room:compiler:${Versions.room}"

    //for Test
    val junit = "junit:junit:${Versions.junit}"
    val runner = "com.android.support.test:runner:${Versions.runner}"
    val espresso = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    val android_arch_test  = "android.arch.core:core-testing:${Versions.arch}"
    val android_arch_room_test = "android.arch.persistence.room:testing:${Versions.room}"
}

object Configs {
    val compileSdkVersion = 27
    val minSdkVersion = 16
    val targetSdkVersion = 26
    val versionCode = 1
    val versionName = "1.0"
}
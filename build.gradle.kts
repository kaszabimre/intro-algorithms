
allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
delete(rootProject.buildDir)
}

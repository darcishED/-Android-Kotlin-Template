plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    // Fake empty plugin to make 'DependenciesLoader' class available to the app's build.gradle script
    plugins.register("dependencies-loader") {
        id = "dependencies-loader"
        implementationClass = "DependenciesLoader"
    }
    // Provide your custom plugins here
}

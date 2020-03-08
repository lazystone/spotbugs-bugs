plugins {
    // https://github.com/spotbugs/spotbugs-gradle-plugin
    id("com.github.spotbugs") version "4.0.1"

    java
    idea
}

group = "se.lazystone.spotbugs4"
description = "config example"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compileOnly("com.google.code.findbugs:annotations:3.0.1")
    // https://github.com/KengoTODA/findbugs-slf4j
    spotbugsPlugins("jp.skypencil.findbugs.slf4j:bug-pattern:1.5.0@jar")
    // https://github.com/mebigfatguy/fb-contrib/releases/latest
    spotbugsPlugins("com.mebigfatguy.sb-contrib:sb-contrib:7.4.7")
}

spotbugs {
    // https://github.com/spotbugs/spotbugs/releases/latest
    toolVersion.set("4.0.0")
    showProgress.set(true)
    excludeFilter.set(file("findbugs-exclude.xml"))
    // Exclude tests from analyze
    sourceSets.addAll(listOf(project.sourceSets["main"]))
}
tasks.withType<com.github.spotbugs.snom.SpotBugsTask>().configureEach {
    reports.create("html") {
        enabled = true
    }
}

// https://github.com/spotbugs/spotbugs-gradle-plugin/issues/196
// defaultTasks("clean", "build", "spotbugsMain")
defaultTasks("clean", "build")

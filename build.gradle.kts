plugins {
    `java-library`
    `maven-publish`
}

group = "com.github.NiFeather"
version = "2.1.0"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }

    maven {
        url = uri("https://jitpack.io")
    }

    maven {
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }

    maven {
        url = uri("https://repo.md-5.net/content/groups/public/")
    }

    maven {
        url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    compileOnly("org.jetbrains:annotations:23.0.0")
    compileOnly("com.google.code.gson:gson:2.10")
    compileOnly("it.unimi.dsi:fastutil:8.2.2")
}
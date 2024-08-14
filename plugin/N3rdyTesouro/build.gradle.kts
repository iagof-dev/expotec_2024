plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.0.0"
}


group = "br.com.iagofragnan"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://jitpack.io")
    maven("https://mvnrepository.com/artifact/de.rapha149.signgui/signgui");
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT") //Minecraft Plugin SDK API
    compileOnly("com.comphenix.protocol:ProtocolLib:5.1.0") // Protocol LIB api for minecraft
    compileOnly("com.github.decentsoftware-eu:decentholograms:2.8.6") // Hologram api for minecraft
    implementation("com.fazecast:jSerialComm:2.6.2") // Communication on Serial Port
    implementation("de.rapha149.signgui:signgui:2.3.2") // Sign GUI for typing the name
    implementation("com.google.code.gson:gson:2.10.1")
}


tasks.test {
    useJUnitPlatform()
}
tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xlint:unchecked")
}

tasks.shadowJar {
    archiveClassifier.set("")
}



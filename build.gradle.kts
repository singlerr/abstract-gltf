plugins {
    id("java")
    `maven-publish`
}

group = "de.javagl.gltf"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.9")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

java{
    withSourcesJar()
    withJavadocJar()
}

tasks.withType<Javadoc>{
    isFailOnError = false
}

publishing{
    publications{
        create<MavenPublication>("mavenJava"){
            groupId = group.toString()
            artifactId = rootProject.name
            setVersion(project.version)

            from(components["java"])
        }
    }
}
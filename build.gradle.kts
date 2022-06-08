plugins {
    id("org.ajoberstar.grgit") version "4.1.1"
}

tasks.register("getVersion") {
    doFirst {
        val commitId = grgit.head().abbreviatedId
        val tag = grgit.describe {
            tags = true
            always = true
            longDescr = true
        }
        Regex("(?<tag>.+)-(?<commits>\\d+)-g$commitId").matchEntire(tag)
            ?.let {
                if (it.groups["commits"]!!.value == "0") {
                    println("RELEASED VERSION ${it.groups["tag"]!!.value}")
                } else {
                    println("SNAPSHOT VERSION ${it.groups["tag"]!!.value}.$commitId")
                }
            }
            ?: run {
                println("SNAPSHOT VERSION 0.0.0-$commitId")
            }
    }
}

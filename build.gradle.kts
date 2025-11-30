plugins {
    id("org.ajoberstar.grgit") version "5.3.3"
}

group = "com.rogervinas"
version = run {
    val commitId = grgit.head().abbreviatedId
    val tag = grgit.describe {
        tags = true
        always = true
        longDescr = true
    }
    return@run Regex("(?<tag>.+)-(?<commits>\\d+)-g$commitId").matchEntire(tag)
        ?.let {
            if (it.groups["commits"]!!.value == "0") {
                it.groups["tag"]!!.value
            } else {
                "${it.groups["tag"]!!.value}.$commitId"
            }
        }
        ?: "0.0.0.$commitId"
}

tasks.register("getVersion") {
    doFirst {
        println("$version")
    }
}

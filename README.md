# grgit gradle plugin to get current version

See doc at https://ajoberstar.org/grgit/grgit-describe.html

## First time 

```shell
./gradlew getVersion

> Task :getVersion
SNAPSHOT VERSION 0.0.0-7526fa4
```

## Once we add a tag

```shell
git tag 1.0.0
./gradlew getVersion

> Task :getVersion
RELEASED VERSION 1.0.0
```

## Once we add another commit
```shell
git tag 1.0.0
./gradlew getVersion

> Task :getVersion
RELEASED VERSION 1.0.0
```
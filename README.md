# grgit gradle plugin to get current version

See doc at https://ajoberstar.org/grgit/grgit-describe.html

1. First time 

```shell
./gradlew getVersion

> Task :getVersion
SNAPSHOT VERSION 0.0.0-7526fa4
```

2. We add a tag

```shell
git tag 1.0.0
./gradlew getVersion

> Task :getVersion
RELEASED VERSION 1.0.0
```

3. We add another commit
```shell
git commit --allow-empty -m "Another commit"
./gradlew getVersion

> Task :getVersion
SNAPSHOT VERSION 1.0.0-99cb359
```


2. We add another tag

```shell
git tag 1.0.1
./gradlew getVersion

> Task :getVersion
RELEASED VERSION 1.0.1
```
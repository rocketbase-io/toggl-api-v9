# toggl-api-v9

![build](https://github.com/rocketbase-io/toggl-api-v9/actions/workflows/ci.yml/badge.svg)
[![Maven Central](https://badgen.net/maven/v/maven-central/io.rocketbase.toggl/toggl-api-v9)](https://central.sonatype.com/artifact/io.rocketbase.toggl/toggl-api-v9/versions)

Java RestClients for Toggl APIv9

Features:

- [X] Major Track API
- [X] Report Detail API
- [ ] Only mainly major path is implemented

## designed

It's desinged in a fluent mapper. Starting from **TogglApi** your can navigate to track / report api... After that you
can go to the different resources and their metheods

## usage

````java
import io.rocketbase.toggl.TogglApi;
import io.rocketbase.toggl.TogglApiRest;
import io.rocketbase.toggl.TogglConfig;

TogglApi togglApi = new TogglApiRest(new TogglConfig("api-token-xxx"));
MeDto response = togglApi.track()
        .me()
        .get();
````

Library needs as dependency:

- spring-web
- jackson-databind
- jackson-datatype-jsr310

have been marked as provided to go with your project's spring-versions

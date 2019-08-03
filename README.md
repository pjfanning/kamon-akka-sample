# kamon-akka-sample

A sample demonstrating [Akka-Http](https://doc.akka.io/docs/akka-http/current/index.html) with [Kamon](https://kamon.io/).

```
sbt run
```

To see prometheus metrics:
```
curl http://localhost:9095
```

To call test ping endpoint:
```
curl http://localhost:12345
```

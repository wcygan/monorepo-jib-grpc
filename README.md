# monorepo-jib-proto

This shows an example of a client and server who communicate using gRPC. Images are built for both the client and server using Jib and deployed to a Kubernetes cluster using Skaffold. 

## Quickstart

1. [Install minikube](https://minikube.sigs.k8s.io/docs/start/)
2. [Install kubectl](https://kubernetes.io/docs/tasks/tools/#kubectl)
3. [Install skaffold](https://skaffold.dev/docs/install/)

```
minikube start
```

```
skaffold dev
```

## Monitoring

View [Metrics](http://127.0.0.1:9090/graph?g0.expr=sum(rate(node_cpu_seconds_total%7Bmode!%3D%22idle%22%7D%5B5m%5D))%20by%20(instance)&g0.tab=0&g0.display_mode=lines&g0.show_exemplars=0&g0.range_input=1h) produced by Prometheus and Grafana

## Clean up

```
skaffold delete
```

```
minikube stop
```

## Development

To compile the project (including the protobuf-generated code), run:

```
mvn compile
```

Then reload all maven projects in your IDE to index the generated code.
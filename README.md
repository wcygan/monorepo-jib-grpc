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

Visit:

- Prometheus: http://localhost:9090/
- Grafana: http://localhost:3000/
  - Username: admin
  - Password: prom-operator

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
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

## Clean up

```
skaffold delete
```

```
minikube stop
```
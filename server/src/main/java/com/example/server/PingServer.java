package com.example.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import ping.PingServiceGrpc;
import ping.Ping.PingRequest;
import ping.Ping.PingResponse;

import java.io.IOException;

public class PingServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8080)
                .addService(new PingServiceImpl())
                .build();

        server.start();
        System.out.println("Server started, listening on " + server.getPort());
        server.awaitTermination();
    }

    static class PingServiceImpl extends PingServiceGrpc.PingServiceImplBase {
        @Override
        public void sendPing(PingRequest request, io.grpc.stub.StreamObserver<PingResponse> responseObserver) {
            PingResponse response = PingResponse.newBuilder().setMessage("Pong: " + request.getMessage()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

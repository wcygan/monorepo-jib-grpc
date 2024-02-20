package com.example.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ping.PingServiceGrpc;
import ping.Ping.PingRequest;
import ping.Ping.PingResponse;

public class PingClient {
    public static void main(String[] args) throws InterruptedException {
        // Create a channel to the server.
        ManagedChannel channel = ManagedChannelBuilder.forAddress("ping-server-service", 8080)
                .usePlaintext() // Disable SSL to allow plaintext communication (not recommended for production).
                .build();

        // Create a stub to interact with the server.
        PingServiceGrpc.PingServiceBlockingStub stub = PingServiceGrpc.newBlockingStub(channel);

        int i = 0;
        while (true) {
            PingRequest request = PingRequest.newBuilder()
                    .setMessage("Ping " + i)
                    .build();

            try {
                PingResponse response = stub.sendPing(request);
                System.out.println("Received response: " + response.getMessage());
            } catch (Exception e) {
                System.err.println("Request failed: " + e);
                break; // Exit the loop if the request fails.
            }

            // Wait for a second before sending the next ping.
            Thread.sleep(1000);
            i++;
        }


        // Shut down the channel to terminate the connection to the server.
        channel.shutdownNow();
    }
}

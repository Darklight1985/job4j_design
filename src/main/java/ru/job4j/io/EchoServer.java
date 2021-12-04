package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty();
                         str = in.readLine()) {
                        list.add(str);
                        System.out.println(str);

                    }
                    switch (list.get(0)) {
                        case "GET /?msg=Hello HTTP/1.1" -> out.write("Hello".getBytes());
                        case "GET /?msg=Exit HTTP/1.1" -> server.close();
                        default -> out.write("What".getBytes());
                    }
                    out.flush();
                }
                        list.clear();
                }
            } catch (IOException e) {
            LOG.error("There's a mistake somewhere");
        }
    }
    }


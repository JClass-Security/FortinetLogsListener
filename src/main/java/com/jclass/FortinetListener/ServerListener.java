package com.jclass.FortinetListener;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ServerListener extends Thread {

        private DatagramSocket socket;
        private boolean running;
        private byte[] buf = new byte[256];

        public ServerListener(Integer port) {
            try {
                socket = new DatagramSocket(514);
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }

        public void run() {

            running = true;

            while (running) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                try {
                    socket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                String received = new String(packet.getData(), 0, packet.getLength());

                System.out.println(received);

                if (received.equals("end")) {
                    running = false;
                    continue;
                }
//            try {
//				socket.send(packet);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
            }
            socket.close();
        }
}

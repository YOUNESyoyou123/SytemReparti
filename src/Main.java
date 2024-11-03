import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            while (true) {
            DatagramSocket socket = new DatagramSocket(8001);

                Scanner in = new Scanner(System.in);
                System.out.println("donne le message ");
                String message = in.nextLine();
                byte[] buffer = message.getBytes();
                int port = 8000;


                InetAddress address = InetAddress.getByName("192.168.108.89");


                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);


                socket.send(packet);
                System.out.println("Message envoyé");

                byte[] buffer2 = new byte[1024];
                DatagramPacket packet2 = new DatagramPacket(buffer2, buffer2.length);
                System.out.println("En attente du message...");
                socket.receive(packet2);
                String message2 = new String(packet2.getData(), 0, packet.getLength());
                System.out.println("Message reçu: " + message2);

                socket.close();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

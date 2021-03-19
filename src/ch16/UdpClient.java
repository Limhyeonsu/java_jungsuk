package ch16;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/* TCP에서는 Socket, ServerSocket사용하지만 UDP에서는 DatagramSocket, DatagramPacket을 사용한다.
 * UDP는 TCP와 달리 연결지향적인 프로토콜이 아니다.
 * DatagramPacket : 헤더와 데이터로 구성, 헤더에는 수신할 호스트의 정보(주소, 포트)가 저장되어 있다.
 */
public class UdpClient {
	public void start() throws IOException, UnknownHostException{
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
		
		//데이터가 저장될 공간을 byte배열을 생성
		byte[] msg = new byte[100];
		
		DatagramPacket outPacket = new DatagramPacket(msg,  1, serverAddress, 7777);
		DatagramPacket inPacket = new DatagramPacket(msg,  msg.length);
		
		datagramSocket.send(outPacket);  //DatagramPacket을 전송
		datagramSocket.receive(inPacket);  //DatagramPacket을 수신
		
		System.out.println("current server time : "+new String(inPacket.getData()));
		
		datagramSocket.close();
	}
	

	public static void main(String[] args) {
		try {
			new UdpClient().start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

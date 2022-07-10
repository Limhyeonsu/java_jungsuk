package ch16;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 소켓프로그래밍 : 소켓을 이용한 통신, 소켓이란 프로세스간의 통신에 사용되는 양쪽 끝단
 * TCP/IP : 이기종 시스템간의 통신을 위한 표준 프로토콜로 프로토콜의 집합이다.
 * TCP : ex.전화, 연결기반이고 1:1통신방식임 데이터 전송에 실패시 해당 데이터를 재전송 하기 때문에 신뢰성 있는 데이터 전송이 요구되는 경우에 사용됨
 * UDP : ex.소포, 비연결기반으로 데이터가 수신되었는지 확인하지 않아 안전성이 떨어진다. 단 전송속도는 빠름
 * 
 * TCP소켓프로그래밍 : 클라이언트와 서버가의 일대일 통신
 * 서버소켓은 연결요청이 올때마다 새로운 소켓을 생성하여 상대편 소켓과 통신할 수 있도록 연결한다.(전화시스템과 유사함)
 * 서버소켓은 포트를 독점한다. 포트번호는 0~65535의 범위를 가진다.
 *  소켓이 데이터를 주고받는 연결 통로는 입출력 스트림이다. 소켓은 입력스트림과 출력스트림을 가지고 있고 상대편 소켓의 스트림과 교차 연결된다.
 *  입력스트림과 상대방의 출력스트림/ 출력스트림과 상대방의 입력스트림과 연결
 */
public class TcpIpServer {
	public static void main(String[] args) {
		ServerSocket serverSoket = null;
		
		try {
			//서버 소켓을 생성하여 7777번 포트와 결합 시킨다.
			serverSoket = new ServerSocket(7777);
			System.out.println(getTime() + "서버가 준비되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime() + "연결요청을 기다립니다.");
				//서버소켓을 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.
				//클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
				Socket socket = serverSoket.accept();
				System.out.println(getTime() + socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");
				
				//소켓의 출력스트림을 얻는다.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				//원격소켓에 데이터를 보낸다.
				dos.writeUTF("[Notis] Test Message1 from Server.");
				System.out.println(getTime() + "데이터를 전송했습니다.");
				
				//스트림과 소켓을 닫아준다.
				dos.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}

package khie;
/*
 * TCP 네트워킹
 * =>TCP(Transmission Control Protocol)은 연결 지향적 프로토콜임.
 * ㄴ>연결 지향적 프로토콜은 시간이 소요가 된다.
 * ※연결 지향적 프로토콜이란? 클라이언트와 서버가 연결된 상태에서 데이터를 주고 받는 프로토콜을 말한다. 클라이언트가 요청을 하고, 서버가 연결을
 * 수락하면 통신 선로가 고정이 되고, 모든 데이터는 고정된 통신 선로를 통해서 순차적으로 전달이 된다.
 * 
 * =>통신 선로가 고정적이기 때문에 통신 선로의 영향으로 전송 속도가 느려질 수 있음.
 * =>하지만 데이터를 정확하고 안정적으로 전달하는 특징이 있다.
 * 
 */

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam_02 {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5002)); // 서버 소켓의 포트와 클라이언트의 포트번호는
																			// 같아야 된다.

			// InetSocketAddress 소켓 주소 만드는 메서드

			while (true) {

				System.out.println("...[연결을 기다림]...");

				// 클라이언트의 연결 요청이 들어오면 수락을 하고
				// 데이터를 주고 받을 통신용 소켓을 하나 만들게 된다.
				Socket socket = serverSocket.accept(); // accept() : 클라이언트의 연결을 수락하는 메서드

				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); // 다운캐스팅
				// getRemoteSocketAddress() : 연결된 클라이언트의 IP와 포트 정보를 가져오는 메서드
				// 클라이언트의 컴퓨터 이름을 가져올 수 있음.
				System.out.println("...[연결을 수락함]..." + isa.getHostName());

			}
		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}

	}

}
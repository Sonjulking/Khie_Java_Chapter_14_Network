package tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Example {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			// serverSocket 생성과 포트 바인딩
			// ServerSocket serverSocket = new ServerSocket(5001);
			// 지정된 포트에 바인딩된 서버 소켓을 만듭니다.
			// =>이경우 ip주소가 없다.

			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			// 첫번째 매개값은 ip 주소, 두번째 매개값은 바인딩 시켜줄 포트번호
			// localhost = 127.0.0.1
			while (true) {
				System.out.println("[연결 기다림]");

				// 연결 수락 코드
				Socket socket = serverSocket.accept();
				// accept() 메서드가 클라이언트의 연결 요청을 수락. 연결 요청전까지는 대기상태(블록킹)
				// 소켓이라는 통신용 객체를 만들어주고 소켓을 리턴.
				// 소켓을 가지고 클라이언트의 정보를 얻거나 클라이언트와 데이터를 주고받아줌.

				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress(); // 타입변환.
				// 다운캐스팅 해준거같은데...?
				// 반환형이 socket이라서!
				// getRemoteSocketAddress() 메서드 : 연결된 클라이언트의 IP주소와 포트정보 얻기.

				System.out.println("[연결 수락함] " + isa.getHostName()); // 클라이언트의 ip주소 출력
				// InetSocketAddress의 메서드
				// getHostName() : 클라이언트 IP리턴
				// getPort() : 클라이언트 포트 번호 리턴
				// toString() : "IP : 포트번호" 형태의 문자열 리턴

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 지금은 의미가 없지만 나중에 UI 만들고 서버 종료 버튼눌렀을때 이와같은 코드가 실행이 되어야 함.
		if (!serverSocket.isClosed()) {
			try {
				serverSocket.close(); // ServerSocket포트 언바인딩
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

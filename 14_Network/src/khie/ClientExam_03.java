package khie;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExam_03 {

	public static void main(String[] args) {

		// 서버는 서버소켓, 클라이언트는 그냥 소켓
		Socket socket = null;

		try {
			socket = new Socket();

			System.out.println("...[연결 요청 중]...");

			socket.connect(new InetSocketAddress("localHost", 5002));

			System.out.println("[연결이 성공이 되었습니다.]");

		} catch (IOException e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}

		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO 자동 생성된 catch 블록
				e.printStackTrace();
			}
		}

	}

}

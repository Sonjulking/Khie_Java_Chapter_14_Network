package tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client_Example {
	public static void main(String[] args) {
		// Socket socket = new Socket("localhost", 5001);
		// Socket socket = new Socket(new InetSocketAddress("localhost", 5001);

		Socket socket = null; // 클라이언트에서 서버에 연결요청을 하기 위한 소켓 변수 선언
		System.out.println("[연결 요청]");
		try {
			socket = new Socket(); // 클라이언트에서 서버에 연결요청을 하기 위한 소켓 객체 생성
			socket.connect(new InetSocketAddress("localhost", 5001)); // 로컬호스트 아이피 5001 포트가
			// 바인딩된 서버를 연결.

			System.out.println("[연결 성공]");

			// byte 배열 선언
			byte[] bytes = null;

			// 문자열로 저장할 메세지 변수 선언
			String message = null;

			// 서버로 데이터를 받아야되니까 outputStream이 필요
			// outputStream을 소켓으로부터 얻어냄.

			OutputStream os = socket.getOutputStream();

			message = "Hello Server";

			// 메세지로 부터 UTF-8 형식의 바이트 배열을 얻어내낸다.
			bytes = message.getBytes("UTF-8"); // Q. 배열의 값을 안써줘도 되나요?

			os.write(bytes);// 바이트배열을 작성
			os.flush(); // 버퍼에 남은거를 빠짐없이 내보냄.
			System.out.println("[데이터 보내기 성공]");

			// 반대로 서버로 부터 데이터를 받아줌.
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes, 0, readByteCount, "UTF-8");

			System.out.println("[데이터 받기 성공] " + message);

			os.close();
			is.close();
			// socket.close();는 어차피 캐치문에서 닫아줌..!

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
			}

		}
	}

}

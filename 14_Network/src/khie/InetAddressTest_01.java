package khie;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * InetAddress 클래스
 * =>자바에서 IP 주소를 사용할 수 있는 기능을 제공하는  클래스.
 * =>로컬 컴퓨터의 IP주소 및 도메인 이름을 DNS에서 검색하여 IP주소를 가져오는 기능을 제공한다.
 * 
 * 1.getAddress() : InetAddress 클래스가 가지고 있는 IP 주소를 얻음.
 * 
 * 2.getHostAddress() : IP 주소를 문자열로 나타낸다.
 * 
 * 3.getHostName() : 객체가 가지는 호스트 이름을 문자열로 나타낸다.
 * 
 * 4.getByName(String host) : 주어진 이름을 갖는 호스트의 IP 주소를 얻는다.
 * 
 * 5.getAllByName(String host) : 주어진 이름을 갖는 호스트의 복수 개의 IP주소들을 얻는다.
 * 
 * 6.getLocalHost() : 현재 시스템의 호스트 IP 주소를 얻는다.
 */
public class InetAddressTest_01 {

	public static void main(String[] args) throws UnknownHostException {

		InetAddress addr = InetAddress.getLocalHost();

		System.out.println("내 컴퓨터 이름 >>> " + addr.getHostName());

		System.out.println("내 컴퓨터 IP >>> " + addr.getHostAddress());

		System.out.println();

		addr = InetAddress.getByName("www.oracle.com");

		System.out.println("oracle ip 주소 >>> " + addr);

		addr = InetAddress.getByName("www.google.com");

		System.out.println(addr);

		// 여러 개의 IP 주소 받기
		InetAddress[] ipAll = InetAddress.getAllByName("www.naver.com");

		for (int i = 0; i < ipAll.length; i++) {

			System.out.println("www.naver.com IP 주소 >>> " + ipAll[i].getHostAddress());
			System.out.println("www.naver.com IP 주소 >>> " + ipAll[i]);

		}
	}

}

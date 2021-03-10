package ch16;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*IP주소 : 컴퓨터를 구별하는데 사용되는 고유한 값이다.
 * 4byte로 구성되어 있다(0~255)
 * 자바에서 IP주소를 다루기 위한 클래스로 InetAddress를 제공한다.
 */
public class NetworkEx1 {
	public static void main(String[] args) {
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.daum.net");  //도메인을 통해 IP주로를 얻는다.
			System.out.println("getHostName() : "+ip.getHostName());
			System.out.println("getHostAddress() : "+ip.getHostAddress());
			System.out.println("toString() : "+ip.toString());
			
			byte[] ipAddr = ip.getAddress();  //ip주소를 byte배열로 반환
			System.out.println("getAddress() : "+Arrays.toString(ipAddr));  // [-45, -25, 99, 17]  음수로 출력됨
			
			String result = "";
			for (int i = 0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ? ipAddr[i] +256 : ipAddr[i];  //음수를 방지하기 위해서 256을 더해준다.
				result += ".";
			}
			System.out.println("getAddress() + 256 :"+result);  //211.231.99.17.
			System.out.println();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			ip = InetAddress.getLocalHost();  //내 PC
			System.out.println("getHostName() :"+ip.getHostName());
			System.out.println("getHostAddress() :"+ip.getHostAddress());
			System.out.println();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			ipArr = InetAddress.getAllByName("www.daum.net");  //도메인명에 지정된 모든 호스트의 IP주로를 배열에 담아 반환한다.
			
			for (int i = 0; i < ipArr.length; i++) {
				System.out.println("ipArr["+i+"] :"+ipArr[i]);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}

package ch16;

import java.net.URL;
import java.net.URLConnection;

/* URLConnection : 어플리케이션과 URL간의 통신연결을 나타내는 클래스의 최상위 클래스로 추상클래스이다.
 * 상속받아 구현한 클래스로는 HttpURLConnection, JarURLConnection
 */
public class NetworkEx3 {
	public static void main(String[] args) {
		URL url = null;
		String address = "http://www.naver.com";
		
		try {
			url = new URL(address);
			URLConnection conn = url.openConnection();
			
			System.out.println("conn.toString() :"+conn);  //sun.net.www.protocol.http.HttpURLConnection:http://www.naver.com
			//userInteraction의 허용여부 반환
			System.out.println("getAllowUserInteraction() :"+conn.getAllowUserInteraction());  //false  
			//연결종료시간을 천분의 일초로 반환
			System.out.println("getConnectTimeout() :"+conn.getConnectTimeout());  //0
			System.out.println("getContent() :" + conn.getContent()); //sun.net.www.protocol.http.HttpURLConnection$HttpInputStream@b81eda8
			System.out.println("getContentEncoding() :" + conn.getContentEncoding()); //null
			System.out.println("getContentLength() :" + conn.getContentLength());  //-1
			System.out.println("getContentType() :" + conn.getContentType());  //text/html
			System.out.println("getDate() :" + conn.getDate());  //1615643726000
			System.out.println("getDefaultAllowUserInteraction() :" + conn.getDefaultAllowUserInteraction());  //false
			System.out.println("getDefaultUseCaches() :" + conn.getDefaultUseCaches());  //true
			System.out.println("getDoInput() :" + conn.getDoInput());  //true
			System.out.println("getDoOutput() :" + conn.getDoOutput());  //false
			//자원(URL)의 만료일자를 얻는다. 
			System.out.println("getExpiration() :" + conn.getExpiration());  //0
			//헤더의 모든필드와 값이 저장된 Map 반환
			System.out.println("getHeaderFields() :" + conn.getHeaderFields());  //{Transfer-Encoding=[chunked], null=[HTTP/1.1 302 Moved Temporarily], Server=[NWS], 
			                                                                                                //Connection=[keep-alive], Vary=[Accept-Encoding,User-Agent], Date=[Sat, 13 Mar 2021 13:55:26 GMT], 
			//변경여부 값 반환                                                                                            //Location=[https://www.naver.com/], Content-Type=[text/html]}
			System.out.println("getIfModifiedSince() :" + conn.getIfModifiedSince());  //0
			//최종변경일 필드의 값 반환
			System.out.println("getLastModified() :" + conn.getLastModified());  //0
			//읽기 제한시간의 값 반환
			System.out.println("getReadTimeout() :" + conn.getReadTimeout());  //0
			System.out.println("getURL() :" + conn.getURL());  //http://www.naver.com
			//캐시 사용여부 반환
			System.out.println("getUseCaches() :" + conn.getUseCaches());  //true
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

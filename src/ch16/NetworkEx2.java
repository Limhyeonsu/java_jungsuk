package ch16;

import java.net.URL;

// URL : 프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링#참조
public class NetworkEx2 {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://www.codechobo.com:80/sample/"+"hello.html?reference=chdechobo#index1");
		
		System.out.println("url.getAutority() : "+url.getAuthority());
		System.out.println("url.getAutority() : "+url.getContent());
		System.out.println("url.getAutority() : "+url.getDefaultPort());
		System.out.println("url.getAutority() : "+url.getPort());
		System.out.println("url.getAutority() : "+url.getFile());
		System.out.println("url.getAutority() : "+url.getHost());
		System.out.println("url.getAutority() : "+url.getPath());
		System.out.println("url.getAutority() : "+url.getProtocol());
		System.out.println("url.getAutority() : "+url.getQuery());
		System.out.println("url.getAutority() : "+url.getRef());
		System.out.println("url.getAutority() : "+url.getUserInfo());
		System.out.println("url.getAutority() : "+url.toExternalForm());
		System.out.println("url.getAutority() : "+url.toURI());
		
	}
}

package ch16;

import java.net.URL;

// URL : 프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링#참조
public class NetworkEx2 {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://www.codechobo.com:80/sample/"
					+"hello.html?reference=chdechobo#index1");
		
		System.out.println("url.getAutority() : "+url.getAuthority());  //www.codechobo.com:80
		System.out.println("url.getContent() : "+url.getContent());  
		System.out.println("url.getDefaultPort() : "+url.getDefaultPort());  //80
		System.out.println("url.getPort() : "+url.getPort());  //80
		System.out.println("url.getFile() : "+url.getFile());  //sample/hello.html?reference=chdechobo#index1
		System.out.println("url.getHost() : "+url.getHost());  //www.codechobo.com
		System.out.println("url.getPath() : "+url.getPath());  // /sample/hello.html
		System.out.println("url.getProtocol() : "+url.getProtocol());  //http
		System.out.println("url.getQuery() : "+url.getQuery());  //referer=codechobo
		System.out.println("url.getRef() : "+url.getRef());  //index1
		System.out.println("url.getUserInfo() : "+url.getUserInfo());  //null
		System.out.println("url.toExternalForm() : "+url.toExternalForm()); 
		System.out.println("url.toURI() : "+url.toURI());
		
	}
}

package ch16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkEx4 {
	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address = "http://www.codechobo.com";
		String line = "";
		
		try {
			url = new URL(address);
			//openStream()을 호출해서 URL의 InputStream을 얻음
			//읽어올 데이터가 문자데이터이기 때문에 BufferedReader()을 사용함.
			input = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

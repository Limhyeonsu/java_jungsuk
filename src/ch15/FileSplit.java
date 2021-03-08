package ch15;

import java.io.*;

//지정한 파일을 지정한 크기로 잘라서 여러개의 파일로 만드는 예제
public class FileSplit {
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("USAGE : java FileSplit filename SIZE_KB");
			System.exit(0);
		}
		
		final int VOLUME = Integer.parseInt(args[1]) * 1000;
		
		try {
			String fileName = args[0];
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = null;
			BufferedOutputStream bos = null;
			
			int data = 0;
			int i = 0;
			int number = 0;
			
			while((data = bis.read()) != -1) {
				if(i%VOLUME == 0) {
					if(i != 0) {
						bos.close();
					}
					
					fos = new FileOutputStream(fileName + "_." + ++number);
					bos = new BufferedOutputStream(fos);
				}
				bos.write(data);
				i++;
			}
			
			bis.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

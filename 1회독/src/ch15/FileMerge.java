package ch15;

import java.io.*;

public class FileMerge {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("USAGE : java FileMerge filename");
			System.exit(0);
		}
		
		String mergeFileName = args[0];
		
		try {
			//createTempFile() : 임시파일을 시스템의 임시 디렉토리에 생성한다.
			File tempFile = File.createTempFile("~mergetemp", ".tmp");
			//deleteOnExit() : 응용프로그램 종료시 파일 삭제(주로 임시파일 삭제하는데 사용)
			tempFile.deleteOnExit();
			
			FileOutputStream fos = new FileOutputStream(tempFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			BufferedInputStream bis = null;
			
			int number = 1;
			
			File f = new File(mergeFileName +"_." + number);
			
			while(f.exists()) {
				f.setReadOnly();  //작업중에 파일의 내용이 변경되지 않도록 한다.
				bis = new BufferedInputStream(new FileInputStream(f));
				
				int data = 0;
				while((data = bis.read()) != -1) {
					bos.write(data);
				}
				
				bis.close();
				
				f = new File(mergeFileName + "_." + ++number);
			}
			
			bos.close();
			
			File oldFile = new File(mergeFileName);
			if(oldFile.exists())
				oldFile.delete();
			tempFile.renameTo(oldFile);
		} catch (Exception e) {}
	}

}

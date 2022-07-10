package ch15;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

//현재 디렉토리에 속한 파일과 디렉토리의 이름과 크기 등 상세정보를 보여주는 예제
public class FileEx4 {
	public static void main(String[] args) {
		String currDir = System.getProperty("user.dir");
		File dir = new File(currDir);
		
		File[] files = dir.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mma");  //2021-01-29 23:51오후
			String attribute = "";
			String size = "";
			
			if(files[i].isDirectory()) {
				attribute = "DIR";
			}else {
				size = f.length() + "";
				attribute = f.canRead() ? "R" : " ";  //canRead() : 읽을 수 있는 파일인지 검사
				attribute = f.canWrite() ? "W" : " ";  //canWrite() : 쓸 수 있는 파일인지 검사
				attribute = f.isHidden() ? "H" : " ";  //isHidden() : 파일 속성이 숨김인지 확인
			}
			System.out.printf("%s %3s %6s %s\n", df.format(new Date(f.lastModified())), attribute, size, name);
		}
	}
}

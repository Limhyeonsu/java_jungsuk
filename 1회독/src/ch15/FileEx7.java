package ch15;

import java.io.File;
import java.io.FilenameFilter;

public class FileEx7 {

	public static void main(String[] args) throws Exception{
		if(args.length != 1) {
			System.out.println("USAGE : java FileEx7 pattern");
			System.exit(0);
		}
		
		String currDir = System.getProperty("usar.dir");
		
		File dir = new File(currDir);
		final String pattern = args[0];
		
		//특정 조건에 맏는 파일의 목록을 얻는다
		String[] files = dir.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.indexOf(pattern) != -1;
			}
		});
		
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
	}

}

package ch15;

import java.io.File;
import java.io.IOException;

/* File : 파일클래스를 통해서 파일과 디렉토리를 다룰 수 있다.
 * 파일의 경로와 디렉토리, 파일의 이름을 구분하는데 사용되는 구분자가 OS마다 다를 수 있기 때문에
 * OS에 독립적으로 프로그램을 작성하기 위해서는 멤버변수들을 이용해야한다.(pathSeparator, separator 등...)
 * File인스턴스를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다. 새로운 파일을 생성하려면 파일 인스턴스 생성 후 출력스트림을 생성하거나 createNewFile()을 호출
 */
public class FileEx1{

	public static void main(String[] args) throws IOException{
		File f = new File("C:\\Users\\kha24\\eclipse-workspace\\java_Ex\\src\\ch15\\FileEx1.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("경로를 제외한 파일이름 - "+f.getName());  // FileEx1.java
		System.out.println("확장자를 제외한 파일이름 - "+fileName.substring(0, pos));  // FileEx1
		System.out.println("확장자 - "+fileName.substring(pos+1));  // java
		
		System.out.println("경로를 포함한 파일이름 - "+f.getPath());  //C:\Users\kha24\eclipse-workspace\java_Ex\src\ch15\FileEx1.java
		//절대경로 : 파일시스템의 루트로부터 시작하는 파일의 전체 경로, 하나의 파일에 둘 이상의 절대경로하 존재할 수 있다.('.'과 같은 기호나 링크를 포함하는 경우)
		System.out.println("파일의 절대경로  - "+f.getAbsolutePath());  // "
		//정규경로 : 기호나 링크를 포함하지 않는 유일한 경로
		System.out.println("파일의 정규경로  - "+f.getCanonicalPath());  // "
		System.out.println("파일이 속해 있는 디렉토리 - "+f.getParent());  // C:\Users\kha24\eclipse-workspace\java_Ex\src\ch15
		System.out.println();
		//OS에서 사용하는 구분자, 경로구분자 : 윈도우 ';' 유닉스 ':', 이름 구분자 : 윈도우 '\' 유닉스 '/'
		//경로 구분자
		System.out.println("File.pathSeparator - "+File.pathSeparator);  // ;
		System.out.println("File.pathSeparatorChar - "+File.pathSeparatorChar);  // ;
		//이름 구분자
		System.out.println("File.separator - "+File.separator);  // \
		System.out.println("File.separatorChar - "+File.separatorChar);  // \
		System.out.println();
		System.out.println("user.dir="+System.getProperty("user.dir")); //C:\Users\kha24\eclipse-workspace\java_Ex
		System.out.println("sun.boot.class.path="+System.getProperty("sun.boot.class.path"));
	}
}

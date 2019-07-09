package QuizCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Quiz01 {
public static void main(String[] args) {
	String testUrl = "http://www.human.or.kr:80";
	FileIO io = new FileIO();
	try {
		URL url = new URL(testUrl);
		DAO dao = new DAO();
		
		InputStream ins = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(ins));
		
		String str="";
		while((str=br.readLine())!=null) {
			if(str.indexOf(".jpg")!=-1) {	//jpg가 있는것만 추출
					String imgcheck=str.substring(0,str.indexOf("jpg")+3); //.jpg 까지 짜르기
					imgcheck=imgcheck.substring(imgcheck.lastIndexOf("http")); //http가 또있을수있으니 마지막 위치호출
					io.StoreFile(imgcheck);
					dao.insert(imgcheck);
			}
		}
		br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}

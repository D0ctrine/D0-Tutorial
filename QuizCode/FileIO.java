package QuizCode;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class FileIO {

	public void StoreFile(String a) {
		try {
			URL url = new URL(a);
			InputStream in = url.openStream();
			
			BufferedInputStream bi = new BufferedInputStream(in);
			FileOutputStream fo = new FileOutputStream(a.substring(a.lastIndexOf("/")+1));
			
			byte buff[] = new byte[1024];
			int imgData=0;
			//이미지 정보 가져오기
			while((imgData=bi.read(buff))!=-1) {
				fo.write(buff,0,imgData);
						fo.flush();
			}
			in.close();
			bi.close();
			fo.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

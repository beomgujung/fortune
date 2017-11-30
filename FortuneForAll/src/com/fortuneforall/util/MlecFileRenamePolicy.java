package com.fortuneforall.util;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MlecFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File f) {
//		f = new File("c:/java/upload/a.jpg");
		String parent = f.getParent();//c:/java/upload
		String name = f.getName();//a.jpg
		
		// 확장자는 유지하고 파일의 이름 부분을 변경
		// 사용자가 선택한 파일의 확장자만 가져오기
		String ext="";
		int index = name.lastIndexOf(".");
		if(index != -1) {
			//ext = .jpg
			ext = name.substring(index);
		}
		// unique한 값을 얻는 random한 이름을 하나 얻어낸다
		String fName = UUID.randomUUID().toString();
		return new File(parent,fName+ext);
	}
	
}

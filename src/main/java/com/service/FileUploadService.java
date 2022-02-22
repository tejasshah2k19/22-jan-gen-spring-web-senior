package com.service;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	
	public  void uploadFile(MultipartFile multiPartFile,String path) {


		try {
			File f = new File(path, multiPartFile.getOriginalFilename());
			byte b[] = multiPartFile.getBytes();

			FileOutputStream fos = new FileOutputStream(f);
			fos.write(b);
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

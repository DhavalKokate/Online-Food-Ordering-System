package com.app.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class FileUploadController {

	@RequestMapping(value = "/upload",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String fileUpload(@RequestParam("file") MultipartFile file,@RequestParam String fileName) throws IOException
	{
		System.out.println(fileName);
		File convertFile=new File("D:\\dhaval\\Pizza_Hut Final Project\\Frontend\\Amazona\\frontend\\public\\images\\"+fileName);
		convertFile.createNewFile();
		
		try(FileOutputStream fout=new FileOutputStream(convertFile)) {
			fout.write(file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "\\images\\"+fileName;
	}
}
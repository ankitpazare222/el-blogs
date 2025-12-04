package com.Ankit.blog.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {
	
	String uploadImg(String path,String file)throws IOException;
	
	InputStream getSource(String path, String filename)throws FileNotFoundException;

}

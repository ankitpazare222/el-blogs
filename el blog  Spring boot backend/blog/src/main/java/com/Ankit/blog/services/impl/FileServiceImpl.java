package com.Ankit.blog.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import com.Ankit.blog.services.FileService;

public class FileServiceImpl implements FileService{

	@Override
	public String uploadImg(String path, String file) throws IOException {
		
		
        // Return file name (to save in DB)
        return null;
	}

	@Override
	public InputStream getSource(String path, String filename) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}

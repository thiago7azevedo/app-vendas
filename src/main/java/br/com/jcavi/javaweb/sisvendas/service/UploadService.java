package br.com.jcavi.javaweb.sisvendas.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {
	
	@Value("${upload.disco.destino}")
	private String destino;
	
	public void salvar(MultipartFile file) {
		this.salvarUpload(file);
	}
	
	private void salvarUpload(MultipartFile file) {
		try {
			byte[] bytes = file.getBytes();
			Path caminho = Paths.get(this.destino + file.getOriginalFilename());
			Files.write(caminho, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	
}
package br.com.jcavi.javaweb.sisvendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.jcavi.javaweb.sisvendas.service.UploadService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/upload")
@RequiredArgsConstructor(onConstructor=@__(@Autowired))
public class UploadController {
		
	private final UploadService uploadService;
	
	@GetMapping("")
	public String index() {
		return "/upload/upload";
	}
	
	@PostMapping("/upload")
	public String uploadArquivoUnico(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		if(file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Selecione um arquivo");
			return "redirect:/upload";
		}
		this.uploadService.salvar(file);
		redirectAttributes.addFlashAttribute("message", "Upload do arquivo " + file.getOriginalFilename() + " realizado com sucesso.");
		
		return "redirect:/upload";
	}

	@GetMapping("/uploadMsg")
	public String uploadMessage() {
		return "/upload/uploadMsg";
	}
}


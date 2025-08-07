package kr.study.spring_ai.controller.openapi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.study.spring_ai.controller.openapi.dto.ImageAnalysisVO;
import kr.study.spring_ai.service.openapi.ImageTextGenService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image-text")
public class ImageTextGenController {
	@Value("${upload.path}")
	private String uploadPath;

	private final ImageTextGenService imageTextGenService;



	@PostMapping("/analyze")
	public ResponseEntity<ImageAnalysisVO> getMultimodalResponse(
		@RequestParam("image") MultipartFile imageFile,
		@RequestParam(defaultValue = "이 이미지에 무엇이 있나요?") String message)
		throws IOException {
		// Ensure the upload directory exists
		File uploadDirectory = new File(uploadPath);
		if (!uploadDirectory.exists()) {
			uploadDirectory.mkdirs();
		}

		// Save the uploaded file to the specified upload path
		String filename = imageFile.getOriginalFilename();
		Path filePath = Paths.get(uploadPath, filename);
		Files.write(filePath, imageFile.getBytes());

		// Analyze the image
		String analysisText = imageTextGenService.analyzeImage(imageFile, message);
		// 세제곱근, 제곱근, 곱셈
		//String searchKeyword = imageTextGenService.extractKeyYouTubeSearch(analysisText);
		//List<String> youtubeUrls = imageTextGenService.searchYouTubeVideos(searchKeyword);

		String imageUrl = "/uploads/" + filename;

		ImageAnalysisVO response = new ImageAnalysisVO(imageUrl, analysisText);
		return ResponseEntity.ok(response);
	}
}

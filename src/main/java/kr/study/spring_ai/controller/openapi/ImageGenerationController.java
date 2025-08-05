package kr.study.spring_ai.controller.openapi;

import java.io.IOException;
import java.util.List;

import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.study.spring_ai.controller.openapi.dto.ImageRequestDTO;
import kr.study.spring_ai.service.openapi.ImageService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ImageGenerationController {

	private final ImageService imageService;

	@PostMapping(value = "/image", consumes = "application/json; charset=UTF-8")
	public List<String> image(@RequestBody ImageRequestDTO request) throws IOException {
		//String message = request.get("message"); // Map에서 "message" 키의 값을 가져옴
		ImageResponse imageResponse = imageService.getImageGen(request);
		//String imageUrl= imageResponse.getResult().getOutput().getUrl();
		//response.sendRedirect(imageUrl);
		List<String> imageUrls = imageResponse.getResults().stream()
			.map(result -> result.getOutput().getUrl())
			.toList();
		return imageUrls;
	}
}

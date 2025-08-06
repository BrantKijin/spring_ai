package kr.study.spring_ai.controller.openapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/ask-ai-view")
	public String askAiView() {
		return "ask";
	}

	@GetMapping("/image-ai-view")
	public String imageAiView() {
		return "image";
	}

	@GetMapping("/image-voice-ai-view")
	public String imageVoiceAiView() {
		return "imagev";
	}

	@GetMapping("/image-analysis-ai-view")
	public String imageAnalysisAiView() {
		return "imageview";
	}

	@GetMapping("/tts-ai-view")
	public String ttsAiView() {
		return "tts";
	}

	@GetMapping("/stt-ai-view")
	public String sstAiView() {
		return "stt";
	}

	@GetMapping("/rag-ai-view")
	public String ragAiView() {
		return "rag";
	}

	@GetMapping("/rag-hotel-ai-view")
	public String ragHotelAiView() {
		return "hotel";
	}
}

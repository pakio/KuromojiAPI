package com.pakio.kuromojiapi.controller;

import com.atilika.kuromoji.TokenizerBase.Mode;
import com.pakio.kuromojiapi.response.AnalysisResponse;
import com.pakio.kuromojiapi.service.KuromojiService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class AnalysisController {
  @Autowired
  KuromojiService kuromojiService;

  @RequestMapping(value="/analysis")
  public AnalysisResponse getAnalysisResult(
      @RequestParam("text") String text,
      @RequestParam(value = "mode", required = false, defaultValue = "normal") String mode) {
    Mode m;
    try {
      m = Mode.valueOf(mode.toUpperCase());
    } catch (Exception e) {
      m = Mode.NORMAL;
    }
    Map<Integer, String> surfaces = kuromojiService.parseWithKuromoji(text, m);

    return new AnalysisResponse(surfaces, text, m);
  }
}

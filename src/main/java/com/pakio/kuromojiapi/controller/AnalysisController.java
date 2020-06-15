package com.pakio.kuromojiapi.controller;

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
  public AnalysisResponse getAnalysisResult(@RequestParam("text") String text) {
    Map<Integer, String> surfaces = kuromojiService.parseWithKuromoji(text);

    return new AnalysisResponse(surfaces);
  }
}

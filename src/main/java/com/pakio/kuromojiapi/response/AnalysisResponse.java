package com.pakio.kuromojiapi.response;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnalysisResponse {
  private Map<Integer, String> surfaces;

  private String originalText;
}

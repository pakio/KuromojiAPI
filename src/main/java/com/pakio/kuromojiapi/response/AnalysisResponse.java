package com.pakio.kuromojiapi.response;

import com.atilika.kuromoji.TokenizerBase.Mode;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnalysisResponse {
  private Map<Integer, String> surfaces;

  private String originalText;

  private Mode mode;
}

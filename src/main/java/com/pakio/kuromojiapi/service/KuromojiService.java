package com.pakio.kuromojiapi.service;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class KuromojiService {
  private static Tokenizer tokenizer;

  public KuromojiService() {
    tokenizer = new Tokenizer();
  }

  public List<Token> parseWithKuromoji(String text){
    List<Token> tokens = this.tokenizer.tokenize(text);
    return tokens;
  }
}

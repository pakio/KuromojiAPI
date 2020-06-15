package com.pakio.kuromojiapi.service;

import com.atilika.kuromoji.TokenBase;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class KuromojiService {
  private static Tokenizer tokenizer;

  public KuromojiService() {
    tokenizer = new Tokenizer();
  }

  public Map<Integer, String> parseWithKuromoji(String text){
    List<Token> tokens = tokenizer.tokenize(text);

    AtomicInteger i = new AtomicInteger();
    return tokens.stream()
        .collect(Collectors.toMap(
            s -> i.getAndIncrement(),
            TokenBase::getSurface
        ));
  }
}

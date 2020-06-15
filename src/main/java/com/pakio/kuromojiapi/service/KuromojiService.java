package com.pakio.kuromojiapi.service;

import com.atilika.kuromoji.TokenBase;
import com.atilika.kuromoji.TokenizerBase.Mode;
import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class KuromojiService {
  private static HashMap<Mode, Tokenizer> tokenizerHashMap;

  public KuromojiService() {
    tokenizerHashMap = new HashMap<>();
    tokenizerHashMap.put(Mode.NORMAL, new Tokenizer.Builder().mode(Mode.NORMAL).build());
    tokenizerHashMap.put(Mode.SEARCH, new Tokenizer.Builder().mode(Mode.SEARCH).build());
    tokenizerHashMap.put(Mode.EXTENDED, new Tokenizer.Builder().mode(Mode.EXTENDED).build());
  }

  public Map<Integer, String> parseWithKuromoji(String text, Mode mode){
    List<Token> tokens = tokenizerHashMap.get(mode).tokenize(text);

    AtomicInteger i = new AtomicInteger();
    return tokens.stream()
        .collect(Collectors.toMap(
            s -> i.getAndIncrement(),
            TokenBase::getSurface
        ));
  }
}

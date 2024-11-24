package pl.put.poznan.transformer.logic;

import java.util.HashMap;
import java.util.Map;

public class ShortenTextTransformer extends TransformerDecorator {
    private static final Map<String, String> KEYWORD_MAP = new HashMap<>();
    static {
        KEYWORD_MAP.put("bułki i chleb", "pieczywo");
        KEYWORD_MAP.put("herbata i kawa.", "napoje");
        KEYWORD_MAP.put("koty i psy", "zwierzęta");
        KEYWORD_MAP.put("motory i auta", "pojazdy");
    }

    public ShortenTextTransformer(Transformer transformer) {
        super(transformer);
    }

    @Override
    public String transform(String text) {
        for (Map.Entry<String, String> entry : KEYWORD_MAP.entrySet()) {
            String keyword = entry.getKey();
            String expansion = entry.getValue();
            text = text.replaceAll("\\b" + keyword + "\\b", expansion);
        }
        return text;
    }
}
package com.mykumi.util;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.util.TokenBuffer;

public final class JsonUtil {
    /**
     * Object to Json
     */
    public static String marshallingJson(Object object) throws Exception {
        TokenBuffer buffer = new TokenBuffer(null);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(buffer, object);
        JsonNode root = objectMapper.readTree(buffer.asParser());
        String jsonText = objectMapper.writeValueAsString(root);
        jsonText = jsonText.replaceAll("null", "\"\"");
        
        return jsonText;
    }

    /**
     * Json to Object
     */
    public static <T> T unmarshallingJson(String jsonText, Class<T> valueType) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return (T) objectMapper.readValue(jsonText, valueType);
    }
}

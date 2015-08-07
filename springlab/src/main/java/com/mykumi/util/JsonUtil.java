package com.mykumi.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.util.TokenBuffer;

public final class JsonUtil {
    /**
     * Object to Json
     * @throws IOException 
     * @throws JsonMappingException 
     * @throws JsonGenerationException 
     */
    public static String marshallingJson(Object object) {
    	try {
            TokenBuffer buffer = new TokenBuffer(null);
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(buffer, object);
            JsonNode root = objectMapper.readTree(buffer.asParser());
            String jsonText = objectMapper.writeValueAsString(root);
            jsonText = jsonText.replaceAll("null", "\"\"");
            return jsonText;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }

    /**
     * Json to Object
     */
    public static <T> T unmarshallingJson(String jsonText, Class<T> valueType) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return (T) objectMapper.readValue(jsonText, valueType);
    }
}

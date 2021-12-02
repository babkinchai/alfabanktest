package org.example.tests.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.example.tests.dto.GifDto;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
@Configuration
public class GifDtoDeserializer extends StdDeserializer<GifDto> {

    public GifDtoDeserializer () {
        this(null);
    }

    public GifDtoDeserializer (Class< ? > vc) {
        super(vc);
    }

    @Override
    public GifDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode gifDtoNode = p.getCodec().readTree(p);
        return new GifDto(gifDtoNode.get("data")
                .get("images")
                .get("downsized_large")
                .get("url").textValue());
    }

}

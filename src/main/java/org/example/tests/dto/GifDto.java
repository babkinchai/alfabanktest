package org.example.tests.dto;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.tests.config.GifDtoDeserializer;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
@JsonDeserialize(using = GifDtoDeserializer.class)
public class GifDto {

    @JsonProperty("url")
    private String url;
}

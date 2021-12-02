package org.example.tests.feing;

import org.example.tests.dto.GifDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${gif.service.url}/v1/gifs/",value = "gif-client", primary = false)
public interface GifRequestFeing {

    @GetMapping(value = "random?api_key=${gif.service.appid}&tag=rich")
    public GifDto getRichTag();

    @GetMapping(value = "random?api_key=${gif.service.appid}&tag=broke")
    public GifDto getBrokeTag();
}

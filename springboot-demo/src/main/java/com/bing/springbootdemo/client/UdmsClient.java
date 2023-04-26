package com.bing.springbootdemo.client;

import com.bing.springbootdemo.config.FeignErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: gujunwei
 * @date: 2021/3/12 15:52
 * @version: 1.0
 */
@FeignClient(value = "udms", configuration = {FeignErrorDecoder.class}, url = "http://172.16.213.169:19210")
public interface UdmsClient {

    @GetMapping(value = "/udms/device/events/fromId")
    String findByFromId(@RequestParam("lastId") Integer lastId, @RequestParam("apiToken") String apiToken);

}

package com.bing.springbootdemo.config;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignErrorDecoder extends ErrorDecoder.Default {

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception exception = super.decode(methodKey, response);

        // 如果是RetryableException，则返回继续重试
        if (exception instanceof RetryableException) {
            return exception;
        } else {
            // 可以自定义一些逻辑，比如抛出一个其他的(统一个异常)
            exception = new RuntimeException("Feign调用出错了");
        }
        return exception;
    }
}

package com.bing.springbootdemo.controller;

import com.bing.springbootdemo.client.UdmsClient;
import com.bing.springbootdemo.listener.MyApplicationEvent;
import com.bing.springbootdemo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class MyController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    TestService testService;

    @Resource
    UdmsClient udmsClient;

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @PostMapping(value = "/publish")
    public void publishEvent(@RequestBody String message) {
        log.info("publishEvent");
        applicationContext.publishEvent(new MyApplicationEvent(this, message));
    }

    @GetMapping(value = "/test")
    public void test() {
        testService.test();
    }


    @GetMapping(value = "/httpTest")
    public void CloeWaitTest(String hostIp) {
        try{
            String strJson = udmsClient.findByFromId(10000, "comkedacomhamsudms");
            log.info("json: " + strJson);
        }catch (Exception e){
            log.error(e.getMessage());
        }

//        Retryer retryer = new Retryer.Default(100, 1000, 2);
//        Request.Options options = new Request.Options(2 * 1000, 5 * 1000);
//        String burnUrl = "http://" + hostIp + ":" + 19210;
//        BurnClient burnClient =
//                Feign.builder().contract(new SpringMvcContract())
//                        .options(options)
//                        .logLevel(feign.Logger.Level.FULL)
//                        .decoder(new Decoder() {
//                            @Override
//                            public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
//                                log.info("type: " + type);
//                                return null;
//                            }
//                        })
//                        .encoder(new Encoder() {
//                            @Override
//                            public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
//                                log.info("body type: " + bodyType);
//                            }
//                        })
////                        .errorDecoder(new ErrorDecoder() {
////                            @Override
////                            public Exception decode(String methodKey, Response response) {
////                                log.info("key: " + methodKey);
////                                ServiceException exception = new ServiceException(500, "feign error: " + response.status());
////                                return exception;
////                            }
////                        })
//                        .retryer(retryer).target(BurnClient.class, burnUrl);
//
//        try {
//            String userInfo = burnClient.findUserInfo("222");
//            log.info(userInfo);
//        } catch (RetryableException e){
//            log.info("..........");
//        }catch (FeignException e){
//            log.info(".......");
//        } catch (Exception e) {
//            if( e instanceof ServiceException){
//                log.info("e");
//            }
//            log.error(e.getMessage());
//        }

    }

}

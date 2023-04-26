package com.bing.springbootdemo.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Server {
    private String name;
    private String port;
    private String shutdown;

    private List<Service> serviceList = new ArrayList<>();

    public void addService(Service service){
        serviceList.add(service);
    }

    public void  printPort(){
        System.out.println("my port is "+port);
    }

    @Data
    public static class Service {
        public String  name;
    }

}

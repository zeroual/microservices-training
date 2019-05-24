package com.zenika.service1;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Service1ApplicationTests {

    @Autowired
    DiscoveryClient discoveryClient;


    @Autowired
    private RestTemplate restTemplate;



    @Test
    public void contextLoads() {
        List<ServiceInstance> instances = discoveryClient.getInstances("service2");
        Assertions.assertThat(instances).isNotEmpty();
    }

    @Test
    public void name() {
        String name = restTemplate.getForObject("http://service2/name", String.class);
        Assertions.assertThat(name).isNotNull();
    }
}

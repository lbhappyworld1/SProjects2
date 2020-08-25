package com.zpc.order.service;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.zpc.order.entity.Item;
import com.zpc.order.properties.OrderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {

    // Spring框架对RESTful方式的http请求做了封装，来简化操作
    @Autowired
    private RestTemplate restTemplate;

    //@Value("${myspcloud.item.url}")
    //private String itemUrl;

    @Autowired
    OrderProperties orderProperties;

    @NacosValue(value = "${itemUrlConfig:'http://127.0.0.1:8100/'}", autoRefreshed = true)
    private String itemUrl;

    public Item queryItemById(Long id) {
        return this.restTemplate.getForObject(itemUrl+"item/" + id, Item.class);
    }
}


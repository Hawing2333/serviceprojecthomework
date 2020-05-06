package edu.neu.springcloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	//private static final String REST_URL_PREFIX = "http://localhost:8003";
	private static final String REST_URL_PREFIX = "http://provider";

		/**
		 * 使用 使用restTemplate访问restful接口非常的简单。
		 */
		@Autowired
		private RestTemplate restTemplate;

		@RequestMapping("consumer/findAll")
		public Object findAll(){
			return restTemplate.getForObject(REST_URL_PREFIX + "/customers/findAll",Object.class);
		}

		@RequestMapping("consumer/find/{id}")
		public Object find(@PathVariable String id){
			return restTemplate.getForObject(REST_URL_PREFIX + "/customers/find/" + id,Object.class);
		}

		// 测试@EnableDiscoveryClient,消费端可以调用服务发现
		@RequestMapping(value = "/consumer/discovery")
		public Object discovery()
		{
			return restTemplate.getForObject(REST_URL_PREFIX + "/country/discovery", Object.class);
		}
	

}

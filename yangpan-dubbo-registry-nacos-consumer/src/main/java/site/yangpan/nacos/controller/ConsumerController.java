package site.yangpan.nacos.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.api.DubboApiService;

/**
 * 服务消费者Controller
 * 通过@DubboReference注解，可以注入服务接口的具体实现，从而进行服务间调用
 * @author yangpan
 * @date 2020-08-31 13:55
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@DubboReference(version = "${yangpan.dubbo.service.version}", methods = {
		@Method(name = "sayHello", timeout = 300)
	})
	private DubboApiService dubboApiService;

	@GetMapping("/sayHello")
	public String sayHello(){
		return dubboApiService.sayHello("yangpan");
	}
}

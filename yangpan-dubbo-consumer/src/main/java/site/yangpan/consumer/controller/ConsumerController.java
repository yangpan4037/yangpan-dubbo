package site.yangpan.consumer.controller;

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

	/**
	 * 我们可以看到这里写了url,相当于我们的请求实际上调用的是服务提供者实现的方法
	 * 那如果服务提供者进行了集群，这里的url怎么办？所以注册中心就呼之欲出了~
	 * 总结：没有注册中心的情况下，我们可以指定具体的url来进行服务调用
	 */
	@DubboReference(
		version = "1.0.0",
		url = "dubbo://127.0.0.1:12345",
		timeout = 100,
		methods = {
			@Method(name = "sayHello", timeout = 300)
		}
	)
	private DubboApiService dubboApiService;

	@GetMapping("/sayHello")
	public String sayHello(){
		return dubboApiService.sayHello("yangpan");
	}
}

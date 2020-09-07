package site.yangpan.redis.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import site.yangpan.api.DubboApiService;

import java.util.Random;

/**
 * dubbo服务提供者，他需要是实现公共的服务接口也就是 yangpan-dubbo-api 模块下的接口
 * @author yangpan
 * @date 2020-08-31 13:47
 */
@DubboService(version = "${yangpan.dubbo.service.version}")
public class DefaultDubboApiService implements DubboApiService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final Random costTimeRandom = new Random();

	/**
	 * 默认情况下dubbo.application.name是${spring.application.name}
	 */
	@Value("${dubbo.application.name}")
	private String serviceName;

	@Value("${server.port}")
	private Integer serverPort;

	@Override
	public String sayHello(String name) {
		//这里模拟业务执行
		await();
		return String.format("[%s:%s] : Hello, %s", serviceName, serverPort, name);
	}

	/**
	 * 该方法作用有两点：
	 * 1.模拟业务执行所需要的时间
	 * 2.体现了在消费者端设置的服务调用的超时时间的作用（详细请了解@DubboReference）
	 */
	private void await() {
		try {
			long timeInMillisToWait = costTimeRandom.nextInt(500);
			Thread.sleep(timeInMillisToWait);
			logger.info("execution time : " + timeInMillisToWait + " ms.");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}

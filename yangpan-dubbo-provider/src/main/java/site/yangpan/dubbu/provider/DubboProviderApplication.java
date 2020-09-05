package site.yangpan.dubbu.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 注解@EnableDubbo 是 @EnableDubboConfig 和 @DubboComponentScan两者组合的便捷表达方式。
 * 通过 @EnableDubbo 可以在指定的包名下（通过 scanBasePackages），或者指定的类中（通过 scanBasePackageClasses）
 * 扫描 Dubbo 的服务提供者（以 @DubboService 标注）以及 Dubbo 的服务消费者（以 DubboReference 标注）。
 * 扫描到 Dubbo 的服务提供方和消费者之后，对其做相应的组装并初始化，并最终完成服务暴露或者引用的工作。
 */
@EnableDubbo
@SpringBootApplication
public class DubboProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboProviderApplication.class, args);
	}

}

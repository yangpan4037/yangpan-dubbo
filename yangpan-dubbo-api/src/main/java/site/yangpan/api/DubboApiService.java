package site.yangpan.api;

/**
 * yangpan-dubbo-api 模块只提供接口，不需要实现
 * 服务提供模块需要依赖 yangpan-dubbo-api 模块并实现这个接口
 * 服务消费模块需要依赖 yangpan-dubbo-api 模块但不需要实现这个接口，通过dubbo调用这个方法
 * @author yangpan
 * @date 2020-08-31 13:25
 */
public interface DubboApiService {
	String sayHello(String name);
}

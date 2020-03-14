package com.sunpeifu.demo.feign;

import com.ms.user.api.server.UserControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Date 2020/1/9 6:29 下午
 * @Author daike
 * @Description
 */
//@FeignClient(name = "ms-icp-user" , url = "http://localhost:8081")
public interface FeginService extends UserControllerApi {

}

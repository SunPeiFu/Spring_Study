package com.sunpeifu.demo.controller;

import com.ms.user.api.domain.dto.ChannelDTO;
import com.sunpeifu.demo.feign.FeginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Date 2020/1/9 6:28 下午
 * @Author daike
 * @Description
 */
@RestController
public class TestController {
    @Resource
    private FeginService feginService;

    @GetMapping("testMapping")
    public Object testMapping(){
        ChannelDTO channelDTO = new ChannelDTO();
        channelDTO.setCid("1Lk9GRT43ii");
        return feginService.getChannelInfo(channelDTO);
    }
}

package com.baomidou.mybatisplus.test.web.odps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author wanchenghuang
 * @since 2020-12-19
 */
@RestController
@RequestMapping("/odps")
public class OdpsController {

    @Autowired
    private OdpsService service;

    /**
     *
     * @return
     */
    @GetMapping("/test")
    public List<String> test(){
        return service.getSpeechAudioVin();
    }


}


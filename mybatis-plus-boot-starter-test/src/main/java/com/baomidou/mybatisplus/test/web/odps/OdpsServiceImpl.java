package com.baomidou.mybatisplus.test.web.odps;

import com.baomidou.mybatisplus.test.datasource.TargetDataSource;
import com.baomidou.mybatisplus.test.web.mapper.OdpsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author vanchan
 * @Date 2022/12/23 13:54
 * @Version 1.0
 * <p>
 * description：
 */
@Service
public class OdpsServiceImpl implements OdpsService {

    @Autowired
    private OdpsMapper mapper;

    @Override
    @TargetDataSource(name = "odps")
    public List<String> getSpeechAudioVin() {
        return mapper.getSpeechAudioVin();
    }
}

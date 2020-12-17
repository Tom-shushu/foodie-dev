package com.zhouhong.service.impl;

import com.zhouhong.mapper.CarouselMapper;
import com.zhouhong.pojo.Carousel;
import com.zhouhong.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName: CarouselService
 * @Description:
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/16
 **/
@Service
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselMapper carouselMapper;

    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public List<Carousel> queryAll(Integer isShow) {

        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria =  example.createCriteria();
        criteria.andEqualTo("isShow" ,isShow);

        List<Carousel> result = carouselMapper.selectByExample(example);

        return result;
    }
}

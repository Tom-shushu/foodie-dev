package com.zhouhong.service;

import com.zhouhong.pojo.Carousel;

import java.util.List;

/**
 * @ClassName: CarouselService
 * @Description:
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/16
 **/
public interface CarouselService {

    /**
     * 查询所有轮播图列表
     * @param isShow
     * @return
     */
    public List<Carousel> queryAll(Integer isShow);
}

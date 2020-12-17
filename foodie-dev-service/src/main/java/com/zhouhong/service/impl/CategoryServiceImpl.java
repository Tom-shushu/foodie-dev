package com.zhouhong.service.impl;

import com.zhouhong.mapper.CategoryMapper;
import com.zhouhong.mapper.CategoryMapperCustom;
import com.zhouhong.pojo.Carousel;
import com.zhouhong.pojo.Category;
import com.zhouhong.pojo.vo.CategoryVO;
import com.zhouhong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName: CategoryServiceImpl
 * @Description:
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/16
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public List<Category> querAllRootLeveCat() {

        Example example = new Example(Category.class);
        Example.Criteria criteria =  example.createCriteria();
        criteria.andEqualTo("type" ,1);

        List<Category> result = categoryMapper.selectByExample(example);

        return result;
    }

    @Transactional(propagation = Propagation.SUPPORTS )
    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryMapperCustom.getSubCatList(rootCatId);
    }


}

package com.zhouhong.mapper;


import com.zhouhong.my.mapper.MyMapper;
import com.zhouhong.pojo.Category;
import com.zhouhong.pojo.vo.CategoryVO;

import java.util.List;

/**
 * @author zhouhong
 */
public interface CategoryMapperCustom {

    public List<CategoryVO> getSubCatList(Integer rootCatId);

}
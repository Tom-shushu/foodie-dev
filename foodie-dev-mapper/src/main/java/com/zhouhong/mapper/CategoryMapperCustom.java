package com.zhouhong.mapper;


import com.zhouhong.my.mapper.MyMapper;
import com.zhouhong.pojo.Category;
import com.zhouhong.pojo.vo.CategoryVO;
import com.zhouhong.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhouhong
 */
public interface CategoryMapperCustom {

    public List<CategoryVO> getSubCatList(Integer rootCatId);

    public List<NewItemsVO> getSixNewItemLazy(@Param("paramsMap") Map<String , Object> map);

}
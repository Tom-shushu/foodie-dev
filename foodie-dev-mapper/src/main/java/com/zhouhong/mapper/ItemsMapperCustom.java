package com.zhouhong.mapper;


import com.zhouhong.my.mapper.MyMapper;
import com.zhouhong.pojo.Items;
import com.zhouhong.pojo.vo.ItemCommentVO;
import com.zhouhong.pojo.vo.SearchItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {

    public List<ItemCommentVO> queryItemComments(@Param("paramsMap")Map<String, Object> map);

    public List<SearchItemsVO> searchItems(@Param("paramsMap")Map<String, Object> map);

    public List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap")Map<String, Object> map);
}
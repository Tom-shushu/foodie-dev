package com.zhouhong.service;

import com.zhouhong.pojo.Category;
import com.zhouhong.pojo.vo.CategoryVO;
import com.zhouhong.pojo.vo.NewItemsVO;

import java.util.List;

/**
 * @ClassName: CategoryService
 * @Description:
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/16
 **/
public interface CategoryService {

    /**
     * 查询所有一级分类
     * @return
     */
    public List<Category> querAllRootLeveCat();

    /**
     * 根据一级分类信息查询子分类信息
     * @param rootCatId
     * @return
     */
    public List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 查询首页每个一级分类下的六条最新商品数据
     * @param rootCatId
     * @return
     */
    public List<NewItemsVO> getSixNewItemLazy(Integer rootCatId);
}

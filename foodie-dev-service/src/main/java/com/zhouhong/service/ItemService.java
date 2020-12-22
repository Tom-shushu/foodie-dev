package com.zhouhong.service;

import com.zhouhong.pojo.Items;
import com.zhouhong.pojo.ItemsImg;
import com.zhouhong.pojo.ItemsParam;
import com.zhouhong.pojo.ItemsSpec;
import com.zhouhong.pojo.vo.CommentLevelCountsVO;
import com.zhouhong.pojo.vo.ItemCommentVO;
import com.zhouhong.pojo.vo.ShopcartVO;
import com.zhouhong.utils.PagedGridResult;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @ClassName: ItemService
 * @Description:
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/20
 **/
public interface ItemService  {

    /**
     * 根据商品id查询详情
     * @param itemId
     * @return
     */
    public Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品属性（参数）
     * @param itemId
     * @return
     */
    public ItemsParam queryItemParamList(String itemId);

    /**
     * 根据商品id查询商品的评价等级
     * @param itemId
     */
    public CommentLevelCountsVO queryCommentsCounts(String itemId);

    /**
     * 根据商品id查询商品的评价（分页）
     * @param itemId
     * @param level
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);

    /**
     * 根据关键字搜索商品列表（分页）
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searchItems(String keywords, String sort, Integer page, Integer pageSize);

    /**
     * 根据分类id搜索商品列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult searchItemsByThirdCat(Integer catId, String sort, Integer page, Integer pageSize);

    /**
     * 根据规格ids查询最新的购物车中商品数据（用于刷新渲染购物车中的商品数据）
     * @param specIds
     * @return
     */
    public List<ShopcartVO> queryItemsBySpecIds(String specIds);
}

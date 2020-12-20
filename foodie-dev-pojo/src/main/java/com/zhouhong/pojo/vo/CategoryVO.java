package com.zhouhong.pojo.vo;

/**
 * @ClassName: CategoryVO
 * @Description:数据库到页面展示页面的数据,分类
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/17
 **/

import java.util.List;

/**
 * 二级分类VO 数据库到页面展示页面的数据
 */
public class CategoryVO {
    private Integer id;
    private String name;
    private String type;
    private String fatherId;
    //三级分类
    private List<SubCategoryVO> subCatList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public List<SubCategoryVO> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<SubCategoryVO> subCatList) {
        this.subCatList = subCatList;
    }
}

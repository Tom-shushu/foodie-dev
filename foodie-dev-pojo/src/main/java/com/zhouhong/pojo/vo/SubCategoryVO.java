package com.zhouhong.pojo.vo;

/**
 * @ClassName: SubCategoryVO
 * @Description:  三级分类查询的数据
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/17
 **/
public class SubCategoryVO {
    private Integer subId;
    private String subName;
    private String subType;
    private String subFatherId;

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSubFatherId() {
        return subFatherId;
    }

    public void setSubFatherId(String subFatherId) {
        this.subFatherId = subFatherId;
    }
}

package com.zhouhong.pojo.vo;

import java.util.Date;

/**
 * @ClassName: ItemCommentVO
 * @Description: 用于展示商品评价的VO
 * @Author: 周红
 * @NickName: Tom-shuhu
 * @Date: Created in 2020/12/20
 **/
public class ItemCommentVO {

    private Integer commentLevel;
    private String  content;
    private String sepcName;
    private Date createdTime;
    private String userFace;
    private String nickName;

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSepcName() {
        return sepcName;
    }

    public void setSepcName(String sepcName) {
        this.sepcName = sepcName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

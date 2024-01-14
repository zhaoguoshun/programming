package com.wanou.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 用户举报对象 tb_report
 *
 * @author ruoyi
 * @date 2024-01-14
 */
public class TbReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 举报标题 */
    @Excel(name = "举报标题")
    private String title;

    /** 举报内容 */
    @Excel(name = "举报内容")
    private String contentText;

    /** 举报人 */
    @Excel(name = "举报人")
    private Long userId;

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setContentText(String contentText)
    {
        this.contentText = contentText;
    }

    public String getContentText()
    {
        return contentText;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("contentText", getContentText())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .toString();
    }
}

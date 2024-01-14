package com.wanou.project.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.wanou.framework.aspectj.lang.annotation.Excel;
import com.wanou.framework.web.domain.BaseEntity;

/**
 * 敏感词管理对象 tb_sensitive
 *
 * @author ruoyi
 * @date 2024-01-14
 */
public class TbSensitive extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 敏感词 */
    @Excel(name = "敏感词")
    private String word;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWord(String word)
    {
        this.word = word;
    }

    public String getWord()
    {
        return word;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("word", getWord())
            .append("createTime", getCreateTime())
            .toString();
    }
}

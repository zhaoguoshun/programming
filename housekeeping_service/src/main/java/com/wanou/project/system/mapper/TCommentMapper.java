package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TComment;
import com.wanou.project.system.domain.vo.ThumbsVo;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-10-28
 */
public interface TCommentMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public TComment selectTCommentById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tComment 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TComment> selectTCommentList(TComment tComment);


    List<ThumbsVo> getCommentMy(Long userId);

    /**
     * 新增【请填写功能名称】
     *
     * @param tComment 【请填写功能名称】
     * @return 结果
     */
    public int insertTComment(TComment tComment);

    /**
     * 修改【请填写功能名称】
     *
     * @param tComment 【请填写功能名称】
     * @return 结果
     */
    public int updateTComment(TComment tComment);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteTCommentById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTCommentByIds(List<Long> ids);
}

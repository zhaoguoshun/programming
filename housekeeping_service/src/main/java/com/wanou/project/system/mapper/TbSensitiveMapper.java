package com.wanou.project.system.mapper;

import java.util.List;
import com.wanou.project.system.domain.TbSensitive;

/**
 * 敏感词管理Mapper接口
 *
 * @author ruoyi
 * @date 2024-01-14
 */
public interface TbSensitiveMapper
{
    /**
     * 查询敏感词管理
     *
     * @param id 敏感词管理主键
     * @return 敏感词管理
     */
    public TbSensitive selectTbSensitiveById(Long id);

    /**
     * 查询敏感词管理列表
     *
     * @param tbSensitive 敏感词管理
     * @return 敏感词管理集合
     */
    public List<TbSensitive> selectTbSensitiveList(TbSensitive tbSensitive);

    /**
     * 新增敏感词管理
     *
     * @param tbSensitive 敏感词管理
     * @return 结果
     */
    public int insertTbSensitive(TbSensitive tbSensitive);

    /**
     * 修改敏感词管理
     *
     * @param tbSensitive 敏感词管理
     * @return 结果
     */
    public int updateTbSensitive(TbSensitive tbSensitive);

    /**
     * 删除敏感词管理
     *
     * @param id 敏感词管理主键
     * @return 结果
     */
    public int deleteTbSensitiveById(Long id);

    /**
     * 批量删除敏感词管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTbSensitiveByIds(Long[] ids);
}

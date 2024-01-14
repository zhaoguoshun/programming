package com.wanou.project.system.service.impl;

import java.util.List;
import com.wanou.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wanou.project.system.mapper.TbSensitiveMapper;
import com.wanou.project.system.domain.TbSensitive;
import com.wanou.project.system.service.ITbSensitiveService;

/**
 * 敏感词管理Service业务层处理
 *
 * @author ruoyi
 * @date 2024-01-14
 */
@Service
public class TbSensitiveServiceImpl implements ITbSensitiveService
{
    @Autowired
    private TbSensitiveMapper tbSensitiveMapper;

    /**
     * 查询敏感词管理
     *
     * @param id 敏感词管理主键
     * @return 敏感词管理
     */
    @Override
    public TbSensitive selectTbSensitiveById(Long id)
    {
        return tbSensitiveMapper.selectTbSensitiveById(id);
    }

    /**
     * 查询敏感词管理列表
     *
     * @param tbSensitive 敏感词管理
     * @return 敏感词管理
     */
    @Override
    public List<TbSensitive> selectTbSensitiveList(TbSensitive tbSensitive)
    {
        return tbSensitiveMapper.selectTbSensitiveList(tbSensitive);
    }

    /**
     * 新增敏感词管理
     *
     * @param tbSensitive 敏感词管理
     * @return 结果
     */
    @Override
    public int insertTbSensitive(TbSensitive tbSensitive)
    {
        tbSensitive.setCreateTime(DateUtils.getNowDate());
        return tbSensitiveMapper.insertTbSensitive(tbSensitive);
    }

    /**
     * 修改敏感词管理
     *
     * @param tbSensitive 敏感词管理
     * @return 结果
     */
    @Override
    public int updateTbSensitive(TbSensitive tbSensitive)
    {
        return tbSensitiveMapper.updateTbSensitive(tbSensitive);
    }

    /**
     * 批量删除敏感词管理
     *
     * @param ids 需要删除的敏感词管理主键
     * @return 结果
     */
    @Override
    public int deleteTbSensitiveByIds(Long[] ids)
    {
        return tbSensitiveMapper.deleteTbSensitiveByIds(ids);
    }

    /**
     * 删除敏感词管理信息
     *
     * @param id 敏感词管理主键
     * @return 结果
     */
    @Override
    public int deleteTbSensitiveById(Long id)
    {
        return tbSensitiveMapper.deleteTbSensitiveById(id);
    }
}

package com.wanou.project.system.service;

import java.util.List;
import com.wanou.project.system.domain.TbMusic;

/**
 * 音乐Service接口
 *
 * @author ruoyi
 * @date 2023-04-01
 */
public interface ITbMusicService
{
    /**
     * 查询音乐
     *
     * @param id 音乐主键
     * @return 音乐
     */
    public TbMusic selectTbMusicById(Long id);

    /**
     * 查询音乐列表
     *
     * @param tbMusic 音乐
     * @return 音乐集合
     */
    public List<TbMusic> selectTbMusicList(TbMusic tbMusic);

    /**
     * 新增音乐
     *
     * @param tbMusic 音乐
     * @return 结果
     */
    public int insertTbMusic(TbMusic tbMusic);

    /**
     * 修改音乐
     *
     * @param tbMusic 音乐
     * @return 结果
     */
    public int updateTbMusic(TbMusic tbMusic);

    /**
     * 批量删除音乐
     *
     * @param ids 需要删除的音乐主键集合
     * @return 结果
     */
    public int deleteTbMusicByIds(Long[] ids);

    /**
     * 删除音乐信息
     *
     * @param id 音乐主键
     * @return 结果
     */
    public int deleteTbMusicById(Long id);
}

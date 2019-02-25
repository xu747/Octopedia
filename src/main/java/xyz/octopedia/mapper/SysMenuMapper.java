package xyz.octopedia.mapper;

import xyz.octopedia.entity.ins.AuthMenuTreeIns;
import xyz.octopedia.entity.sys.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Charles Xu
 * @since 2018-09-29
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 通过用户id 获取菜单
     *
     * @param userId
     * @return
     */
    List<SysMenu> getMenuByUserId(Integer userId);

    /**
     * 通过角色id 获取菜单
     *
     * @param roleId
     * @return
     */
    List<SysMenu> getMenuByRoleId(Integer roleId);


    List<AuthMenuTreeIns> getMenuTreeByUserId(Integer userId);

    /**
     * 权限树
     *
     * @param parentId 指定根菜单
     * @return
     */
    List<AuthMenuTreeIns> getMenuTree(@Param("parentId") Integer parentId);
}

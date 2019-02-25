package xyz.octopedia.service.sys;

import xyz.octopedia.entity.ins.SingleUserRolesBoIns;
import xyz.octopedia.entity.ins.UserRoleAllocationBoIns;
import xyz.octopedia.entity.sys.SysRole;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Charles Xu
 * @since 2018-09-29
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 通过用户id 查询用户的角色
     *
     * @param userId
     * @return
     */
    List<SysRole> getRoleByUserId(Integer userId);

    /**
     * 获取当前用户角色
     *
     * @param userId
     * @return
     */
    List<String> getRoleStrByUserId(Integer userId);

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param search   支持名称模糊查询
     * @return
     */
    IPage<SysRole> page(int pageNum, int pageSize, String search);

    /**
     * 保存角色
     *
     * @param role
     * @return
     */
    String saveRole(SysRole role);

    /**
     * 新建或编辑角色时查询角色代码已存在
     *
     * @param code
     * @param name
     * @param id
     * @return boolean
     */

    boolean queryRoleCodeNameExist(String code, String name, Integer id);

    /**
     * 分页查询所有用户已分配角色
     *
     * @param pageNum
     * @param pageSize
     * @param search   支持用户名模糊查询,可传null
     * @param order    支持排序,可传null
     * @return UserRoleAllocationBo
     */
    IPage<UserRoleAllocationBoIns> queryUserRoleByPage(String search, Integer pageNum, Integer pageSize,
                                                       String order);

    /**
     * 更新用户角色关系
     *
     * @param userId
     * @param roleIds
     * @return
     */
    void updateUserRoles(Integer userId, List<Integer> roleIds) throws RuntimeException;

    /**
     * 插入单个角色
     *
     * @param userId
     * @param roleId
     * @return
     */
    void updateUserRole(String userId, String roleId) throws RuntimeException;

    /**
     * 查询单个用户角色是否存在
     *
     * @param userId
     * @param roleId
     * @return boolean
     */
    boolean queryExistUserRole(String userId, String roleId);

    /**
     * 根据用户ID查询所有角色的分配情况
     *
     * @param userId
     * @return SingleUserRoleAllocationBo
     */
    List<SingleUserRolesBoIns> queryRoleAllocationByUserId(String userId);

    /**
     * 根据用户ID删除所有已分配角色
     *
     * @param userId
     * @return
     */
    void deleteAllRoleByUserId(int userId) throws RuntimeException;

    /**
     * 用户角色分配页面，查询翻页总数据量
     *
     * @return int
     */
    int queryNumOfUser();

    /**
     * 删除角色前查询角色下是否已分配权限
     *
     * @param roleId
     * @return int
     */
    int queryPerAllocationNumOfRole(int roleId);
}

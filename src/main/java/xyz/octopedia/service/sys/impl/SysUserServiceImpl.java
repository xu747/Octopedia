package xyz.octopedia.service.sys.impl;

import xyz.octopedia.base.CommonConstant;
import xyz.octopedia.entity.sys.SysUser;
import xyz.octopedia.mapper.SysUserMapper;
import xyz.octopedia.service.sys.SysUserService;
import xyz.octopedia.util.Digests;
import xyz.octopedia.util.LoggerUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Charles Xu
 * @since 2018-09-29
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public SysUser getUserByUserName(String userName) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq(true, "username", userName);
        return getOne(wrapper);
    }

    @Override
    public IPage<SysUser> page(Integer pageNum, Integer pageSize, String search) {

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        if (StringUtils.isNoneEmpty(search)) {
            wrapper.like(true, "username", "%" + search + "%")
                    .like(true, "nickname", "%" + search + "%")
                    .like(true, "email", "%" + search + "%")
                    .like(true, "telephone", "%" + search + "%");
        }
        Page<SysUser> page = new Page<>(pageNum, pageSize);
        return sysUserMapper.selectPage(page, wrapper);
    }

    @Override
    public String saveUser(SysUser user) throws RuntimeException {

        Date date = new Date();
        if (user.getId() != null) {
            user.setModifyTime(date);
            updateById(user);
        } else {

            user.setCreateTime(date);
            user.setModifyTime(date);
            user.setStatus(CommonConstant.ONE); //有效
            String password = Digests.shaHex(user.getPassword(), user.getUsername());
            user.setPassword(password);
            try {
                sysUserMapper.insert(user);
            } catch (Exception e) {
                throw new RuntimeException("添加用户失败");
            }
        }
        return "操作成功";

    }

    /**
     * 修改密码
     *
     * @param id ,password
     * @return
     */
    @Override
    public String updateUserPwd(String password, Integer id) throws RuntimeException {
        SysUser user = sysUserMapper.selectById(id);
        Date date = new Date();
        user.setModifyTime(date);
        if (null != user) {
            try {
                String encryptP = Digests.shaHex(password, user.getUsername());
                user.setPassword(encryptP);
                int flag = sysUserMapper.updateById(user);
                if (flag == 0) {
                    return CommonConstant.Message.OPTION_FAILURE;
                }
            } catch (Exception e) {
                throw new RuntimeException("更新用户密码失败");
            }

        }
        return CommonConstant.Message.OPTION_SUCCESS;
    }

    @Override
    public String updateLoginTime(Integer id) throws RuntimeException {
        SysUser user = new SysUser();
        user.setId(id);
        user.setLastLoginTime(new Date());
        boolean flag = updateById(user);
        if (flag) {
            return CommonConstant.Message.OPTION_FAILURE;
        }
        return CommonConstant.Message.OPTION_SUCCESS;
    }

    @Override
    public String delete(List<Integer> ids) throws RuntimeException {
        try {
            sysUserMapper.deleteBatchIds(ids);
        } catch (Exception e) {
            LoggerUtils.error(getClass(), "删除管理员失败:" + e.getMessage());
            throw new RuntimeException("删除失败");
        }
        return "删除成功";
    }

}

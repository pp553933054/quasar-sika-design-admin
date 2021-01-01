package com.quasar.sika.design.server.business.thirdoauthuser.service;

import com.quasar.sika.design.server.business.thirdoauthuser.pojo.dto.ThirdOauthUserDTO;
import com.sika.code.standard.base.service.BaseStandardService;
import me.zhyd.oauth.model.AuthUser;

/**
 * <p>
 * 第三方授权用户表 服务类
 * </p>
 *
 * @author daiqi
 * @since 2021-01-01 23:24:33
 */
public interface ThirdOauthUserService extends BaseStandardService<ThirdOauthUserDTO> {
    /**
     * 根据第三方授权用户 新增|修改该用户的授权信息
     *
     * @param authUser
     * @return
     */
    ThirdOauthUserDTO modifyByAuthUser(AuthUser authUser);
}

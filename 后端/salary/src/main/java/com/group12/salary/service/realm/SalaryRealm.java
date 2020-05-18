package com.group12.salary.service.realm;

import com.group12.salary.model.UserDAO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryRealm<UsersService> extends AuthorizingRealm {

    @Autowired
    private com.group12.salary.service.UsersService usersService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userId = (String)principals.getPrimaryPrincipal();
//        Users user = userService.findByUserName(username);
//        user.setLocked(true);   //登录成功后锁定用户
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //根据用户名查找对应的角色集合
        authorizationInfo.setRoles(usersService.findRole(userId));
        //根据用户名查找对应的资源集合
        authorizationInfo.setStringPermissions(usersService.findRight(userId));

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userId = (String)token.getPrincipal();

        //根据用户名查找用户
        UserDAO user = usersService.findByUserID(userId);
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
//        if(Boolean.TRUE.equals(user.getLocked())) {
//            throw new LockedAccountException(); //帐号锁定
//        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserId(), //用户名
                user.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = (com.group12.salary.service.UsersService) usersService;
    }
}
package com.group12.salary.service.realm;

import com.group12.salary.model.RoleDAO;
import com.group12.salary.model.UserDAO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SalaryRealm<UsersService> extends AuthorizingRealm {

    @Autowired
    private com.group12.salary.service.UsersService usersService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String code = (String) getAvailablePrincipal(principals);

        RoleDAO role = null;
        UserDAO userDAO = null;
        userDAO = usersService.findByUserID(code);
        //通过用户名从数据库获取角色权限集
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> r = new HashSet<>();
        if (role != null) {
            String[] roles = role.getRoleName().split("\\+");
            for(int i = 0;i < roles.length; i++){
                r.add(roles[i].toString());
            }
            //放入该用户权限信息
            info.setRoles(r);
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //工号
        String code = (String) token.getPrincipal();
        //密码
        String password = new String((char[])token.getCredentials());
        //System.out.println(code+password);
        UserDAO userDAO = null;

        userDAO = usersService.findByUserID(code);

        if (userDAO == null) {
            //没有该用户
            throw new UnknownAccountException();
        } else if (!password.equals(userDAO.getPassword())) {
            //密码错误
            throw new IncorrectCredentialsException();
        }

        //身份验证通过,返回一个身份信息
        AuthenticationInfo aInfo = new SimpleAuthenticationInfo(code,password,getName());

        return aInfo;
    }

    public void setUsersService(UsersService usersService) {
        this.usersService = (com.group12.salary.service.UsersService) usersService;
    }
}
package com.qfedu.examsys.realm;


import com.qfedu.examsys.dao.UserDao;
import com.qfedu.examsys.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired(required = false)
    private UserDao userDao;

    // 获取授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取登陆用户的用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        // 从数据库中查询用户的角色和权限列表信息
        List<String> perms = userDao.findPermsByName(userName);

        // 创建授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 设置角色和权限信息
        info.setStringPermissions(new HashSet<>(perms));

        return info;
    }

    // 获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 获取token中的用户名
        String userName = (String) authenticationToken.getPrincipal();

        // 认证信息对象
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;
        // 从数据库中获取用户信息
        User user = userDao.findByName(userName);
        if(user == null){
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(null, null, this.getName());
        }else{
             // 第一个参数 用户身份信息
             // 第二个参数 用户的合法密码
             // 第三个参数 realm的名称
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, user.getPassword(),ByteSource.Util.bytes("examsys"), this.getName());
        }

        return simpleAuthenticationInfo;
    }


}






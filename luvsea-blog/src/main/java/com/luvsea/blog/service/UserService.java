package com.luvsea.blog.service;

import java.util.HashMap;
import java.util.List;

import com.luvsea.blog.entity.Test;
import com.luvsea.blog.entity.User;

public interface UserService {

    public List<User> findUserList();
    
    public int testAdd (Test test);
    
    public List<HashMap<Object, Object>> findListByProtocal();
    
    public User findUserBySelected(User user);
}

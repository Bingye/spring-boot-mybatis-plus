package com.bingye.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bingye.domain.po.User;

public interface UserMapper extends BaseMapper<User> {
    User findById(Long id);
}

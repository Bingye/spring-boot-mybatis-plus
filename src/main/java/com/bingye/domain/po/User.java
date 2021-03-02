package com.bingye.domain.po;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@TableName("user")
//oracle
//@KeySequence(value = "seq_create_user_id")
//extends Model<User> ActiveRecord语法
public class User extends Model<User> {

    @TableId(type = IdType.AUTO)
    private Long id;

    //解决数据库字段不一致
    @TableField(value = "USER_NAME")
    private String userName;

    //解决数据库字段不存在的问题
    @TableField(exist = false)
    private String address;

    //不希望查询出来
    @TableField(select = false)
    private String password;
}

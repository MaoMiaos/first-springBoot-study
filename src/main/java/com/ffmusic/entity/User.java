package com.ffmusic.entity;

import com.ffmusic.enums.Gender;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.*;


import java.util.Date;
import java.util.List;
@Entity
@Data
//data自动创建gettersetter
public class User extends AbstractEntity{

    @Column(unique = true)
    private String username;

    private String nickname;
    //多对多，在多的那一方通过延迟加载的方式加载对象(默认不是延迟加载)
    @ManyToMany(fetch = FetchType.LAZY)
    //索引到指定表，指定对应关系
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;


}

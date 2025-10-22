package com.lux.awaking.integration.db;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AwakingUserVo {
    private int id;
    private String userName;
    private String displayName;
    private String uuid;
    private String email;
    private String phone;
    private String gender;
    private String password;
    private String avatar;
    private String status;
    private LocalDateTime lastLogin;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;
    private int loginCount;
    private int version;
    private String remark;
}

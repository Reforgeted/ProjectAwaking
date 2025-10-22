package com.lux.awaking.integration.db.mapper;

import com.lux.awaking.integration.db.AwakingUserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PwUserMapper {
    List<AwakingUserVo> getAllUsers();

    AwakingUserVo selectByName(@Param("username") String username);

    int createUser(@Param("userVo") AwakingUserVo pwUserVo);
}

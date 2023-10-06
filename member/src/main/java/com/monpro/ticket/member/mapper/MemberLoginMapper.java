package com.monpro.ticket.member.mapper;

import com.monpro.ticket.member.domain.MemberLogin;
import com.monpro.ticket.member.domain.MemberLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MemberLoginMapper {
    long countByExample(MemberLoginExample example);

    int deleteByExample(MemberLoginExample example);

    int deleteByPrimaryKey(String mobile);

    int insert(MemberLogin record);

    int insertSelective(MemberLogin record);

    List<MemberLogin> selectByExample(MemberLoginExample example);

    MemberLogin selectByPrimaryKey(String mobile);

    int updateByExampleSelective(@Param("record") MemberLogin record, @Param("example") MemberLoginExample example);

    int updateByExample(@Param("record") MemberLogin record, @Param("example") MemberLoginExample example);

    int updateByPrimaryKeySelective(MemberLogin record);

    int updateByPrimaryKey(MemberLogin record);
}
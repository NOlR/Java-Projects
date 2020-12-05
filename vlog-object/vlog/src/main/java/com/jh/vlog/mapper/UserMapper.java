package com.jh.vlog.mapper;

import com.jh.vlog.model.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author apple
 * @Date 2020/12/5
 **/
public interface UserMapper {
    /**
     * 新增用户,并返回自增主键
     * @param user 入参user对象
     * @throws SQLException
     */
    @Insert("INSERT INTO t_user (phone,password,nickname,avatar,gender,birthday,address,create_time)"+
    "VALUES (#{phone},#{password},#{nickname},#{avatar},#{gender},#{birthday},#{address},#{createTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(User user)throws SQLException;

    @Select({"<script>",
            "SELECT * FROM t_user ",
            "WHERE 1=1 ",
            "<when test='phone!=null'> ",
            "AND phone = #{phone} ",
            "</when> ",
            "</script>"})
    User findUserByPhone(@Param("phone") String phone) throws SQLException;


}

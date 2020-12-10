package com.jh.vlog.mapper;

import com.jh.vlog.model.entity.User;
import org.apache.ibatis.annotations.*;

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
    @Insert("INSERT INTO t_user (wx_openid,phone,nickname,avatar,create_time)"+
    "VALUES (#{wxOpenId},#{phone},#{nickname},#{avatar},#{createTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(User user)throws SQLException;

    /**
     * 根据用户手机查询信息
     * @param phone
     * @return
     * @throws SQLException
     */
    @Select({"<script>",
            "SELECT * FROM t_user ",
            "WHERE 1=1 ",
            "<when test='phone!=null'> ",
            "AND phone = #{phone} ",
            "</when> ",
            "</script>"})
    User findUserByPhone(@Param("phone") String phone) throws SQLException;

    /**
     *
     * @param user
     * @throws SQLException
     */
    @Update("UPDATE t_user SET password=#{password},nickname=#{nickname},avatar=#{avatar},gender=#{gender},birthday=#{birthday},address=#{address}"+
    "WHERE phone=#{phone}")
    void updataUser(User user) throws SQLException;

    /**
     * 根据微信openid查询用户信息
     * @param wxOpenid
     * @return
     * @throws SQLException
     */
    @Select({"<script>",
            "SELECT * FROM t_user ",
            "WHERE 1=1",
            "<when test='wxOpenId!=null'> ",
            "AND wx_openid = #{wxOpenId} ",
            "</when> ",
            "</script>"})
    User findUserByOpenId(@Param("wxOpenId")String wxOpenId) throws SQLException;
}

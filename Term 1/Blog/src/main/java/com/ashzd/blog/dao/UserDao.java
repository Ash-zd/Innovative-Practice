package com.ashzd.blog.dao;

import com.ashzd.blog.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {
    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " name, password, salt, head_url ,role ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAME,"(",INSERT_FIELDS,") values (#{name},#{password},#{salt},#{headUrl},#{role})"})
    public void insertUser(User user);

    @Select({"select",SELECT_FIELDS,"from", TABLE_NAME,"where id=#{id}"})
    public User seletById(int id);

    @Select({"select",SELECT_FIELDS,"from", TABLE_NAME,"where name=#{name}"})
    public User seletByName(@Param("name") String name);

    @Delete({"delete from", TABLE_NAME,"where id=#{id}"})
    public void deleteById(int id);
}

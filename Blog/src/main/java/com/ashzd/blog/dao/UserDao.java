package com.ashzd.blog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import com.ashzd.blog.model.User;

@Mapper
public interface UserDao {
    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " name, password, email, salt, head_url, role ";
    String SELECT_FIELDS = " id " + INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAME,"(",INSERT_FIELDS,") values (#{name},#{password},#{email},#{salt},#{headUrl},#{role})"})
    public void insertUser(User user);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where id=#{id}"})
    public User selectById(int id);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAME,"where name=#{name}"})
    public User selectByName(@Param("name") String name);

    @Delete({"delete from",TABLE_NAME,"where id=#{id}"})
    public void deleteById(int id);
}

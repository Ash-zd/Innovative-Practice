package com.ashzd.blog.dao;

import com.ashzd.blog.model.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface TagDao {
    String TABLE_NAME = " tag ";
    String INSERT_FIELDS = " name, count ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAME,"(",INSERT_FIELDS,") values (#{name},#{count})"})
    int insertTag(Tag tag);

    @Select({"select",SELECT_FIELDS,"from", TABLE_NAME,"where name=#{name}"})
    Tag selectByName(String name);

    @Select({"select",SELECT_FIELDS,"from", TABLE_NAME})
    List<Tag> selectAll();

    @Select({"select count(id) from", TABLE_NAME})
    int getTagCount();

    @Update({"update", TABLE_NAME,"set count = #{count} where id = #{tagId}"})
    void updateCount(@Param("tagId") int tagId,@Param("count") int count);

    @Delete({"delete from", TABLE_NAME,"where id=#{id}"})
    void deleteById(int id);
}

package com.ashzd.blog.dao;

import com.ashzd.blog.model.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CommentDao {
    String TABLE_NAME = " comment ";
    String INSERT_FIELDS = " article_id, content, created_date, user_id, status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAME,"(",INSERT_FIELDS,") values (#{articleId}," +
            "#{content},#{createdDate},#{userId},#{status})"})
    int insertComment(Comment comment);

    @Select({"select",SELECT_FIELDS,"from", TABLE_NAME,"where id=#{id}"})
    Comment seletById(int id);

    @Select({"select",SELECT_FIELDS,"from", TABLE_NAME,"order by id desc limit #{offset},#{limit}"})
    List<Comment> selectLatestComments(@Param("offset") int offset, @Param("limit") int limit);

    @Select({"select",SELECT_FIELDS,"from", TABLE_NAME,"where article_id = #{articleId} " +
            "order by created_date desc"})
    List<Comment> selectCommentsByArticleId(@Param("articleId") int articleId);

    @Select({"select count(id) from", TABLE_NAME,"where article_id = #{articleId}"})
    int getCommentCountByArticleId(@Param("articleId") int articleId);

    @Update({"update", TABLE_NAME,"set status = #{status} where id = #{commendId}"})
    void updateStatus(@Param("commendId") int commendId, @Param("status") int status);

    @Delete({"delete from", TABLE_NAME,"where id=#{id}"})
    void deleteById(int id);
}

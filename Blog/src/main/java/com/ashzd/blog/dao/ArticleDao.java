package com.ashzd.blog.dao;

import com.ashzd.blog.model.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDao {
    String TABLE_NAME = " article ";
    String INSERT_FIELDS = " title, describes, content, created_Date, comment_Count, category ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into", TABLE_NAME,"(",INSERT_FIELDS,") values (#{title},#{describes},#{content}" +
            ",#{createdDate},#{commentCount},#{category})"})
    int insertArticle(Article article);

    @Select({"select",SELECT_FIELDS,"from", TABLE_NAME,"where id=#{id}"})
    Article selectById(int id);

    @Select({"select",SELECT_FIELDS,"from", TABLE_NAME,"order by id desc limit #{offset},#{limit}"})
    List<Article> selectLatestArticles(@Param("offset") int offset, @Param("limit") int limit);

    @Select({"select",SELECT_FIELDS,"from", TABLE_NAME,"where category=#{category} order by id desc limit #{offset},#{limit}"})
    List<Article> selectArticlesByCategory(@Param("category") String category,@Param("offset") int offset, @Param("limit") int limit);

    @Select({"select count(id) from", TABLE_NAME,"where category=#{category}"})
    int getArticleCountByCategory(@Param("category") String category);

    @Select({"select count(id) from", TABLE_NAME})
    int getArticleCount();

    @Update({"update", TABLE_NAME,"set comment_count = #{commentCount} where id = #{questionId}"})
    void updateCommentCount(@Param("questionId") int questionId,@Param("commentCount") int commentCount);

    @Delete({"delete from", TABLE_NAME,"where id=#{id}"})
    void deleteById(int id);
}

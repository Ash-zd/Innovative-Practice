package com.ashzd.blog.service;

import com.ashzd.blog.dao.ArticleTagDao;
import com.ashzd.blog.dao.TagDao;
import com.ashzd.blog.model.ArticleTag;
import com.ashzd.blog.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagDao tagDao;

    @Autowired
    private ArticleTagDao articleTagDao;

    public Tag selectByName(String name){
        return tagDao.selectByName(name);
    }

    public List<Tag> getAllTag(){
        return tagDao.selectAll();
    }

    public List<Tag> getTagByArticleId(int articleId){
        return articleTagDao.selectByArticleId(articleId);
    }

    public int addTag(Tag tag){
        return tagDao.insertTag(tag)>0?tag.getId():0;
    }

    public int addArticleTag(ArticleTag articleTag){
        return articleTagDao.insertArticleTag(articleTag);
    }

    public void updateCount(int tagId,int count){
        tagDao.updateCount(tagId,count);
    }
}

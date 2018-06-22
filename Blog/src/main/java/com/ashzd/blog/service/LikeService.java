package com.ashzd.blog.service;

import com.ashzd.blog.util.RedisKeyUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    @Autowired
    private JedisService jedisService;

    public int getLikeStatus(int userId,int articleId){
        String likeKey = RedisKeyUntil.getLikeKey(articleId);
        if (jedisService.sismember(likeKey,String.valueOf(userId))){
           return 1;
        }
        String disLikeKey = RedisKeyUntil.getDisLikeKey(articleId);
        return jedisService.sismember(disLikeKey,String.valueOf(userId))?-1:0;
    }

    public long like(int userId,int articleId){
        String likeKey = RedisKeyUntil.getLikeKey(articleId);
        jedisService.sadd(likeKey,String.valueOf(userId));

        String disLikeKey = RedisKeyUntil.getDisLikeKey(articleId);
        jedisService.srem(disLikeKey,String.valueOf(userId));

        return jedisService.scard(likeKey);
    }

    public long dislike(int userId,int articleId){
        String disLikeKey = RedisKeyUntil.getDisLikeKey(articleId);
        jedisService.sadd(disLikeKey,String.valueOf(userId));

        String likeKey = RedisKeyUntil.getLikeKey(articleId);
        jedisService.srem(likeKey,String.valueOf(userId));

        return jedisService.scard(likeKey);
    }

    public long getLikeCount(int articleId){
        String likeKey = RedisKeyUntil.getLikeKey(articleId);
        return jedisService.scard(likeKey);
    }

    public long getDislikeCount(int articleId){
        String dislikeKey = RedisKeyUntil.getDisLikeKey(articleId);
        return jedisService.scard(dislikeKey);
    }
}

package com.ashzd.blog;
import org.springframework.data.repository.CrudRepository;
import com.ashzd.blog.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}

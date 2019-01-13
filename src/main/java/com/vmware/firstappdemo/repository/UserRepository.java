package com.vmware.firstappdemo.repository;


import com.vmware.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */

@Repository
public class UserRepository {

    // 采用内存型的存储方式 -> Map
    private ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    // id自增长生成器
    private final static AtomicInteger idGenerator = new AtomicInteger();
    /**
     * 保存用户对象
     * @param user {@link User}
     * @return 如果保存成功，返回TRUE
     *         否则返回False
     */
    public boolean save(User user){
        // ID 从 1 开始
        Integer id = idGenerator.incrementAndGet();

        // 设置 ID
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }
}

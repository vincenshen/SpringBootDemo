package com.vmware.firstappdemo.repository;

import com.vmware.firstappdemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// JpaRepository<实例类，主键类型>
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}

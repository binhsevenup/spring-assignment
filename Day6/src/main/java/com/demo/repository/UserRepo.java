package com.demo.repository;

import com.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    //    Page<ProductEntity> findAll(Pageable pageable);
    List<User> findAll();

    @Query("select c from User c where c.name like %?1%")
    Page<List<User>> findAllByName(String name, Pageable pageable);

}

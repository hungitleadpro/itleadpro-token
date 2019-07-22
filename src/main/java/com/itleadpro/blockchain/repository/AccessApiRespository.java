package com.itleadpro.blockchain.repository;

import com.itleadpro.blockchain.model.AccessApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccessApiRespository extends JpaRepository<AccessApi, Integer> {
    @Query("FROM AccessApi a WHERE userName = :userName AND password = :password")
    AccessApi accessApi(@Param("userName") String userName, @Param("password") String password);
}

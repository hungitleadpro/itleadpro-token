package com.itleadpro.blockchain.repository;

import com.itleadpro.blockchain.model.DataBlockchain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DataBlockchainRespository extends JpaRepository<DataBlockchain, Integer> {
    @Query("FROM DataBlockchain a WHERE code = :code")
    DataBlockchain findByCode(@Param("code") String code);
}

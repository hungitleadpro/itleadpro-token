package com.itleadpro.blockchain.repository;

import com.itleadpro.blockchain.model.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestLogRespository extends JpaRepository<RequestLog, Integer> {
}

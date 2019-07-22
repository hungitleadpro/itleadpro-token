package com.itleadpro.blockchain.service.impl;

import com.itleadpro.blockchain.repository.RequestLogRespository;
import com.itleadpro.blockchain.model.RequestLog;
import com.itleadpro.blockchain.service.RequestLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestLogServiceImpl implements RequestLogService {
    @Autowired
    private RequestLogRespository requestLogRespository;

    @Override
    public RequestLog insertOrUpdate(RequestLog requestLog) {
        return requestLogRespository.save(requestLog);
    }


}

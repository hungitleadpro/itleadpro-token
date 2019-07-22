package com.itleadpro.blockchain.service.impl;

import com.itleadpro.blockchain.model.AccessApi;
import com.itleadpro.blockchain.repository.AccessApiRespository;
import com.itleadpro.blockchain.service.AccessApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessApiServiceImpl implements AccessApiService {

    @Autowired
    private AccessApiRespository accessApiRespository;

    @Override
    public List<AccessApi> getAllAccess() {
        return accessApiRespository.findAll();
    }
}

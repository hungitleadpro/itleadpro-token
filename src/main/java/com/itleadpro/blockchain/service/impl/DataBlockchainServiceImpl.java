package com.itleadpro.blockchain.service.impl;

import com.itleadpro.blockchain.service.DataBlockchainService;
import com.itleadpro.blockchain.model.DataBlockchain;
import com.itleadpro.blockchain.repository.DataBlockchainRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataBlockchainServiceImpl implements DataBlockchainService
{
    @Autowired
    private DataBlockchainRespository dataBlockchainRespository;

    @Override
    public DataBlockchain findByCode(String code) {
        return dataBlockchainRespository.findByCode(code);
    }
}

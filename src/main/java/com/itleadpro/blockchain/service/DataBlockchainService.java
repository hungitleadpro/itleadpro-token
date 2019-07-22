package com.itleadpro.blockchain.service;

import com.itleadpro.blockchain.model.DataBlockchain;

public interface DataBlockchainService {
    DataBlockchain findByCode(String code);
}

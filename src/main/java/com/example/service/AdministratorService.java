package com.example.service;

import org.apache.logging.log4j.util.StackLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Administrator;
import com.example.repository.AdministratorRepository;

/**
*   Administrator Servicelクラス
*   @author Ryo Saito
*/
@Service
@Transactional
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    /**
     * AdministratorRepositoryのInsertクラスを呼ぶメソッド
     * @param administrator
     */
    public void insert(Administrator administrator){
        administratorRepository.insert(administrator);
    }

    /**
     * AdministratorRepositoryのfindByMailAddressAndPasswordクラスを呼ぶメソッド
     * @param mailAddress
     * @param password
     * @return Administrator
     */
    public Administrator login(String mailAddress, String password){
        return administratorRepository.findByMailAddressAndPassword(mailAddress, password);
    }

    public Administrator checkMailAddress(String mailAddress){
        return administratorRepository.findByMail(mailAddress);
    }
}

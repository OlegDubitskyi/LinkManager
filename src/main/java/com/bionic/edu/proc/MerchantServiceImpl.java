package com.bionic.edu.proc;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

@Named
public class MerchantServiceImpl implements MerchantService{
    @Inject
    private MerchantDao merchantDao;
    public Merchant findById(int id) { 
    	return merchantDao.findById(id); 
    }

    public List<Merchant> findAll(){
    	return merchantDao.findAll();
    }
    @Transactional
    public void save(Merchant merchant){
    	merchantDao.save(merchant);
    }

}

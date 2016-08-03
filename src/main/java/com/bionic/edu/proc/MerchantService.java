package com.bionic.edu.proc;

import java.util.List;

public interface MerchantService {
	public Merchant findById(int id);
	public List<Merchant> findAll();
	public void save(Merchant merchant);

}

package com.test.Bank.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.test.Bank.Entity.Account;

public interface AccountRepo  extends JpaRepository<Account, Long>{

}

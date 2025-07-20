package com.abhi.CRM.Repository;

import com.abhi.CRM.Model.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<LoginEntity, Integer> {
    LoginEntity findByUserNameAndPassword(String userName, String password);

    LoginEntity findBymobile(String mobile);

}

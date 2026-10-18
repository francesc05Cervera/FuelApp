package com.francesco.FuelApp.Repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.francesco.FuelApp.Model.UserModel;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> 
{
    UserModel findByEmail(String email);
    UserModel findById(long id);
    boolean existsByEmail(String email);
}

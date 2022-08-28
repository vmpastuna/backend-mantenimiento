package com.mantenimiento.vehicular.mantenimientovehicular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mantenimiento.vehicular.mantenimientovehicular.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {   
    public User findByName(String name);
}

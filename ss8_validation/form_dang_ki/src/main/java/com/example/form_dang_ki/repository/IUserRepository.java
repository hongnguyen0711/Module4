package com.example.form_dang_ki.repository;

import com.example.form_dang_ki.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Modifying
    @Transactional
    @Query(value = "insert into User(first_name,last_name, phone_number, age, email) value(:firstName,:lastName,:phoneNumber, :age, :email)", nativeQuery = true)
    void saveUser(@Param("firstName") String firstName,@Param("lastName") String lastName,@Param("age") int age,@Param("phoneNumber") String phoneNumber,@Param("email") String email);
}

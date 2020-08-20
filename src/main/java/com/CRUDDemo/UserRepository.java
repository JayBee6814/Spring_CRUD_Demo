package com.CRUDDemo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findUserByLastName(String lastname);

    @Query(value = "SELECT u FROM User u WHERE lower(u.firstName) LIKE lower(concat('%', :keyword, '%'))"
            + "OR lower(u.lastName) LIKE lower(concat('%', :keyword, '%'))"
            + "OR lower(u.email) LIKE lower(concat('%', :keyword, '%'))"
    )
    public List<User> findUserByKeyword(@Param("keyword") String keyword);
}


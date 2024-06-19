package com.blogproject.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
    UsersDto findByEmail(String email);
}

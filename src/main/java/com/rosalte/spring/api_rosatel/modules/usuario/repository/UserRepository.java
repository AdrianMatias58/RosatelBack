package com.rosalte.spring.api_rosatel.modules.usuario.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}

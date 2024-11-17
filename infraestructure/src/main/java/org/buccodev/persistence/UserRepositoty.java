package org.buccodev.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<UserEntity, Long> {
}

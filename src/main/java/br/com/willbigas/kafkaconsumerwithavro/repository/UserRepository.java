package br.com.willbigas.kafkaconsumerwithavro.repository;

import br.com.willbigas.kafkaconsumerwithavro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}

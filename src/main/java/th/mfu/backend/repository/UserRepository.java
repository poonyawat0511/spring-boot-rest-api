package th.mfu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import th.mfu.backend.model.User;


public interface  UserRepository extends JpaRepository<User, Long> {

}

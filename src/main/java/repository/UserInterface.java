package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lattice.entity.UserEntity;


public interface UserInterface extends JpaRepository<UserEntity, Integer>{
	public Optional<UserEntity> findById(Integer id);
}

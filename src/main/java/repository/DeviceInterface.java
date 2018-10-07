package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lattice.entity.DeviceEntity;
@Repository
public interface DeviceInterface extends JpaRepository<DeviceEntity, Integer> {

}

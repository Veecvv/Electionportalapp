package com.sv.electoinportal.repo;
import com.sv.electoinportal.model.Voters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface VotersRepo extends JpaRepository<Voters, Integer>{

}

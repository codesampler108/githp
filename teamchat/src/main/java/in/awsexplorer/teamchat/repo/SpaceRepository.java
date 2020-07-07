package in.awsexplorer.teamchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.awsexplorer.teamchat.model.Space;

public interface SpaceRepository extends JpaRepository<Space, Integer>{

}

package by.kovalski.eis.repository;

import by.kovalski.eis.model.HomeTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeTaskRepository extends JpaRepository<HomeTask,Long> {
}

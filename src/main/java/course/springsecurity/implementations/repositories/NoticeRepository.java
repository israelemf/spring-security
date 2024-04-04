package course.springsecurity.implementations.repositories;

import course.springsecurity.implementations.entities.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Integer> {
    @Query("SELECT n FROM Notice n where CURRENT_DATE between noticeBeginDate and noticeEndDate")
    List<Notice> findAllActiveNotices();
}

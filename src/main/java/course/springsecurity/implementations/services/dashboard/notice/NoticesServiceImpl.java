package course.springsecurity.implementations.services.dashboard.notice;

import course.springsecurity.implementations.entities.Notice;
import course.springsecurity.implementations.repositories.NoticeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticesServiceImpl implements NoticesService{
    private final NoticeRepository noticeRepository;

    public NoticesServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public List<Notice> getAllActiveNotices() {
        return noticeRepository.findAllActiveNotices();
    }
}

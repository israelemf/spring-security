package course.springsecurity.implementations.services.dashboard.notice;

import course.springsecurity.implementations.entities.Notice;

import java.util.List;

public interface NoticesService {
    List<Notice> getAllActiveNotices();
}

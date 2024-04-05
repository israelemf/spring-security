package course.springsecurity.implementations.controllers.dashboard;

import course.springsecurity.implementations.entities.Notice;
import course.springsecurity.implementations.services.dashboard.notice.NoticesServiceImpl;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class NoticesController {
    private final NoticesServiceImpl noticesService;

    public NoticesController(NoticesServiceImpl noticesService) {
        this.noticesService = noticesService;
    }

    @GetMapping("/notices")
    public ResponseEntity<List<Notice>> getAllActiveNotices() {
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(noticesService.getAllActiveNotices());
    }
}

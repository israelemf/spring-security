package course.springsecurity.implementations.controllers.dashboard;

import course.springsecurity.implementations.entities.Account;
import course.springsecurity.implementations.services.dashboard.account.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountServiceImpl accountService;

    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account")
    public ResponseEntity<Account> getAccountDetails(@RequestParam int id) {
        return ResponseEntity.ok().body(accountService.getAccountDetails(id));
    }
}

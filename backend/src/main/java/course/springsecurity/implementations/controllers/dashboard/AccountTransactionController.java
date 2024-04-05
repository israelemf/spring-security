package course.springsecurity.implementations.controllers.dashboard;

import course.springsecurity.implementations.entities.AccountTransaction;
import course.springsecurity.implementations.services.dashboard.accounttransaction.AccountTransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountTransactionController {
    private final AccountTransactionServiceImpl accountTransactionService;

    @Autowired
    public AccountTransactionController(AccountTransactionServiceImpl accountTransactionService) {
        this.accountTransactionService = accountTransactionService;
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<AccountTransaction>> getTransactionsDetails(@RequestParam int id) {
        return ResponseEntity.ok().body(accountTransactionService.getTransactionsDetails(id));
    }
}
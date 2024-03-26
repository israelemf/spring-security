package course.springsecurity.implementations.controllers.customer;

import course.springsecurity.implementations.dtos.customer.CreateCustomerDto;
import course.springsecurity.implementations.services.customer.CustomerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody CreateCustomerDto createCustomerDto) {
        customerService.save(createCustomerDto);
        return ResponseEntity.ok().body("Usuário registrado com sucesso!");
    }
}

package course.springsecurity.implementations.dtos.customer;

public record CreateCustomerDto(String name,
                                String email,
                                String phone,
                                String password,
                                String role) {
}

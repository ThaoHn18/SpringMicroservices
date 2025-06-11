package thaohn.accountservice.controller;  // giống với Application class

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thaohn.accountservice.client.StatisticService;
import thaohn.accountservice.model.AccountDTO;
import thaohn.accountservice.model.StatisticDTO;
import thaohn.accountservice.service.AccountService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private StatisticService statisticService;

    @PostMapping("/account")
    @Operation(summary = "Add user", description = "Create new user")
    public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) {
        accountService.add(accountDTO);
        statisticService.addStatistic(new StatisticDTO("Account " + accountDTO.getUsername() + " is created", new Date()));
        return accountDTO;
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> get(@PathVariable Long id) {
        statisticService.addStatistic(new StatisticDTO("Get all accounts", new Date()));
        return Optional.ofNullable(accountService.getOne(id))
                .map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/account/{id}")

    public void delete(@PathVariable Long id) {
        statisticService.addStatistic(new StatisticDTO("Delete account id " + id, new Date()));
        accountService.delete(id);
    }

    @PutMapping("/account")
    public void update(@RequestBody AccountDTO accountDTO) {
        statisticService.addStatistic(new StatisticDTO("Update account: " + accountDTO.getUsername(), new Date()));
        accountService.update(accountDTO);
    }
}

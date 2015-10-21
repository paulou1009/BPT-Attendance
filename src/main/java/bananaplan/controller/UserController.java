package bananaplan.controller;

import bananaplan.domain.dao.AccountDAO;
import bananaplan.domain.request.AccountRequest;
import bananaplan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class UserController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void createAccount(@RequestBody AccountRequest accountRequest){
        accountService.createAccount(accountRequest);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public AccountDAO accountLogin(@PathParam("username") String username, @PathParam("password") String password){
        AccountDAO accountDAO = accountService.getAccount(username, password);
        //return accountDAO != null ? accountDAO.toString() : "account not exists or username/password not match";
        return accountDAO;
    }

    @RequestMapping(value = "/users/{username}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable String username) {
        accountService.deleteAccount(username);
    }
}

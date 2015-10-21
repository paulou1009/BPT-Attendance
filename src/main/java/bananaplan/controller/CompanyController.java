package bananaplan.controller;

import bananaplan.domain.dao.CompanyDAO;
import bananaplan.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by paulou on 10/3/15.
 * All Rights Reserved By BananaPlanTw
 */
@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/companies", method = RequestMethod.PUT, consumes = "application/json;charset=UTF-8")
    public void createCompany(@RequestBody CompanyDAO companyDAO){
        companyService.createCompany(companyDAO);
    }
}

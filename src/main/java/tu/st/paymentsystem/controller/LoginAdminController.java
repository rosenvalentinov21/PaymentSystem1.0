package tu.st.paymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tu.st.paymentsystem.DTO.LoginDTO;
import tu.st.paymentsystem.service.AdminService;

@RestController
@RequestMapping("/login")
public class LoginAdminController {

    @Autowired
    AdminService adminService;

    @PostMapping
    public ResponseEntity login(@RequestBody final LoginDTO loginDTO) {
            adminService.getAdminByPassword(loginDTO.getPassword());
            return ResponseEntity.ok("");
    }

}

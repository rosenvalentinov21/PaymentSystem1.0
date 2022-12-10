package tu.st.paymentsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.st.paymentsystem.exception.NonExistingEntityException;
import tu.st.paymentsystem.model.Admin;
import tu.st.paymentsystem.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin getAdminByPassword(final String password){
        final Admin admin = adminRepository.findAdminByPassword(password);
        if(admin != null)
        {
            return admin;
        }
        else throw new NonExistingEntityException("Could not find admin!");
    }
}

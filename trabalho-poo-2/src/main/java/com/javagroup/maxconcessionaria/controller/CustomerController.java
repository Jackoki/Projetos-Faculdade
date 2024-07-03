package com.javagroup.maxconcessionaria.controller;

import com.javagroup.maxconcessionaria.controller.exception.UserException;
import com.javagroup.maxconcessionaria.controller.exception.WrongDataException;
import com.javagroup.maxconcessionaria.model.Customer;
import static com.mysql.cj.util.StringUtils.isNullOrEmpty;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class CustomerController {
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerController(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void validateCustomer(Customer customer) {
        if (isNullOrEmpty(customer.getName()) || isNullOrEmpty(customer.getCnh()) || customer.getName() == null || customer.getCnh() == null) {
                throw new NumberFormatException();
        }
    }
    
    public String returnPassword(String password, String name){
        if(isNullOrEmpty(password)){
            String passwordSql = "SELECT password FROM User WHERE name = ?";
            password = jdbcTemplate.queryForObject(passwordSql, new Object[]{name}, String.class);
        }
        
        return password;
    } 
    
    public String returnAddress(String address, String name){
        if(isNullOrEmpty(address)){
            String addressSql = "SELECT address FROM User WHERE name = ?";
            address = jdbcTemplate.queryForObject(addressSql, new Object[]{name}, String.class);
        }
        
        return address;
    } 
        
    public String returnEmail(String email, String name){
        if(isNullOrEmpty(email)){
            String emailSql = "SELECT email FROM User WHERE name = ?";
            email = jdbcTemplate.queryForObject(emailSql, new Object[]{name}, String.class);
        }
        
        return email;
    } 
            
    public String returnPhone(String phone, String name){
        if(isNullOrEmpty(phone)){
            String phoneSql = "SELECT phone FROM User WHERE name = ?";
            phone = jdbcTemplate.queryForObject(phoneSql, new Object[]{name}, String.class);
        }
        
        return phone;
    } 
    
    
    
    
    
    
    public void save(Customer customer) {
        try{
            validateCustomer(customer);
            
            String sqlUser = "INSERT INTO User (category, name, address, email, phone, password) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sqlUser, customer.getCategory(), customer.getName(), customer.getAddress(), customer.getEmail(), customer.getPhone(), customer.getPassword());
            
            String checkSql = "SELECT id FROM User WHERE name = ?";
            Integer generatedUserId = jdbcTemplate.queryForObject(checkSql, new Object[]{customer.getName()}, Integer.class);
            
            String sqlCustomer = "INSERT INTO Customer (idUser, cnh) VALUES (?, ?)";
            jdbcTemplate.update(sqlCustomer, generatedUserId, customer.getCnh());
            
            JOptionPane.showMessageDialog(null, "USUÁRIO CADASTRADO COM SUCESSO!", "CADASTRO DE USUÁRIO", 1);
        }
        
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NO CADASTRO DE USUÁRIO", 0);
        }
        
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NA ATUALIZAÇÃO NO CADASTRO DE USUÁRIO", 0);
        }
        
    } 
    
    
    
    
    
    public boolean loginCustomer(String name, String password) throws UserException {
        try {
            String checkSql = "SELECT COUNT(*) FROM User u INNER JOIN Customer c ON (u.id = c.idUser) WHERE u.name = ? AND u.password = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{name, password}, Integer.class);
            
            if (count != 1) {
                throw new UserException();
            }

            return true;
        } 
        
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "LOGIN DE CLIENTE", 0);
            return false;
        }
        
        catch (UserException ue) {
            ue.screenException();
            return false;
        }
    }
    
    
    
    
    
    
    public void update(String name, String passwordChecker, String password, String address, String email, String phone) throws WrongDataException {
        try{
            String checkSql = "SELECT COUNT(*) FROM User WHERE name = ? AND password = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{name, passwordChecker}, Integer.class);
            
            if (count != 1) {
                throw new WrongDataException();
            }
            
            
            password = returnPassword(password, name);
            
            address = returnAddress(address, name);
            
            email = returnEmail(email, name);
            
            phone = returnPhone(phone, name);
            
            
            String sql = "UPDATE User SET address = ?, email = ?, phone = ?, password = ? WHERE name = ?";
            jdbcTemplate.update(sql, address, email, phone, password, name);

            
            JOptionPane.showMessageDialog(null, "USUÁRIO ATUALIZADO COM SUCESSO!", "ATUALIZAÇÃO DE USUÁRIO", 1);
        }
       
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA ATUALIZAÇÃO DE USUÁRIO", 0);
        }
        
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NA ATUALIZAÇÃO DE USUÁRIO", 0);
        }
        
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NA ATUALIZAÇÃO DE USUÁRIO", 0);
        }
        
        catch (WrongDataException wde) {
            wde.screenException();
        }
    }
    
}
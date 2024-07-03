package com.javagroup.maxconcessionaria.controller;

import static ch.qos.logback.core.util.OptionHelper.isNullOrEmpty;
import com.javagroup.maxconcessionaria.controller.exception.IdDuplicatedException;
import com.javagroup.maxconcessionaria.controller.exception.IdDoesNotExistException;
import com.javagroup.maxconcessionaria.controller.exception.MotorNotAvailableException;
import com.javagroup.maxconcessionaria.model.Motorcycle;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class MotorcycleController {
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public MotorcycleController(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    private void validateMotorcycle(Motorcycle motor) {
        if (isNullOrEmpty(motor.getPlate()) || isNullOrEmpty(motor.getIdChassis()) || isNullOrEmpty(motor.getBrand()) || isNullOrEmpty(motor.getModel()) ||
            motor.getYearMade() == null || motor.getSaddlebag() == null || motor.getAvailable() == null) {
                throw new NumberFormatException();
        }
    }
    
    public void save(Motorcycle motor) throws IdDuplicatedException, NumberFormatException {
        try{
            String checkSql = "SELECT COUNT(*) FROM Vehicle WHERE plate = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{motor.getPlate()}, Integer.class);
            
            if (count > 0) {
                throw new IdDuplicatedException();
            }
            
            validateMotorcycle(motor);
            
            String sql = "INSERT INTO Vehicle VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, motor.getPlate(), motor.getIdUser(), motor.getIdChassis(), motor.getBrand(), motor.getModel(), motor.getYearMade(), motor.getColor(), motor.getAvailable(), motor.getSold());
        
            String sql2 = "INSERT INTO Motorcycle VALUES (?, ?)";
            jdbcTemplate.update(sql2, motor.getPlate(), motor.getSaddlebag());
            
            JOptionPane.showMessageDialog(null, "MOTO CADASTRADA COM SUCESSO!", "CADASTRO DE MOTO", 1);
        }
        
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NO CADASTRO DE MOTO", 0);
        }
        
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NO CADASTRO DE MOTO", 0);
        }
        
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NO CADASTRO DE MOTO", 0);
        }
        
        catch (IdDuplicatedException die) {
            die.screenException();
        }
        
    } 
    
    public void update(Motorcycle motor) throws IdDuplicatedException, NumberFormatException {
        try{
            String checkSql = "SELECT COUNT(*) FROM Vehicle WHERE plate = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{motor.getPlate()}, Integer.class);
            
            if (count == 0) {
                throw new IdDoesNotExistException();
            }
            
            String sql = "UPDATE Vehicle SET idChassis = ?, brand = ?, model = ?, color = ?, yearMade = ?, available = ?, sold = ? WHERE plate = ?";
            jdbcTemplate.update(sql, motor.getIdChassis(), motor.getBrand(), motor.getModel(), motor.getColor(), motor.getYearMade(), motor.getAvailable(), motor.getSold(), motor.getPlate());

            String sql2 = "UPDATE Motorcycle SET saddlebag = ? WHERE idPlate = ?";
            jdbcTemplate.update(sql2, motor.getSaddlebag(), motor.getPlate());
            
            JOptionPane.showMessageDialog(null, "MOTO ATUALIZADA COM SUCESSO!", "ATUALIZAÇÃO DE MOTO", 1);
        }
       
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA ATUALIZAÇÃO DE MOTO", 0);
        }
        
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NA ATUALIZAÇÃO NO CADASTRO DE MOTO", 0);
        }
        
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NA ATUALIZAÇÃO NO CADASTRO DE MOTO", 0);
        }
        
        catch (IdDoesNotExistException ine) {
            ine.screenException();
        }
    }
    
    public void delete(String plate){
        try{
            if("".equals(plate) || plate == null){
                throw new NumberFormatException();
            }
            
            String sql3 = "DELETE FROM Motorcycle WHERE idPlate = ?";
            jdbcTemplate.update(sql3, plate);
    
            String sql4 = "DELETE FROM Vehicle WHERE plate = ?";
            jdbcTemplate.update(sql4, plate);
            
            JOptionPane.showMessageDialog(null, "MOTO DELETADA COM SUCESSO!", "DELETE DE MOTO", 1);
        }
        
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "DELETE NO CADASTRO DE MOTO", 0);
        }

        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NO DELETE DE MOTO", 0);
        }
    }
    
    public void consultAll(DefaultTableModel tableModel) {
        try {
            String sql5 = "SELECT v.plate, v.idChassis, v.brand, v.model, v.color, v.yearMade, m.saddlebag " +
                          "FROM Vehicle v " +
                          "INNER JOIN Motorcycle m ON (v.plate = m.idPlate)";

            List<Motorcycle> listMotorcycle = jdbcTemplate.query(sql5, (ResultSet rs, int rowNum) -> {
                Motorcycle motor = new Motorcycle();
                motor.setPlate(rs.getString("plate"));
                motor.setIdChassis(rs.getString("idChassis"));
                motor.setBrand(rs.getString("brand"));
                motor.setModel(rs.getString("model"));
                motor.setColor(rs.getString("color"));
                motor.setYearMade(rs.getInt("yearMade"));
                motor.setSaddlebag(rs.getBoolean("saddlebag"));
                return motor;
            });

            tableModel.setRowCount(0);

            for (Motorcycle m : listMotorcycle) {
                tableModel.addRow(new Object[]{
                    m.getPlate(),
                    m.getIdChassis(),
                    m.getBrand(),
                    m.getModel(),
                    m.getColor(),
                    m.getYearMade(),
                    m.getSaddlebag()
                });
            }
        } 
        
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA CONSULTA DE MOTOS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void consultBuy(DefaultTableModel tableModel) {
        try {
            String sql5 = "SELECT v.plate, v.idChassis, v.brand, v.model, v.color, v.yearMade, m.saddlebag " +
                          "FROM Vehicle v " +
                          "INNER JOIN Motorcycle m ON (v.plate = m.idPlate) " +
                          "WHERE (v.sold IS NULL OR v.sold = false) AND (v.available IS NULL OR v.available = true) AND (v.idUser IS NULL OR v.idUser = '')";

            List<Motorcycle> listMotor = jdbcTemplate.query(sql5, (ResultSet rs, int rowNum) -> {
                Motorcycle motor = new Motorcycle();
                motor.setPlate(rs.getString("plate"));
                motor.setIdChassis(rs.getString("idChassis"));
                motor.setBrand(rs.getString("brand"));
                motor.setModel(rs.getString("model"));
                motor.setColor(rs.getString("color"));
                motor.setYearMade(rs.getInt("yearMade"));
                motor.setSaddlebag(rs.getBoolean("saddlebag"));
                return motor;
            });

            tableModel.setRowCount(0);

            for (Motorcycle m : listMotor) {
                tableModel.addRow(new Object[]{
                    m.getPlate(),
                    m.getIdChassis(),
                    m.getBrand(),
                    m.getModel(),
                    m.getColor(),
                    m.getYearMade(),
                    m.getSaddlebag()
                });
            }
        } 
        
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA CONSULTA DE MOTOS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void buyMotor(String plate, String userName){
        try{
            String checkSql = "SELECT COUNT(*) FROM Vehicle WHERE plate = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{plate}, Integer.class);
        
            if (count == 0) {
                throw new IdDoesNotExistException();
            }
        
            String getUserId = "SELECT u.id FROM Customer c INNER JOIN User u ON (u.id = c.idUser) WHERE u.name = ?";
            int idUser = jdbcTemplate.queryForObject(getUserId, new Object[]{userName}, Integer.class);
        
            String sql = "UPDATE Vehicle SET available = false, sold = true, idUser = ? WHERE plate = ?";
            jdbcTemplate.update(sql, idUser, plate);
        
            JOptionPane.showMessageDialog(null, "MOTO COMPRADA COM SUCESSO!", "COMPRA DE MOTO", 1);
        }
       
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA COMPRA DE MOTO", 0);
        }
        
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NA COMPRA DE MOTO", 0);
        }
        
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NA COMPRA DE MOTO", 0);
        }
        
        catch (IdDoesNotExistException ine) {
            ine.screenException();
        }
    }
    
    public Boolean verifyMotorPlate(String plate) throws MotorNotAvailableException{
        try {
            String checkSql = "SELECT COUNT(*) FROM Vehicle v INNER JOIN Motorcycle m ON (v.plate = m.Idplate) WHERE v.plate = ? AND (v.sold IS NULL OR v.sold = false) AND (v.available IS NULL OR v.available = true) AND (v.idUser IS NULL OR v.idUser = '')";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{plate}, Integer.class);
            
            if (count == 0) {
                throw new MotorNotAvailableException();
            }
            
            return true;
        }
        
        catch (MotorNotAvailableException mnae) {
            mnae.screenException();
            return false;
        }
    }
    
    
    public void consultMotor(String plate, DefaultTableModel tableModel) throws IdDoesNotExistException {
        try {
            String checkSql = "SELECT COUNT(*) FROM Vehicle WHERE plate = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{plate}, Integer.class);
            
            if (count == 0) {
                throw new IdDoesNotExistException();
            }
            
            String sql = "SELECT v.plate, v.idChassis, v.brand, v.model, v.color, v.yearMade, m.saddlebag " +
                         "FROM Vehicle v " +
                         "INNER JOIN Motorcycle m ON (v.plate = m.idPlate) " +
                         "WHERE v.plate = ?";

            Motorcycle motor = jdbcTemplate.queryForObject(sql, new Object[]{plate}, (ResultSet rs, int rowNum) -> {
                Motorcycle motorAux = new Motorcycle();
                motorAux.setPlate(rs.getString("plate"));
                motorAux.setIdChassis(rs.getString("idChassis"));
                motorAux.setBrand(rs.getString("brand"));
                motorAux.setModel(rs.getString("model"));
                motorAux.setColor(rs.getString("color"));
                motorAux.setYearMade(rs.getInt("yearMade"));
                motorAux.setSaddlebag(rs.getBoolean("saddlebag"));
                return motorAux;
            });

            tableModel.setRowCount(0);

            tableModel.addRow(new Object[]{
                motor.getPlate(), 
                motor.getIdChassis(), 
                motor.getBrand(), 
                motor.getModel(), 
                motor.getColor(),
                motor.getYearMade(), 
                motor.getSaddlebag()
            });
        } 
        
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "CONSULTA DE MOTO", 0);
        }
        
        catch (IdDoesNotExistException ine) {
            ine.screenException();
        }
    }
    
}
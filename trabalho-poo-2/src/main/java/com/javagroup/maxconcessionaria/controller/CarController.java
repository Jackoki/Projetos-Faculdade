package com.javagroup.maxconcessionaria.controller;

import static ch.qos.logback.core.util.OptionHelper.isNullOrEmpty;
import com.javagroup.maxconcessionaria.controller.exception.CarNotAvailableException;
import com.javagroup.maxconcessionaria.controller.exception.IdDuplicatedException;
import com.javagroup.maxconcessionaria.controller.exception.IdDoesNotExistException;
import com.javagroup.maxconcessionaria.model.Car;
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
public class CarController {
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public CarController(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    private void validateCar(Car car) {
        if (isNullOrEmpty(car.getPlate()) || isNullOrEmpty(car.getIdChassis()) || isNullOrEmpty(car.getBrand()) || isNullOrEmpty(car.getModel()) ||
            car.getYearMade() == null || car.getQuantAirbag() == null || car.getAvailable() == null) {
                throw new NumberFormatException();
        }
    }
    
    public void save(Car car) throws IdDuplicatedException, NumberFormatException {
        try{
            String checkSql = "SELECT COUNT(*) FROM Vehicle WHERE plate = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{car.getPlate()}, Integer.class);
            
            if (count > 0) {
                throw new IdDuplicatedException();
            }
            
            validateCar(car);
            
            String sql = "INSERT INTO Vehicle VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, car.getPlate(), car.getIdUser(), car.getIdChassis(), car.getBrand(), car.getModel(), car.getYearMade(), car.getColor(), car.getAvailable(), car.getSold());
            
            String sql2 = "INSERT INTO Car VALUES (?, ?)";
            jdbcTemplate.update(sql2, car.getPlate(), car.getQuantAirbag());
            
            JOptionPane.showMessageDialog(null, "CARRO CADASTRADO COM SUCESSO!", "CADASTRO DE CARRO", 1);
        }
        
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NO CADASTRO DE CARRO", 0);
        }
        
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NO CADASTRO DE CARRO", 0);
        }
        
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NO CADASTRO DE CARRO", 0);
        }
        
        catch (IdDuplicatedException die) {
            die.screenException();
        }
        
    } 
    
    public void update(Car car) throws IdDuplicatedException, NumberFormatException {
        try{
            String checkSql = "SELECT COUNT(*) FROM Vehicle WHERE plate = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{car.getPlate()}, Integer.class);
            
            if (count == 0) {
                throw new IdDoesNotExistException();
            }
            
            String sql = "UPDATE Vehicle SET idChassis = ?, brand = ?, model = ?, color = ?, yearMade = ?, available = ?, sold = ? WHERE plate = ?";
            jdbcTemplate.update(sql, car.getIdChassis(), car.getBrand(), car.getModel(), car.getColor(), car.getYearMade(), car.getAvailable(), car.getSold(), car.getPlate());

            String sql2 = "UPDATE Car SET quantAirbag = ? WHERE idPlate = ?";
            jdbcTemplate.update(sql2, car.getQuantAirbag(), car.getPlate());
            
            JOptionPane.showMessageDialog(null, "CARRO ATUALIZADO COM SUCESSO!", "ATUALIZAÇÃO DE CARRO", 1);
        }
       
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA ATUALIZAÇÃO DE CARRO", 0);
        }
        
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NA ATUALIZAÇÃO NO CADASTRO DE CARRO", 0);
        }
        
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NA ATUALIZAÇÃO NO CADASTRO DE CARRO", 0);
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
            
            String sql3 = "DELETE FROM Car WHERE idPlate = ?";
            jdbcTemplate.update(sql3, plate);
    
            String sql4 = "DELETE FROM Vehicle WHERE plate = ?";
            jdbcTemplate.update(sql4, plate);
            
            JOptionPane.showMessageDialog(null, "CARRO DELETADO COM SUCESSO!", "DELETE DE CARRO", 1);
        }
        
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "DELETE NO CADASTRO DE CARRO", 0);
        }

        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NO DELETE DE CARRO", 0);
        }
    }
    
    public void consultAll(DefaultTableModel tableModel) {
        try {
            String sql5 = "SELECT v.plate, v.idChassis, v.brand, v.model, v.color, v.yearMade, c.quantAirbag " +
                          "FROM Vehicle v " +
                          "INNER JOIN Car c ON (v.plate = c.idPlate)";

            List<Car> listCar = jdbcTemplate.query(sql5, (ResultSet rs, int rowNum) -> {
                Car car = new Car();
                car.setPlate(rs.getString("plate"));
                car.setIdChassis(rs.getString("idChassis"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                car.setYearMade(rs.getInt("yearMade"));
                car.setQuantAirbag(rs.getInt("quantAirbag"));
                return car;
            });

            tableModel.setRowCount(0);

            for (Car c : listCar) {
                tableModel.addRow(new Object[]{
                    c.getPlate(),
                    c.getIdChassis(),
                    c.getBrand(),
                    c.getModel(),
                    c.getColor(),
                    c.getYearMade(),
                    c.getQuantAirbag()
                });
            }
        } 
        
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA CONSULTA DE CARROS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void consultAllByUser(DefaultTableModel tableModel, String userName) {
        try {
            String sql = "SELECT v.plate, v.idChassis, v.brand, v.model, v.color, v.yearMade " +
                        "FROM Vehicle v " +
                        "INNER JOIN User u ON (u.id = v.idUser) " +
                        "WHERE u.name = ?";

            List<Car> listCar = jdbcTemplate.query(sql, new Object[]{userName}, (ResultSet rs, int rowNum) -> {
                Car car = new Car();
                car.setPlate(rs.getString("plate"));
                car.setIdChassis(rs.getString("idChassis"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                car.setYearMade(rs.getInt("yearMade"));
                return car;
            });

            tableModel.setRowCount(0);

            for (Car c : listCar) {
                tableModel.addRow(new Object[]{
                    c.getPlate(),
                    c.getIdChassis(),
                    c.getBrand(),
                    c.getModel(),
                    c.getColor(),
                    c.getYearMade()
                });
            }
        } 
        
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA CONSULTA", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void consultBuy(DefaultTableModel tableModel) {
        try {
            String sql5 = "SELECT v.plate, v.idChassis, v.brand, v.model, v.color, v.yearMade, c.quantAirbag " +
                          "FROM Vehicle v " +
                          "INNER JOIN Car c ON (v.plate = c.idPlate) " +
                          "WHERE (v.sold IS NULL OR v.sold = false) AND (v.available IS NULL OR v.available = true) AND (v.idUser IS NULL OR v.idUser = '')";

            List<Car> listCar = jdbcTemplate.query(sql5, (ResultSet rs, int rowNum) -> {
                Car car = new Car();
                car.setPlate(rs.getString("plate"));
                car.setIdChassis(rs.getString("idChassis"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                car.setYearMade(rs.getInt("yearMade"));
                car.setQuantAirbag(rs.getInt("quantAirbag"));
                return car;
            });

            tableModel.setRowCount(0);

            for (Car c : listCar) {
                tableModel.addRow(new Object[]{
                    c.getPlate(),
                    c.getIdChassis(),
                    c.getBrand(),
                    c.getModel(),
                    c.getColor(),
                    c.getYearMade(),
                    c.getQuantAirbag()
                });
            }
        } 
        
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA CONSULTA DE CARROS", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void buyCar(String plate, String userName){
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

            JOptionPane.showMessageDialog(null, "CARRO COMPRADO COM SUCESSO!", "COMPRA DE CARRO", 1);
        }
       
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA COMPRA DE CARRO", 0);
            System.out.println("Essa exceção");
        }
        
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NA COMPRA DE CARRO", 0);
        }
        
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NA COMPRA DE CARRO", 0);
        }
        
        catch (IdDoesNotExistException ine) {
            ine.screenException();
        }
    }
    
    public Boolean verifyCarPlate(String plate) throws CarNotAvailableException{
        try {
            String checkSql = "SELECT COUNT(*) FROM Vehicle v INNER JOIN Car c ON (v.plate = c.Idplate) WHERE v.plate = ? AND (v.sold IS NULL OR v.sold = false) AND (v.available IS NULL OR v.available = true) AND (v.idUser IS NULL OR v.idUser = '')";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{plate}, Integer.class);
            
            if (count == 0) {
                throw new CarNotAvailableException();
            }
            
            return true;
        }
        
        catch (CarNotAvailableException cnae) {
            cnae.screenException();
            return false;
        }
    }
    
    public void consultCar(String plate, DefaultTableModel tableModel) throws IdDoesNotExistException {
        try {
            String checkSql = "SELECT COUNT(*) FROM Vehicle WHERE plate = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{plate}, Integer.class);
            
            if (count == 0) {
                throw new IdDoesNotExistException();
            }
            
            String sql = "SELECT v.plate, v.idChassis, v.brand, v.model, v.color, v.yearMade, c.quantAirbag " +
                         "FROM Vehicle v " +
                         "INNER JOIN Car c ON v.plate = c.idPlate " +
                         "WHERE v.plate = ?";

            Car car = jdbcTemplate.queryForObject(sql, new Object[]{plate}, (ResultSet rs, int rowNum) -> {
                Car carAux = new Car();
                carAux.setPlate(rs.getString("plate"));
                carAux.setIdChassis(rs.getString("idChassis"));
                carAux.setBrand(rs.getString("brand"));
                carAux.setModel(rs.getString("model"));
                carAux.setColor(rs.getString("color"));
                carAux.setYearMade(rs.getInt("yearMade"));
                carAux.setQuantAirbag(rs.getInt("quantAirbag"));
                return carAux;
            });

            tableModel.setRowCount(0);

            tableModel.addRow(new Object[]{
                car.getPlate(), 
                car.getIdChassis(), 
                car.getBrand(), 
                car.getModel(), 
                car.getColor(),
                car.getYearMade(), 
                car.getQuantAirbag()
            });
        } 
        
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "CONSULTA DE CARRO", 0);
        }
        
        catch (IdDoesNotExistException ine) {
            ine.screenException();
        }
    }
    
}
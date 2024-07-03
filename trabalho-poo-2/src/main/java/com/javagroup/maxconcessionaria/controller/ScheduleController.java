package com.javagroup.maxconcessionaria.controller;

import com.javagroup.maxconcessionaria.controller.exception.ScheduleAlreadyExistsException;
import com.javagroup.maxconcessionaria.model.Schedule;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


@Repository
public class ScheduleController {
    
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ScheduleController(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void save(Date dateSchedule, String userName) throws NumberFormatException {
        try {
            String returnIdUser = "SELECT id FROM User WHERE User.name = ?";
            int idUser = jdbcTemplate.queryForObject(returnIdUser, new Object[]{userName}, Integer.class);
            
            String checkSql = "SELECT COUNT(*) FROM Schedule INNER JOIN User ON (User.id = Schedule.idUser) WHERE User.id = ? AND Schedule.date = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{idUser, dateSchedule}, Integer.class);
            
            
            if (count > 0) {
                throw new ScheduleAlreadyExistsException();
            }
            
            String sql = "INSERT INTO Schedule VALUES (?, ?)";
            jdbcTemplate.update(sql, idUser, dateSchedule);
            
            JOptionPane.showMessageDialog(null, "AGENDA CADASTRADA COM SUCESSO!", "CADASTRO DE AGENDA", 1);
        }
        
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NO CADASTRO DE AGENDA", 0);
        }
        
        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO OU VAZIO!", "ERRO NO CADASTRO DE AGENDA", 0);
        }
        
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "TIPO DE DADO CADASTRADO ERRADO!", "ERRO NO CADASTRO DE AGENDA", 0);
        }
        
        catch (ScheduleAlreadyExistsException saee){
            saee.screenException();
        }
        
    } 
    
    public void delete(Date dateSchedule, String userName){
        try{
            String returnIdUser = "SELECT id FROM User WHERE User.name = ?";
            int idUser = jdbcTemplate.queryForObject(returnIdUser, new Object[]{userName}, Integer.class);
            
            String checkSql = "SELECT COUNT(*) FROM Schedule INNER JOIN User ON (User.id = Schedule.idUser) WHERE User.id = ? AND Schedule.date = ?";
            int count = jdbcTemplate.queryForObject(checkSql, new Object[]{idUser, dateSchedule}, Integer.class);
            
            if (count == 0) {
                throw new NumberFormatException();
            }
            
            String sql3 = "DELETE FROM Schedule WHERE idUser = ? AND date = ?";
            jdbcTemplate.update(sql3, idUser, dateSchedule);
            
            JOptionPane.showMessageDialog(null, "AGENDA DELETADA COM SUCESSO!", "DELETE DE AGENDA", 1);
        }
        
        catch (DataAccessException ex){
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "DELETE NO CADASTRO DE AGENDA", 0);
        }

        catch (NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "USUÁRIO OU AGENDA NÃO EXISTENTE!", "ERRO NO DELETE DE AGENDA", 0);
        }
    }
    
    public void consultAll(DefaultTableModel tableModel) {
        try {
            String sql5 = "SELECT s.date, u.name " +
                          "FROM Schedule s " +
                          "INNER JOIN User u ON (u.id = s.idUser) " +
                          "ORDER BY u.name";
            
            List<Schedule> listSchedule = jdbcTemplate.query(sql5, (ResultSet rs, int rowNum) -> {
                Schedule schedule = new Schedule();
                schedule.setDate(rs.getDate("date"));
                schedule.setUserName(rs.getString("name"));
                
                return schedule;
            });
            
            
            tableModel.setRowCount(0);

            for (Schedule s : listSchedule) {
                tableModel.addRow(new Object[]{
                    s.getUserName(),
                    s.getDate()
                });
            }
        } 
        
        catch (DataAccessException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA AÇÃO DO BANCO DE DADOS!", "ERRO NA CONSULTA DE AGENDA", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    
}


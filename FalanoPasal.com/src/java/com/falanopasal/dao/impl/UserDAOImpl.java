/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.dao.impl;

import com.falanopasal.constant.SQLConstant;
import com.falanopasal.dao.UserDAO;
import com.falanopasal.entity.Login;
import com.falanopasal.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bipin
 */
@Repository
public class UserDAOImpl implements UserDAO{
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) throws SQLException, ClassNotFoundException, ParseException {
        return jdbcTemplate.update(SQLConstant.User.USER_INSERT, new Object[]{
           user.getFirstName(),
            user.getLastName(),
            user.getEmail(),
            user.getUsername(),
            user.getPassword(),
            user.getCity(),
            user.getAddressLine1(),
            user.getAddressLine2(),
            user.getHouseNo(),
            user.getFamilyType(),
            user.getPhoneNo(),
            user.getBirthdateformat(),
            user.getRoleId(),
            user.isStatus(),
            user.getEmailToken(),
            user.getEnrollDate()
        });
    }

    @Override
    public boolean isUsernameExist(String username) throws SQLException, ClassNotFoundException {
        Integer count = jdbcTemplate.queryForObject(SQLConstant.User.IS_USERNAME_EXIST, new String[]{username}, Integer.class);
        if(count>=1){
            return true;
        }
        return false;
    }

    @Override
    public User getByUsername(User user) throws SQLException, ClassNotFoundException {
        List<User> fetchUsernameData = jdbcTemplate.query(SQLConstant.User.GET_BY_USERNAME, new Object[]{user.getUsername()}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
        return fetchUsernameData.size() > 0 ? fetchUsernameData.get(0):null;
    }

    public User mapData(ResultSet rs) throws SQLException{
        User user = new User();
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setEmail(rs.getString("email"));
        user.setUsername(rs.getString("username"));
        user.setCity(rs.getString("city"));
        user.setAddressLine1(rs.getString("addressLine1"));
        user.setAddressLine2(rs.getString("addressLine2"));
        user.setHouseNo(rs.getInt("houseNo"));
        user.setBirthdateformat(rs.getDate("birthdate"));
        user.setUserId(rs.getInt("userId"));
        user.setEmailToken(rs.getString("emailToken"));
        user.setStatus(rs.getBoolean("status"));        
        user.setPassword(rs.getString("password"));
        user.setRoleId(rs.getInt("roleId"));
        user.setDebitAmount(rs.getDouble("debitamount"));
        user.setOrderCount(rs.getInt("ordercount"));
        return user;
    }

    @Override
    public User getByUserId(User user) throws SQLException, ClassNotFoundException {
        List<User> fetchUserIdData = jdbcTemplate.query(SQLConstant.User.GET_BY_USERID, new Object[]{user.getUserId()},new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });    
        return fetchUserIdData.size() > 0 ? fetchUserIdData.get(0):null;
    }

    @Override
    public void updateUserStatus(int userId) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.User.UPDATE_USER_STATUS, new Object[]{userId});
    }

    @Override
    public User usernameAuthentication(Login login) throws SQLException, ClassNotFoundException {
        List<User> checkUsername = jdbcTemplate.query(SQLConstant.User.GET_BY_USERNAME, new Object[]{login.getUsername()},new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
        return checkUsername.size() > 0 ? checkUsername.get(0):null;
    }

    @Override
    public List<User> getAllCustomer() throws SQLException, ClassNotFoundException {
        return jdbcTemplate.query(SQLConstant.User.GET_ALL_CUSTOMER, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                return mapData(rs);
            }
        });
    }

    @Override
    public void updateDebitAmount(User user) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.User.MINUS_DEBIT_AMOUNT, new Object[]{user.getDebitAmount(),user.getUsername()});
    }

    @Override
    public void updateOrderCount(String username) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.User.UPDATE_ORDER_COUNT, new Object[]{username});
    }

    @Override
    public void updateUserPassword(User user) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.User.UPDATE_PASSWORD, new Object[]{user.getPassword(),user.getUsername()});
    }

    @Override
    public int getTotalCalorieValue(String username) throws SQLException, ClassNotFoundException {
        int totalCalorie = jdbcTemplate.queryForObject(SQLConstant.ShoppingCarts.GET_TOTAL_CALORIE_VALUE, new Object[]{username},Integer.class);
        return totalCalorie;
    }

    @Override
    public boolean isUsernameShopped(String username) throws SQLException, ClassNotFoundException {
        int count = jdbcTemplate.queryForObject(SQLConstant.ShoppingCarts.CHECK_USERNAME_IN_SHOPPING_CART, new Object[]{username}, Integer.class);
        if(count>=1){
            return true;
        }
        return false;
    }

    @Override
    public void registerDebitAmount(User user) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.RechargeDebitAmount.REGISTER_DEBIT_AMOUNT, new Object[]{user.getDebitAmount(),user.getRechargeToken()});
    }

    @Override
    public int getRechargeAmount(String rechargeToken) throws SQLException, ClassNotFoundException {
        int debitAmount = jdbcTemplate.queryForObject(SQLConstant.RechargeDebitAmount.GET_PIN_AMOUNT, new Object[]{rechargeToken},Integer.class);
        return debitAmount;
    }

    @Override
    public void updateUserDebitAmount(User user) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.RechargeDebitAmount.PLUS_DEBIT_AMOUNT, new Object[]{user.getDebitAmount(),user.getUsername()});
    }

    @Override
    public void updatePinStatus(String rechargeToken) throws SQLException, ClassNotFoundException {
        jdbcTemplate.update(SQLConstant.RechargeDebitAmount.UPDATE_PIN_STATUS, new Object[]{rechargeToken});
    }

    @Override
    public int getTotalExpense(String username) throws SQLException, ClassNotFoundException {
        int totalExpenses = jdbcTemplate.queryForObject(SQLConstant.User.GET_TOTAL_EXPENSES, new Object[]{username}, Integer.class);
        if(totalExpenses==0){
            return totalExpenses=0;
        }else{
           return totalExpenses; 
        }
    }

    @Override
    public int getCreditAmount(String username) throws SQLException, ClassNotFoundException {
        int creditAmount = jdbcTemplate.queryForObject(SQLConstant.User.GET_USER_CREDIT_AMOUNT, new String[]{username}, Integer.class);
            return creditAmount=0;
    }

    @Override
    public boolean checkUserCredit(String username) throws SQLException, ClassNotFoundException {
        Integer count = jdbcTemplate.queryForObject(SQLConstant.User.CHECK_USER_CREDIT, new String[]{username}, Integer.class);
        if(count>=1){
            return true;
        }
        return false;
    }


    

    
        
        
    
    
    
    
}

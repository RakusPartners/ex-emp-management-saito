package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Administrator;

/**
*   AdministratorRepositoryクラス
*   @author Ryo Saito
*/
@Repository
public class AdministratorRepository {

    private static final RowMapper<Administrator> ADMINISTRATOR_ROW_MAPPER = (rs,i) ->{
        Administrator administrator = new Administrator();
        administrator.setId(rs.getInt("id"));
        administrator.setName(rs.getString("name"));
        administrator.setMailAddress(rs.getString("mail_address"));
        administrator.setPassword(rs.getString("password"));

        return administrator;
    };

    @Autowired
    private NamedParameterJdbcTemplate template;


    /**
     * Administrator情報を挿入するメソッド
     * @param administrator 
     */
    public void insert(Administrator administrator){
        String insertSql = "INSERT INTO administrators(name, mail_address, password) VALUES (:name, :mail_address, :password);";
        SqlParameterSource param = new MapSqlParameterSource().addValue("name", administrator.getName()).addValue("mail_address", administrator.getMailAddress()).addValue("password", administrator.getPassword());

        template.update(insertSql, param);
    }

    /**
     * メールアドレスとパスワードから管理者情報を取得するメソッド
     * @param mailAddress
     * @param password
     * @return Administrator
     */
    public Administrator findByMailAddressAndPassword(String mailAddress, String password){
        
        String sql = "SELECT id, name, mail_address, password FROM administrators WHERE mail_address=:mailAddress AND password=:password";

        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress).addValue("password", password);
        
        List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);

        if (administratorList.size() == 0) {
            return null;
        }

        return administratorList.get(0);
    }

    /**
     * メールアドレス検索
     * @param mailAddress
     * @return Administrator
     */
    public Administrator findByMail(String mailAddress){
        String sql= "SELECT id, name, mail_address, password FROM administrators WHERE mail_address=:mailAddress";

        SqlParameterSource param = new MapSqlParameterSource().addValue("mailAddress", mailAddress);

        List<Administrator> administratorList = template.query(sql, param, ADMINISTRATOR_ROW_MAPPER);

        if (administratorList.size() == 0) {
            return null;
        }

        return administratorList.get(0);

    }
    
}

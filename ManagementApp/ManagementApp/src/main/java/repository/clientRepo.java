package repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pojo.client;

import java.util.List;
@Repository
public class clientRepo {
    private final JdbcTemplate jdbcTemplate;

    public clientRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Create - INSERT
    public int addClient(client client){
        String sql = "INSERT INTO client(nume,prenume,email,categorie,varsta,sex,descriere) VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, client.getNume(), client.getPrenume(),client.getEmail(),client.getCategorie(),client.getVarsta(),client.getSex(),client.getDescriere());
    }

    //Read - SELECT
    public List<client> getClient(){
        return jdbcTemplate.query("SELECT * FROM client", new BeanPropertyRowMapper<>(client.class));
    }

    //Update - UPDATE
    public void editClient(String id, client newClient){
        String sql = "UPDATE books SET nume=?,prenume=?,email=?,categorie=?,varsta=?,sex=?,descriere=? WHERE id=?";
         jdbcTemplate.update(sql, newClient.getNume(), newClient.getPrenume(),newClient.getEmail(),newClient.getCategorie(),newClient.getVarsta(),newClient.getSex(),newClient.getDescriere(),id);
    }

    //Delete - DELETE
    public void deleteClient(String id){
        final String sql = "DELETE FROM books WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}

    }


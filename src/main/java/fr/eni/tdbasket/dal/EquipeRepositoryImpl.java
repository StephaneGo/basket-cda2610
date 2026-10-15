package fr.eni.tdbasket.dal;

import fr.eni.tdbasket.bo.Equipe;
import fr.eni.tdbasket.exception.EquipeDejaExistante;
import fr.eni.tdbasket.exception.EquipeNotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EquipeRepositoryImpl implements EquipeRepository{

    private JdbcTemplate jdbcTemplate;

    public EquipeRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    class EquipeRowMapper implements RowMapper<Equipe> {

        @Override
        public Equipe mapRow(ResultSet rs, int rowNum) throws SQLException {
            Equipe equipe = new Equipe();
            equipe.setNoEquipe(rs.getInt("noEquipe"));
            equipe.setNom(rs.getString("nom"));
            return equipe;
        }
    }

    @Override
    public List<Equipe> findAllEquipes() {
        String sql = "select noEquipe, nom from equipes";
        List<Equipe> equipes = jdbcTemplate.query(sql, new EquipeRowMapper());

        return equipes;
    }




    @Override
    public Optional<Equipe> findByNom(String nom) {
        String sql = "select noEquipe, nom from equipes where nom = ?";
        Optional<Equipe> optEquipe;
        try{
            optEquipe = Optional.ofNullable(jdbcTemplate.queryForObject(sql, new EquipeRowMapper(), nom));
        }catch(EmptyResultDataAccessException e){
            optEquipe = Optional.empty();
        }

        return optEquipe;
    }

    @Override
    public Equipe saveEquipe(Equipe equipe)  {
        //ajout
        String sql = "insert into equipes ( nom) values ( ?)";

        Equipe newEquipe;
        //KeyHolder permet de récupérer la clé primaire générée par la base
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(
                    connection -> {
                        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1, equipe.getNom());
                        return ps;
                    },
                    keyHolder
            );
            newEquipe = new Equipe();
            BeanUtils.copyProperties(equipe, newEquipe);
            newEquipe.setNoEquipe(keyHolder.getKey().intValue());
        }catch(DuplicateKeyException exc){
            throw new EquipeDejaExistante(equipe.getNom());
        }
        return newEquipe;
    }

    @Override
    public void deleteEquipeByNom(String nom) {
        String sql = "delete from equipes where nom = ?";
        int nbRows = jdbcTemplate.update(sql, nom);
        if(nbRows==0){
            throw new EquipeNotFound(nom);
        }
    }

    @Override
    public void deleteEquipeByNo(int noEquipe) {
        String sql = "delete from equipes where noEquipe = ?";
        int nbRows = jdbcTemplate.update(sql, noEquipe);
        if(nbRows==0){
            throw new EquipeNotFound(noEquipe);
        }
    }
}

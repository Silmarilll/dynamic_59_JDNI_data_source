package com.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("offersDao")
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;

	public NamedParameterJdbcTemplate getJdbc() {
		return jdbc;
	}


	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	
	@SuppressWarnings("unchecked")
	public List<Offer> getAllOffers() {
		
		return jdbc
				.query("select * from offers, users where offers.username=users.username and users.enabled=true",
						new RowMapper<Offer>() {

							public Offer mapRow(ResultSet rs, int rowNum)
									throws SQLException {

								User user = new User();
								user.setAuthority(rs.getString("authority"));
								user.setEmail(rs.getString("email"));
								user.setEnabled(true);
								user.setName(rs.getString("name"));
								user.setUsername(rs.getString("username"));

								Offer offer = new Offer();
								offer.setId(rs.getInt("id"));
								offer.setText(rs.getString("text"));
								offer.setUser(user);

								return offer;
							}

						});
	}

	
	public Offer getOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers, users where offers.username=users.username and users.enabled=true", params,
				new RowMapper<Offer>() {

					public Offer mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setAuthority(rs.getString("authority"));
						user.setEmail(rs.getString("email"));
						user.setEnabled(true);
						user.setName(rs.getString("name"));
						user.setUsername(rs.getString("username"));

						Offer offer = new Offer();
						offer.setId(rs.getInt("id"));
						offer.setText(rs.getString("text"));
						offer.setUser(user);

						return offer;
					}

				});
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from offers where id=:id", params) == 1;
	}
	
	public boolean create(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc
				.update("insert into offers (username, text) values (:username, :text)",
						params) == 1;
	}
	
	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("update offers set username = :username, text = :text where id = :id", params) == 1;
	}

}

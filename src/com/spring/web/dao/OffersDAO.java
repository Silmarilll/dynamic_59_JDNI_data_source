package com.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("offersDao")
@Transactional
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {

		return jdbc
				.query("select * from offers, users where offers.username=users.username and users.enabled=true",
						new OfferRowMapper());
	}
	
	@SuppressWarnings("unchecked")
	public List<Offer> getOffers(String username) {
		
		return jdbc
				.query("select * from offers, users where offers.username=users.username and users.enabled=true",
						new MapSqlParameterSource("username", username), new OfferRowMapper());

	}

	
	public Offer getOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers, users where offers.username=users.username and users.enabled=true and id=:id", params,
				new OfferRowMapper());
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from offers where id=:id", params) == 1;
	}
	
	public void create(Offer offer) {
		session().save(offer);
	}
	
	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("update offers set username = :username, text = :text where id = :id", params) == 1;
	}

}

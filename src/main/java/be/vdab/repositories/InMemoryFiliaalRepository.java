package be.vdab.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import be.vdab.entities.Filiaal;
import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.PostcodeReeks;

@Repository
public class InMemoryFiliaalRepository implements FiliaalRepository {
	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final RowMapper<Filiaal> rowMapper = (resultSet, rowNum) -> {
		return new Filiaal(resultSet.getLong("id"), resultSet.getString("naam"), resultSet.getBoolean("hoofdFiliaal"),
				resultSet.getBigDecimal("waardeGebouw"), resultSet.getDate("inGebruikName").toLocalDate(),
				new Adres(resultSet.getString("straat"), resultSet.getString("huisNr"), resultSet.getInt("postcode"),
						resultSet.getString("gemeente")));
	};
	private static final String BEGIN_SQL = "select id, naam, hoofdFiliaal, straat, huisNr, postcode, gemeente,"
			+ "inGebruikName, waardeGebouw from filialen ";
	private static final String SQL_FIND_ALL = BEGIN_SQL + "order by naam";
	private static final String SQL_READ = BEGIN_SQL + "where id = ?";
	private static final String SQL_FIND_BY_POSTCODE = BEGIN_SQL + "where postcode between ? and ? order by naam";
	private final Map<Long, Filiaal> filialen = new ConcurrentHashMap<>();

	InMemoryFiliaalRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void create(Filiaal filiaal) {
		filiaal.setId(Collections.max(filialen.keySet()) + 1);
		filialen.put(filiaal.getId(), filiaal);

	}

	@Override
	public Optional<Filiaal> read(long id) {
		try {
			return Optional.of(jdbcTemplate.queryForObject(SQL_READ, rowMapper, id));
		} catch (IncorrectResultSizeDataAccessException ex) {
			return Optional.empty(); // record niet gevonden
		}
	}

	@Override
	public void update(Filiaal filiaal) {
		filialen.put(filiaal.getId(), filiaal);

	}

	@Override
	public void delete(long id) {
		filialen.remove(id);

	}

	@Override
	public List<Filiaal> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
	}

	@Override
	public long findAantalFilialen() {
		return filialen.size();
	}

	@Override
	public long findAantalWerknemers(long id) {
		return id == 1L ? 7L : 0L;
	}

	@Override
	public List<Filiaal> findByPostcodeReeks(PostcodeReeks reeks) {
		return jdbcTemplate.query(SQL_FIND_BY_POSTCODE, rowMapper, reeks.getVanpostcode(), reeks.getTotpostcode());
	}

}

package be.vdab.repositories;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Filiaal;
import be.vdab.valueobjects.Adres;

@Repository
public class InMemoryFiliaalRepository implements FiliaalRepository {
	private final Map<Long, Filiaal> filialen = new ConcurrentHashMap<>();

	InMemoryFiliaalRepository() {
		filialen.put(1L, new Filiaal(1, "Andros", true, BigDecimal.valueOf(1000), LocalDate.now(),
				new Adres("Keizerslaan", "11", 1000, "Brussel")));
		filialen.put(2L, new Filiaal(2, "Delos", false, BigDecimal.valueOf(2000), LocalDate.now(),
				new Adres("Gasthuisstraat", "31", 1000, "Brussel")));
		filialen.put(3L, new Filiaal(3, "Gavdos", false, BigDecimal.valueOf(3000), LocalDate.now(),
				new Adres("Koestraat", "44", 9700, "Oudenaarde")));
	}

	@Override
	public void create(Filiaal filiaal) {
		filiaal.setId(Collections.max(filialen.keySet()) + 1);
		filialen.put(filiaal.getId(), filiaal);

	}

	@Override
	public Optional<Filiaal> read(long id) {
		return Optional.ofNullable(filialen.get(id));
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
		return new ArrayList<>(filialen.values());
	}

	@Override
	public long findAantalFilialen() {
		return filialen.size();
	}

	@Override
	public long findAantalWerknemers(long id) {
		return id == 1L ? 7L : 0L;
	}

}

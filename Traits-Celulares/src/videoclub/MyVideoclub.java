package videoclub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.uqbar.commons.model.Application;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Home;

import tadp.blocbaster.daos.HomeFactory;
import tadp.blocbaster.daos.InMemoryHomeFactory;
import tadp.blocbaster.entidades.Pelicula;

public class MyVideoclub implements Application {
	private static MyVideoclub instance;
	private Map<Class<?>, Home<?>> homes;
	private static Boolean mutex =true;

	@SuppressWarnings("unchecked")
	public synchronized <T extends Entity> Home<T> getHome(Class<? extends T> type) {
		return (Home<T>) this.homes.get(type);
	}

	private MyVideoclub(HomeFactory factory) {
		Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();
		factory.addHomes(homes);
		this.homes = homes;
		instance = this;
	}
	
	public static synchronized MyVideoclub getInstance() {
		synchronized (mutex) {
			if (instance == null) {
				instance = new MyVideoclub(new InMemoryHomeFactory());
			}
			return instance;
		}
	}

	public List<String> getGeneros() {
		SortedSet<String> set = new TreeSet<String>();
		for (Pelicula unaPelicula : this.getHome(Pelicula.class).allInstances()) {
			set.add(unaPelicula.getGenero());
		}
		List<String> listaGeneros = new ArrayList<String>();
		listaGeneros.addAll(set);
		return listaGeneros;
	}
	
}

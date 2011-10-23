package ar.edu.unq.tpi.comparator.ui.utils;

import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.lacar.ui.model.BindingBuilder;

public class FakeFalseObservable extends ObservableProperty {

	public FakeFalseObservable(String propertyName) {
		super(propertyName);
	}

	@Override
	public void configure(BindingBuilder binder) {
		super.configure(binder);
		binder.setAdapter(new FakeFalseAdapter());
	}
}
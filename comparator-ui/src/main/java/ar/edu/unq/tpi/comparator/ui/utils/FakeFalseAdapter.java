package ar.edu.unq.tpi.comparator.ui.utils;

import org.uqbar.lacar.ui.model.Adapter;

public class FakeFalseAdapter implements Adapter<Object, Boolean> {

	@Override
	public Object viewToModel(Boolean valueFromView) {
		return null;
	}

	@Override
	public Boolean modelToView(Object valueFromModel) {
		return false;
	}

	@Override
	public Class<Object> getModelType() {
		return Object.class;
	}

	@Override
	public Class<Boolean> getViewType() {
		return Boolean.class;
	}
	
}
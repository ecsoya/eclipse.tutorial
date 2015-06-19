package org.ecsoya.eclipse.tutorial.jface.viewers;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public abstract class Model {

	private String name;

	final PropertyChangeSupport support;

	public Model(String name) {
		this.name = name;
		support = new PropertyChangeSupport(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldName = this.name;
		this.name = name;
		support.firePropertyChange("name", oldName, name);
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		support.addPropertyChangeListener(l);
	}

	public void removePropertyChangeListener(PropertyChangeListener l) {
		support.removePropertyChangeListener(l);
	}

	public void addChild(List list, Object child, String propertyName) {
		if (list == null || child == null || list.contains(child)) {
			return;
		}
		Object oldValue = list;
		list.add(child);
		support.firePropertyChange(propertyName, oldValue, list);

	}

	public void removeChild(List list, Object child, String propertyName) {
		if (list == null || child == null || !list.contains(child)) {
			return;
		}
		Object oldValue = list;
		list.remove(child);
		support.firePropertyChange(propertyName, oldValue, list);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Model other = (Model) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

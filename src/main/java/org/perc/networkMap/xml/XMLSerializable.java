package org.perc.networkMap.xml;

import processing.data.XML;

import java.text.ParseException;

public interface XMLSerializable {
	default XML save() {
		return save(this.getClass().getSimpleName());
	}
	XML save(String name);
}

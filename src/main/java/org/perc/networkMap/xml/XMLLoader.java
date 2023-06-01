package org.perc.networkMap.xml;

import processing.data.XML;

public interface XMLLoader<T> {
	public T load(XML xml) throws Exception;
}

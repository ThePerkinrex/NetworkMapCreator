package org.perc.map;

import org.perc.map.line.Line;
import org.perc.map.node.Node;
import org.perc.map.node.SimpleNode;
import org.perc.map.node.StationNode;
import org.perc.map.station.BlobStation;
import org.perc.map.station.Station;
import processing.data.XML;

import java.util.*;

public class Map {
	private List<Line> lines;

	public Map() {
		this.lines = new ArrayList<>();
	}

	public List<Line> getLines() {
		return lines;
	}

	private static class RefList<E> implements Iterable<E> {
		private final List<E> list;

		public RefList(List<E> list) {
			this.list = list;
		}

		public E get(int i) {
			return list.get(i);
		}

		public int getRef(E elem) throws NoSuchElementException {
			int r = list.indexOf(elem);
			if (r == -1) throw new NoSuchElementException();
			return r;
		}

		public int addOrGetWithIdx(E elem) {
			try {
				return getRef(elem);
			}catch (NoSuchElementException ignored) {
				int r = list.size();
				list.add(elem);
				return r;
			}
		}

		@Override
		public Iterator<E> iterator() {
			return list.iterator();
		}
	}

	public XML save() {
		XML res = new XML("NetworkMap");
		XML lines = new XML("Lines");
		RefList<Station> stationList = new RefList<>(new LinkedList<>());
		RefList<Node> nodeList = new RefList<>(new LinkedList<>());

		for(Line line : this.lines) {
			XML lineXML = new XML("Line");
			lineXML.setString("name", line.getName());
			for (Node n : line) {
				int ref = nodeList.addOrGetWithIdx(n);
				XML nodeRef = new XML("NodeRef");
				nodeRef.setIntContent(ref);
				lineXML.addChild(nodeRef);
			}
			lines.addChild(lineXML);
		}


		XML nodes = new XML("Nodes");
		for (Node n : nodeList) {
			XML node;
			if (n instanceof SimpleNode sn) {
				node = new XML("SimpleNode");
				node.addChild(sn.getCoords().save());
			}else if (n instanceof StationNode sn) {
				node = new XML("StationNode");
				XML coords = sn.getCoords().save();
				coords.setName("RelativeCoords");
				node.addChild(coords);
				XML station = new XML("StationRef");
				station.setIntContent(stationList.addOrGetWithIdx(sn.getStation()));
				node.addChild(station);
			}else{
				throw new RuntimeException("Unexpected node kind");
			}
			nodes.addChild(node);
		}
		XML stations = new XML("Stations");
		for (Station s : stationList) {
			XML station = new XML("Station");
			station.addChild(s.getCoords().save());
			station.setString("name", s.getName());
			XML station_nodes = new XML("Nodes");
			for (StationNode n : s.nodes()) {
				XML nodeRef = new XML("NodeRef");
				nodeRef.setIntContent(nodeList.addOrGetWithIdx(n));
				station_nodes.addChild(nodeRef);
			}
			station.addChild(station_nodes);
			stations.addChild(station);
		}
		res.addChild(stations);
		res.addChild(nodes);
		res.addChild(lines);
		System.out.println(res.format(4));
		return res;
	}
}

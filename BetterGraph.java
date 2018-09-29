package ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BetterGraph {
	private int nVertex;
	private String direction;
	private ArrayList[] adjacents;
	private Map<String,Integer> source=new HashMap<String,Integer>();
	
	public BetterGraph(int nVertex, String direction) {
		super();
		this.nVertex = nVertex;
		this.direction = direction;
		
		adjacents = new ArrayList[nVertex];
		
		for(int i=0;i<nVertex;i++)
			adjacents[i] = new ArrayList<String>();	
	}
	
	int num=0;
	public void addVertex(String src) {
		if(!(source.containsKey(src))) {
			source.put(src, num++);
		}
	}
	
	public void addEdge(String src,String des) {
		if(this.direction!="directed") {
			adjacents[source.get(src)].add(des);
			adjacents[source.get(des)].add(src);
		}
		else if(this.direction=="directed")
			adjacents[source.get(src)].add(des);
	}
	
	public void print() {
		for(Map.Entry<String, Integer> entry: source.entrySet()) {
			System.out.print(entry.getKey()+" --> ");
			for(int i=0;i< adjacents[source.get(entry.getKey())].size()-1;i++) {
				System.out.print(adjacents[source.get(entry.getKey())].get(i)+ " --> ");
			}
			System.out.print(adjacents[source.get(entry.getKey())].get(adjacents[source.get(entry.getKey())].size()-1));
			System.out.println();
		}
	}
}

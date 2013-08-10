import java.util.*;

class Pair<FIRST,SECOND> {
    private final FIRST first;
	private final SECOND second;	
	
	public Pair(FIRST f, SECOND s) {
		first=f;
		second=s;			
	}		
	
	public FIRST first() { return first; }
	public SECOND second() { return second; }
	
	public int hashCode() {
	    return 0; // hack to make output consistent across implementations
	}
		
	public boolean equals(Object o) {
		if(o instanceof Pair) {
			@SuppressWarnings("unchecked")
			Pair<FIRST, SECOND> p = (Pair<FIRST, SECOND>) o;
			boolean r=false;
			if(first != null) { r = first.equals(p.first()); }
			else { r = p.first() == first; }
			if(second != null) { r &= second.equals(p.second()); }
			else { r &= p.second() == second; }
			return r;				
		}
		return false;
	}
}

public class JLS_8_1_2_GenericTypes_2<T,P extends Pair<T,T> > extends HashSet<P> {
	private HashMap<T,HashSet<P>> froms = new HashMap<T,HashSet<P>>();
	private HashMap<T,HashSet<P>> tos = new HashMap<T,HashSet<P>>();
	
	public boolean add(P p) {
		if(super.add(p)) {
			HashSet<P> fp = froms.get(p.first());
			if(fp == null) { 
				fp = new HashSet<P>();
				froms.put(p.first(),fp);
			}
			HashSet<P> tp = tos.get(p.second());
			if(tp == null) { 
				tp = new HashSet<P>();
				tos.put(p.second(),tp);
			}
			fp.add(p);
			tp.add(p);
			return true;
		}
		return false;
	}
		
	public void clear() {
		super.clear();
		froms.clear();
		tos.clear();
	}
	
	public boolean remove(P p) {
		if(super.remove(p)) {
			froms.get(p.first()).remove(p);
			tos.get(p.second()).remove(p);
			return true;
		}
		return false;
	}
	
	/**
	 * Returns shallow copy of this graph.
	 */
	public Object clone() {
		// could maybe make this more efficient ...
		JLS_8_1_2_GenericTypes_2<T,P> c = new JLS_8_1_2_GenericTypes_2<T,P>();
		c.addAll(this);
		return c;
	}
	
	public Set<P> from(T x) {
		HashSet<P> fx = froms.get(x);
		return fx == null ? new HashSet<P>() : fx; 
	}
	
	public Set<P> to(T x) {
		HashSet<P> tx = tos.get(x);
		return tx == null ? new HashSet<P>() : tx;		
	}
	
	public static final long serialVersionUID = 1l;

    public static void main(String[] args) {
	JLS_8_1_2_GenericTypes_2<String,Pair<String,String>> graph = new JLS_8_1_2_GenericTypes_2<String,Pair<String,String>>();
	
	graph.add(new Pair("Ealing","Ealing Common"));
	graph.add(new Pair("Ealing Common","Acton Town"));
	graph.add(new Pair("Acton Town","Hammersmith"));
	graph.add(new Pair("Hammersmith","Barons Court"));
	graph.add(new Pair("Barons Court","Earls Court"));
	graph.add(new Pair("Earls Court","Gloucester Road"));
	graph.add(new Pair("Gloucester Road","South Ken"));
	graph.add(new Pair("South Ken","Knightsbridge"));
	graph.add(new Pair("South Ken","Highstreet Ken"));
	graph.add(new Pair("Highstreet Ken","Notting Hill Gate"));
	graph.add(new Pair("Notting Hill Gate","Queensway"));
	graph.add(new Pair("Queensway","Lancaster Gate"));
	graph.add(new Pair("Lancaster Gate","Marble Arch"));
	graph.add(new Pair("Marble Arch","Bond Street"));
	graph.add(new Pair("Bond Street","Oxford Circus"));
	graph.add(new Pair("Oxford Circus","Tottenham Court Road"));
	graph.add(new Pair("Tottenham Court Road","Holborn"));
	graph.add(new Pair("Knightsbridge","Hyde Park Corner"));
	graph.add(new Pair("Hyde Park Corner","Green Park"));
	graph.add(new Pair("Green Park","Picaddily Circus"));
	graph.add(new Pair("Picaddily Circus","Leicester Square"));
	graph.add(new Pair("Leicester Square","Covent Garden"));
	graph.add(new Pair("Covent Garden","Holborn"));
	
	HashSet<String> visited = new HashSet<String>();
	Stack<String> worklist = new Stack<String>();
	worklist.push("Ealing");
	visited.add("Ealing");

	while(!worklist.isEmpty()) {
	    String v = worklist.peek();
	    visited.add(v);
	    System.out.println("Visited: " + v);
	    worklist.pop();
	    for(Pair<String,String> edge : graph.from(v)) {
		if(!visited.contains(edge.second())) {
		    worklist.add(edge.second());
		    visited.add(edge.second());
		}
	    }
	}
	
    }
}

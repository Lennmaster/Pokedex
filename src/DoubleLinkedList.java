public class DoubleLinkedList implements List {
	private static Pokemon head = new Pokemon();
	private static Pokemon tail = new Pokemon();
	
	public DoubleLinkedList() {
		head.setNext(tail);
		tail.setPrev(head);
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head.next() == tail;
	}

	@Override
	public int length() {
		int l = 0;
		Pokemon p = head.next();
		
		while(p != tail) {
			l++;
			p = p.next();
		}
		return l;
	}

	@Override
	public Pokemon firstPokemon() {
		return head;
	}

	@Override
	public void insert(Pokemon p) {
		p.setNext(tail);
		p.setPrev(tail.prev());
		tail.prev().setNext(p);
		tail.setPrev(p);
                tail.prev().next().toString();
	}

	@Override
	public void delete(Pokemon p) {
		Pokemon x = head;
		Pokemon y = head.next();
		
		while(y != tail && y != p) {
			x = x.next();
			y = y.next();
		}
		
		if(y != tail) {
			x.setNext(y.next());
			x.next().setPrev(y.prev());
		}
		
	}
	
	public String toString() {
		Pokemon p = head;
		String s = "";
		while(p.next() != tail) {
                    p = p.next();         
                    s += p.toString() + "\n";
		}
		
		return s;
	}
	
	public void insertSorted(Pokemon p) {
		Pokemon x = head;
		Pokemon y = head.next();
		while(y != tail && p.getNr() >= y.getNr() ) {
			x = x.next();
			y = y.next();
		}
		
		p.setPrev(x);
		p.setNext(y);
		x.setNext(p);
		y.setPrev(p);
	}

}

import java.util.ArrayList;
import java.util.List;

public class TreasureChest {
	
	private List<Itemable> items = new ArrayList<Itemable>();
	
	public TreasureChest (List<Itemable> items) {
		this.items = items;
		
		Potion p = new Potion(10, 0);
		this.items.add(p);
		
	}
	
	public String show () {
		String string = "Chest:\n";
		
		for(Itemable i : items) {
			string += i.show() + "\n";
		}
		
		return string;
	}
	
	public List<Itemable> take (){
		return items;
	}
	
}

// Product (on peut faire de l'héritage mais pas beoin pour l'exeple concis)
class Hamburger{
	private string top; 					// dessus  
	private LinkedList<String> 	garnitures;	// liste de garniture dans la hamburger
	private string bot;						// dessous 
	
	public void setTop(String top)){
		this.top = top;
	}
	
	public setMid(String garnitures...){
		for(String s: garnitures)
			this.garnitures.add(garnitures);
	}
		
	public setBot(String bot){
		this.bot = bot;
	}
	
	public String toString(){
		return "[" + top + " " + garnitures + " " + bot + "]";
	}
}



// Builder
interface HamburgerBuilder{
	public void buildTop();
	public void buildGarnitures();
	public void builBot();
	
	//private Hamburger hamburger;		// possible depuis java X (variable dans un Interface)
}

// ConcreteBuilder
class MeatBurger implements HamburgerBuilder {
	private Hamburger hamburger;
	
	public void buildTop(){
		hamburger.setTop("Bread");
	}
	
	public void buidBot(){
		hamburger.setBot("Bread");
	}
	
	public void buildGarnitures(){
		
		hamburger.buildGarnitures("Beef", "backen", "beef");
	}
	
	Hamburger getHamburger(){
		return hamburger;
	}
}


// ConcreteBuilder
class MeatBurger implements HamburgerBuilder {
	private Hamburger hamburger;
	
	public void buildTop(){
		hamburger.setTop("Lettuce");
	}
	
	public void buidBot(){
		hamburger.setBot("Lettuce");
	}
	
	public void buildGarnitures(){
		hamburger.buildGarnitures("Tomatoe");
	}
	
	Hamburger getHamburger(){
		return hamburger;
	}
}






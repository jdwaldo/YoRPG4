/*=============================================
  class Priest -- the protagonist of Ye Olde RPG

  A Priest is a Character, and thus has all the attributes and 
  capabilities of a Character -- and then some (possibly).
  A Warrior's attributes -- along with the way she does things -- 
  set her apart from other types of Characters.
  The defining attributes of a Warrior, and the way she goes about 
  doing things, are specified below. Read on!
  =============================================*/

public class Priest extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
    // others inerited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Priest() {
	_hitPts = 85;
	_strength = 40;
	_defense = 15;
	_attack = .3;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Priest( String name ) {
	this();
	_name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    //prepare a Warrior for a special attack
    public void specialize() {
	_attack = .4;
	_defense = 0;
    }
    public void normalize() {
	_attack = .3;
	_defense = 15;
    }

    public int heal() {
	int health = -65;
        lowerHP(health);
	return (-health);
    }
    public int drain( Character x) {
	lowerHP(-40);
	x.lowerHP(40);
	return 40;
    }

    public static String about() {
	return "A holy priest. Weak in physical ability but is able to use magic to heal himself and withstand heavy blows.";
    }


}//end class Warrior

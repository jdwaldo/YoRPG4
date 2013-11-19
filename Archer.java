/*=============================================
  class Archer -- the protagonist of Ye Olde RPG

  A Warrior is a Character, and thus has all the attributes and 
  capabilities of a Character -- and then some (possibly).
  A Warrior's attributes -- along with the way she does things -- 
  set her apart from other types of Characters.
  The defining attributes of a Warrior, and the way she goes about 
  doing things, are specified below. Read on!
  =============================================*/

public class Archer extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
    // others inerited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Archer() {
	_hitPts = 100;
	_strength = 100;
	_defense = 35;
	_attack = .8;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Archer( String name ) {
	this();
	_name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    //prepare a for a special attack
    public void specialize() {
	_attack = 1;
	_defense = 5;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .8;
	_defense = 35;
    }

    public int heal() {
	int health = -20;
        lowerHP(health);
	return (-health);
    }
    public int drain( Character x) {
	lowerHP(-10);
	x.lowerHP(10);
	return 10;
    }

    public static String about() {
	return "A killer with his bow. Uses ariel attacks to quickly defeat his enemies before they get to him.";
    }


}//end class Warrior

/*=============================================
  class Mage -- the protagonist of Ye Olde RPG

  A Warrior is a Character, and thus has all the attributes and 
  capabilities of a Character -- and then some (possibly).
  A Warrior's attributes -- along with the way she does things -- 
  set her apart from other types of Characters.
  The defining attributes of a Warrior, and the way she goes about 
  doing things, are specified below. Read on!
  =============================================*/

public class Mage extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
    // others inerited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Mage() {
	_hitPts = 90;
	_strength = 50;
	_defense = 35;
	_attack = .3;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Mage( String name ) {
	this();
	_name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    //prepare a Mage for a special attack
    public void specialize() {
	_attack = .4;
	_defense = 20;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .3;
	_defense = 35;
    }
    public int heal() {
	int health = -50;
	lowerHP(health);
	return (-health);
    }
    public int drain( Character x) {
	lowerHP(-30);
	x.lowerHP(30);
	return 30;
    }


    public static String about() {
	return "With his command of dark magic he is a threat to all foes. A terror to behold.";
    }


}//end class Warrior

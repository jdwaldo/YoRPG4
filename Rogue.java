/*=============================================
  class Rogue-- the protagonist of Ye Olde RPG

  A Warrior is a Character, and thus has all the attributes and 
  capabilities of a Character -- and then some (possibly).
  A Warrior's attributes -- along with the way she does things -- 
  set her apart from other types of Characters.
  The defining attributes of a Warrior, and the way she goes about 
  doing things, are specified below. Read on!
  =============================================*/

public class Rogue extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
    // others inerited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Rogue() {
	_hitPts = 110;
	_strength = 130;
	_defense = 30;
	_attack = .6;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Rogue( String name ) {
	this();
	_name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    //prepare a Rogue for a special attack
    public void specialize() {
	_attack = .85;
	_defense = 10;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .6;
	_defense = 30;
    }

    public int heal() {
	int health = -35;
        lowerHP(health);
	return (-health);
    }
    public int drain( Character x) {
	lowerHP(-15);
	x.lowerHP(15);
	return 15;
    }

    public static String about() {
	return "An agile thief and murderer. Uses his stealth and ability to sneak up and kill his enemies.";
    }


}//end class Warrior

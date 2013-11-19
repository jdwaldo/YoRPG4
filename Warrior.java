/*=============================================
  class Warrior -- the protagonist of Ye Olde RPG

  A Warrior is a Character, and thus has all the attributes and 
  capabilities of a Character -- and then some (possibly).
  A Warrior's attributes -- along with the way she does things -- 
  set her apart from other types of Characters.
  The defining attributes of a Warrior, and the way she goes about 
  doing things, are specified below. Read on!
  =============================================*/

public class Warrior extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    private String _name = "J. Doe";
    // others inerited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Warrior() {
	_hitPts = 125;
	_strength = 100;
	_defense = 40;
	_attack = .4;
    }


    /*=============================================
      overloaded constructor
      pre:  instance vars are declared
      post: initializes instance vars. _name is set to input String.
      =============================================*/
    public Warrior( String name ) {
	this();
	_name = name;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { return _name; }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    //prepare a Warrior for a special attack
    public void specialize() {
	_attack = .75;
	_defense = 20;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .4;
	_defense = 40;
    }
    public int heal() {
	int health = -30;
	lowerHP(health);
	return (-health);
    }
    public int drain( Character x) {
	lowerHP(-20);
	x.lowerHP(20);
	return 20;
    }

    public static String about() {
	return "Mighty Warrior from a bygone era. Swinger of huge sword, slayer of huger monsters. Like to smash? This is you.";
    }


}//end class Warrior

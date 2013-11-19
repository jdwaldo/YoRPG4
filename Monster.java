/*=============================================
  class Monster -- Represents random incarnations of 
  the adventurer's natural enemy in Ye Olde RPG

  A Monster is a Character, and thus has all the attributes and 
  capabilities of a Character -- and then some (possibly).
  A Monster's attributes -- along with the way it does things -- 
  set it apart from other types of Characters.
  The defining attributes of a Monster, and the way it goes about 
  doing things, are specified below. Read on!
  =============================================*/

public class Monster extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    // inherited from superclass
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Monster() {
	super();
	_hitPts = 150;
	_strength = 20 + (int)( Math.random() * 45 ); // [20,65)
	_defense = 20;
	_attack = 1;
    }

    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public String getName() { 
	return "Nameless MONSTARRR. Roar, snarl, hiss!"; 
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    //"prepare" a Monster for a special attack
    public void specialize() { }
    public void normalize() { }
    public int heal() { return 0; }
    public int drain( Character x) { return 0; }

    public static String about() {
	String blurb;
	blurb = "A savage beast. Hellbent on destroying adventurers. ";
	blurb += "Hath ye Fear?";
	return blurb;
    }


}//end class Monster

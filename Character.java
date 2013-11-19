/*=============================================
  class Character -- superclass for combatants in Ye Olde RPG

  Ye Olde Adventure Land is populated by a wide variety of characters.
  One may encounter, for instance, warriors, mages, archers, rogues,
  healers, clerics, fairies, or even monsters of assorted shapes and sizes.
  However, there are certain things all of these entities have in common.
  These commonalities are expressed below. Read on!
  =============================================*/

public abstract class Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~
    protected int _hitPts;
    protected int _strength;
    protected int _defense;
    protected double _attack;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*=============================================
      default constructor
      pre:  instance vars are declared
      post: initializes instance vars.
      =============================================*/
    public Character() {
	_hitPts = 125;
	_strength = 100;
	_defense = 40;
	_attack = .4;
    }


    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~
    public int getDefense() { return _defense; }

    public abstract String getName();
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    
    /*=============================================
      boolean isAlive() -- tell whether I am alive
      post: returns boolean indicated alive or dead
      =============================================*/
    public boolean isAlive() {
	return _hitPts > 0;
    }


    /*=============================================
      int attack(Character) -- simulates attack on instance of class Monster
      pre:  Input not null
      post: Calculates damage to be inflicted, flooring at 0. 
            Calls opponent's lowerHP() method to inflict damage. 
	    Returns damage dealt.
      =============================================*/
    public int attack( Character opponent ) {

	int damage = (int)( (_strength * _attack) - opponent.getDefense() );
	//System.out.println( "\t\t**DIAG** damage: " + damage );

	if ( damage < 0 )
	    damage = 0;

	opponent.lowerHP( damage );

	return damage;
    }//end attack


    /*=============================================
      void lowerHP(int) -- lowers life by input value
      pre:  Input >= 0
      post: Life instance var is lowered by input ammount.
      =============================================*/
    public void lowerHP( int damageInflicted ) {
	_hitPts = _hitPts - damageInflicted;
    }


    /*=============================================
      void specialize() -- prepare a character to deliver a special attack
      pre:  n/a
      post: varies by class
      =============================================*/
    public abstract void specialize();


    /*=============================================
      void normalize() -- reset a character to normal mode
      pre:  n/a
      post: varies by class
      =============================================*/
    public abstract void normalize();

    public abstract int heal();
    //heals character an amount specific to his or her class
    public abstract int drain(Character x);
    //heals character an amount specific to his or her class and damages opponent same amount

    /*=============================================
      String about() -- gives a categorical description of a type of entity
      pre:  
      post: returns String describing this class
      =============================================*/
    public static String about() { 
	//boilerplate text, should a subclass not override this method
	return "Random RPG character, capable of many things.";
    }


}//end class Character

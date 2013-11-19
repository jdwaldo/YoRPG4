/*=============================================
  class YoRPG -- Driver file for Ye Olde Role Playing Game.
  Simulates monster encounters of a wandering adventurer.
  Required classes: Warrior, Monster
  =============================================*/

import java.io.*;
import java.util.*;

public class YoRPG {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~

    //change this constant to set number of encounters in a game
    public final static int MAX_ENCOUNTERS = 5;

    //each round, a Warrior and a Monster will be instantiated
    private Character pat;
    private Character smaug; //Friendly generic monster name, eh?

    private int moveCount;
    private int version = 0;
    private boolean gameOver;
    private int difficulty;

    private InputStreamReader isr;
    private BufferedReader in;
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~ DEFAULT CONSTRUCTOR ~~~~~~~~~~~
    public YoRPG() {
	moveCount = 0;
	gameOver = false;
	isr = new InputStreamReader( System.in );
	in = new BufferedReader( isr );
	newGame();
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // ~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~~~~~

    /*=============================================
      void newGame() -- facilitates info gathering to begin a new game
      pre:  
      post: according to user input, modifies instance var for difficulty 
      and instantiates a Warrior
      =============w================================*/
    public void newGame() {

	String s;
	boolean type = false;
	String name = "";
	s = "Welcome to Ye Olde RPG!\n";
	s += "\nChoose your difficulty: \n";
	s += "\t1: Easy\n";
	s += "\t2: Not so easy\n";
	s += "\t3: Beowulf hath nothing on me. Bring it on.\n";
	s += "Selection: ";
	System.out.print( s );

	try {
	    difficulty = Integer.parseInt( in.readLine() );
	}
	catch ( IOException e ) { }

	s = "Intrepid warrior, what doth thy call thyself? (State your name): ";
	System.out.print( s );

	try {
	    name = in.readLine();
	}
	catch ( IOException e ) { }

	while ( !type ) {

	    System.out.println("Choose thine character type:");
	    System.out.println("\t1: Warrior");
	    System.out.println("\t2: Mage");
	    System.out.println("\t3: Priest");
	    System.out.println("\t4: Rogue");
	    System.out.println("\t5: Archer");

	    try {
		version = Integer.parseInt(in.readLine());
	    }
	    catch ( IOException e ) { }

	    //instantiate the player's character
	    if (version == 1){
		pat = new Warrior(name);
	    } else if (version == 2) {
		pat = new Mage(name);
	    } else if (version == 3) {
		pat = new Priest(name);
	    } else if (version == 4) {
		pat = new Rogue(name);
	    } else if (version == 5) {
		pat = new Archer(name);
	    } else
		System.out.println( "invalid class type, out of range" );
                        
	    type = (version > 0);
	}
    }//end newGame()


    /*=============================================
      boolean playTurn -- simulates a round of combat
      pre:  Warrior pat has been initialized
      post: Returns true if player wins (monster dies).
            Returns false if monster wins (player dies).
      =============================================*/
    public boolean playTurn() {

	int i = 1;
	int d1, d2;

	if ( Math.random() >= ( difficulty / 3.0 ) )
	    System.out.println( "Nothing to see here. Move along!" );

	else {
	    System.out.println( "Lo, yonder monster approacheth!" );

	    smaug = (Math.random() < 0.5) ? new Monster() : new Sorcerer();

	    while( smaug.isAlive() && pat.isAlive() ) {

		// Give user the option of using a special attack:
		// If you land a hit, you incur greater damage,
		// ...but if you get hit, you take more damage.
		try {
		    System.out.println( "Do you feel lucky?" );
		    System.out.println( "\t1: Nay.\n\t2: Aye!\n\t: Heal!\n\t: Drain!" );
		    i = Integer.parseInt( in.readLine() );
		}
		catch ( IOException e ) { }

		if ( i == 2 ) {
		    pat.specialize();
		    d1 = pat.attack( smaug );
		    d2 = smaug.attack( pat );
		    System.out.println( pat.getName() + " dealt " + d1 +
					" points of damage.");

		    System.out.println( "Ye Olde Monster hit back for " + d2 +
					" points of damage.");
		}
		else if (i == 1) {
		    pat.normalize();
		    d1 = pat.attack( smaug );
		    d2 = smaug.attack( pat );
		    System.out.println( pat.getName() + " dealt " + d1 +
                                    " points of damage.");
		    System.out.println( "Ye Olde Monster hit back for " + d2 +
                                    " points of damage.");
		}
		else if (i == 3) {
		    d1 = pat.heal();
		    d2 = smaug.attack( pat);
		    System.out.println( pat.getName() + " healed for " + d1 +
					" points of damage.");
                    System.out.println( "Ye Olde Monster hit back for " + d2 +
					" points of damage.");
		}
		else {
		   d1 = pat.drain(smaug);
		   d2 = smaug.attack(pat);
                   System.out.println( pat.getName() + " drained Monster for " + d1 +
				       " points of damage.");
		   System.out.println( "Ye Olde Monster hit back for " + d2 +
				       " points of damage.");
		}
     
	    }//end while

	    //option 1: you & the monster perish
	    if ( !smaug.isAlive() && !pat.isAlive() ) {
		System.out.println( "'Twas an epic battle, to be sure... " + 
				    "You cut ye olde monster down, but " +
				    "with its dying breath ye olde monster. " +
				    "laid a fatal blow upon thy skull." );
		return false;
	    }
	    //option 2: you slay the beast
	    else if ( !smaug.isAlive() ) {
		System.out.println( "HuzzaaH! Ye olde monster hath been slain!" );
		return true;
	    }
	    //option 3: the beast slays you
	    else if ( !pat.isAlive() ) {
		System.out.println( "Ye olde self hath expired. You got dead." );
		return false;
	    }
	}//end else

	return true;
    }//end playTurn()
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    public static void main( String[] args ) {

	//As usual, move the begin-comment bar down as you progressively 
	//test each new bit of functionality...

	//loading...
	YoRPG game = new YoRPG();

	int encounters = 0;

	while( encounters < MAX_ENCOUNTERS ) {
	    if ( !game.playTurn() )
		break;
	    encounters++;
	    System.out.println();
	}

	System.out.println( "Thy game doth be over." );
	/*=============================================

	  =============================================*/

    }//end main

}//end class YoRPG




/*=============================================
  =============================================*/

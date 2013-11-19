public class Sorcerer extends Character {

    // ~~~~~~~~~~~ INSTANCE VARIABLES ~~~~~~~~~~~                                                            
    // inherited from superclass                                                                             
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                            


    /*=============================================                                                          
      default constructor                                                                                    
      pre:  instance vars are declared                                                                       
      post: initializes instance vars.                                                                       
      =============================================*/
    public Sorcerer() {
        super();
        _hitPts = 100;
        _strength = 40 + (int)( Math.random() * 50 ); // [20,65)                                             
        _defense = 10;
        _attack = 1;
    }

    // ~~~~~~~~~~~~~~ ACCESSORS ~~~~~~~~~~~~~~~~~                                                            
    public String getName() {
        return "Nameless Sorcerer. Win or die trying";
    }
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~                                                            


    //"prepare" a Monster for a special attack                                                               
    public void specialize() { }
    public void normalize() { }
    public int heal() { return 0; }
    public int drain( Character x) { return 0; }

    public static String about() {
        String blurb;
        blurb = "An evil magician. Hellbent on slaughtering those who stand in his way. ";
        blurb += "Hath ye Fear?";
        return blurb;
    }


}//end class Monster    

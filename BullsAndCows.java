// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock
/**
 * @author Partner A: Cole Heiple freeza1, Partner B: Vallab Kb kbv
 * @Version 11/4/2018
 */
 
class BullsAndCows {

   public static void main(String[] args) {
      String result = "";
      for(String arg : args)
      {
         result+= arg;
      }
      Game g = new Game(result);
      g.play();

   }
}

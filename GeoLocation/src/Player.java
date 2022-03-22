public class Player {
   public String name;
   public int number;
   
   public Player() {
      name = "Default";
      number = -1;
   }
   public Player(String n, int num) {
      name = n;
      number = num;
   }
   public String playerInfo() {
      String info = "Player : " + name + ",#" + number;
      return  info;
   }
}

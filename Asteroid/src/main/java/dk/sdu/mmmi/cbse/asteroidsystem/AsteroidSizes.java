package dk.sdu.mmmi.cbse.asteroidsystem;

public enum AsteroidSizes {
   SMALL(5), MEDIUM(10), BIG(15);

   private int size;

   AsteroidSizes(int size){

      this.size = size;

   }

   public int getSize() {
      return size;
   }
}

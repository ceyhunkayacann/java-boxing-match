public class Fighter {
    String name;
    int health;
    double damage;
    int weight;
    int dodge;

    Fighter(String name, int health, int weight,double damage, int dodge){
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.weight = weight;
        if(dodge >= 0 && dodge <= 100) {
            this.dodge = dodge;
        }
        else {
            this.dodge = 0;
        }
    }

    int hit(Fighter foe) throws InterruptedException {
        System.out.println(" ");
        System.out.printf("%s attacking to %s\n",this.name,foe.name);
        Thread.sleep(1000);

        System.out.printf("%s hits %s damage..\n",this.name,(int)this.damage);
        Thread.sleep(1000);

        if (isDodge()){
            System.out.println("Blocked!");
            return foe.health;
        }

        if ((int) (foe.health - this.damage) <= 0){
            return 0;
        }
        return (int) (foe.health - this.damage);
    }

    boolean isDodge() {
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.dodge;
    }
}

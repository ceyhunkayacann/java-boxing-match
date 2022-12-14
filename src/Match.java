public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;

    Match(Fighter f1, Fighter f2,int maxWeight, int minWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    boolean checkWeight() {
        return (f1.weight >= this.minWeight && f1.weight <= this.maxWeight) && (f2.weight >= this.minWeight && f2.weight <= this.maxWeight);
    }

    void run() throws InterruptedException {
        if(checkWeight()){
            if (start()){
                System.out.println(f1.name + " starting..");
                while (true){
                    System.out.println(" ");
                    System.out.println("====New Round====");
                    this.f1.damage += Math.floor(Math.random() * 10);
                    this.f2.health = this.f1.hit(f2);
                    System.out.println(" ");
                    if (isWin()){
                        break;
                    }
                    this.f2.damage += Math.floor(Math.random() * 10);
                    this.f1.health = this.f2.hit(f1);
                    System.out.println(" ");
                    if (isWin()){
                        break;
                    }
                    System.out.println("========");
                    printScore();
                }
            }
            else {
                System.out.println(f2.name + " starting..");
                while (true){
                    System.out.println(" ");
                    System.out.println("====New Round====");
                    this.f2.damage += Math.floor(Math.random() * 10);
                    this.f1.health = this.f2.hit(f1);
                    System.out.println(" ");
                    if (isWin()){
                        break;
                    }
                    this.f1.damage += Math.floor(Math.random() * 10);
                    this.f2.health = this.f1.hit(f2);
                    System.out.println(" ");
                    if (isWin()){
                        break;
                    }
                    System.out.println("========");
                    printScore();
                }
            }
        }
    }

    boolean start(){
        return Math.floor(Math.random() * 10) % 2 == 0;
    }


    boolean isWin() {
        if (f1.health <= 0) {
            printScore();
            System.out.println(" ");
            System.out.printf("%s WINS..\n",f2.name);
            return true;
        }
        if (f2.health <= 0) {
            printScore();
            System.out.println(" ");
            System.out.printf("%s WINS..\n",f1.name);
            return true;
        }

        return false;
    }

    void printScore(){
        System.out.printf("%s's health : %s\n",f1.name,f1.health);
        System.out.printf("%s's health : %s\n",f2.name,f2.health);
    }
}

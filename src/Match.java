public class Match {
    Fighter f1;
    Fighter f2;
    Fighter baslayanOyuncu;
    Fighter digerOyuncu;


    int minWeight;
    int maxWeight;


    Match(Fighter f1, Fighter f2, int minWeight, int maxWeight) {
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
        this.baslayanOyuncu = null;
        this.digerOyuncu = null;
    }

    public void baslayanOyuncuyuBulma() {
        double rastgele = Math.random() * 100;
        if (rastgele < 50) {
            this.baslayanOyuncu = f1;
            this.digerOyuncu = f2;
        } else {
            this.baslayanOyuncu = f2;
            this.digerOyuncu = f1;
        }
        System.out.println("Dövüşe Başlayan Oyuncumuz: " + baslayanOyuncu.name);
    }

    public void run() {
        if (isCheck()) {

            while (this.f1.health > 0 && this.f2.health > 0) {
                System.out.println("=====YENİ ROUND ======");
                this.f2.health = this.f1.hit(this.f2);

                if (isWin()) {
                    break;
                }


                if (this.f2.health <= 0) {
                    System.out.println(this.f2.name + " NAKAVT!");
                    break;
                }
                this.f1.health = this.f2.hit(this.f1);
                if (isWin()) {
                    break;
                }
                System.out.println(this.f1.name + " Sağlık " + this.f1.health);
                System.out.println(this.f2.name + " Sağlık " + this.f2.health);


            }

        } else {
            System.out.println("Sporcuların Sikletleri Uymuyor. ");

        }
    }

    boolean isCheck() {
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin() {
        if (this.f1.health == 0) {
            System.out.println(f2.name + " kazandı !");
            return true;
        }
        if (this.f2.health == 0) {
            System.out.println(this.f1.name + " kazandı !");
            return true;
        }
        return false;
    }

}

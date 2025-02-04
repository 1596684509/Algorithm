package Algorithm;

import java.util.Spliterator;

public class MethodChain {

    public static void main(String[] args) {

        Character character = new Character.Creator()
                .name("勇者")
                .attack(10)
                .hp(200)
                .speed(1.0)
                .spell(300)
                .create();

        System.out.println(character.getAttack());

    }

}

class Character {

    private String name;
    private double hp;
    private double attack;
    private double spell;
    private double speed;

    private Character(Creator creator) {

        name = creator.name;
        hp = creator.hp;
        attack = creator.attack;
        spell = creator.spell;
        speed = creator.speed;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getSpell() {
        return spell;
    }

    public void setSpell(double spell) {
        this.spell = spell;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    static final class Creator {

        private String name;
        private double hp;
        private double attack;
        private double spell;
        private double speed;

        public Creator name(String name) {

            this.name = name;
            return this;

        }

        public Creator hp(double hp) {

            this.hp = hp;
            return this;

        }

        public Creator attack(double attack) {

            this.attack = attack;
            return this;

        }

        public Creator spell(double spell) {

            this.spell = spell;
            return this;

        }

        public Creator speed(double speed) {

            this.speed = speed;
            return this;

        }

        public Character create() {

            return new Character(this);

        }

    }

}

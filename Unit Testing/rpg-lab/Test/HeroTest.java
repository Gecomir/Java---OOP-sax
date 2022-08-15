package UnitTesting.rpg_lab.Test;

import org.junit.Test;
import UnitTesting.rpg_lab.Hero;
import UnitTesting.rpg_lab.Target;
import UnitTesting.rpg_lab.Weapon;

import static org.junit.Assert.assertEquals;

public class HeroTest {

    private static class FakeWeapon implements Weapon {
        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {
        }
    }

    @Test
    public void test_HeroGainsXP_When_KillingTarget() {
        Hero hero = new Hero("Javarcho", new FakeWeapon());

        assertEquals(0, hero.getExperience());

        Target target = new Target() {
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 200;
            }

            @Override
            public Boolean isDead() {
                return true;
            }
        };

        hero.attack(target);

        assertEquals(200, hero.getExperience());
    }
}
package CounterStriker.models.guns;

import static CounterStriker.common.Constants.RIFLE_BULLETS_PER_SHOOT;

public class Rifle extends GunImpl {
    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
        setBulletsPerShoot(RIFLE_BULLETS_PER_SHOOT);
    }
}

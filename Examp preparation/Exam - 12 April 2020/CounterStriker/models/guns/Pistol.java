package CounterStriker.models.guns;

import static CounterStriker.common.Constants.PISTOL_BULLETS_PER_SHOOT;

public class Pistol extends GunImpl {

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
        setBulletsPerShoot(PISTOL_BULLETS_PER_SHOOT);
    }
}

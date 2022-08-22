package goldDigger.repositories;

import goldDigger.models.spot.Spot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SpotRepository implements Repository {
    private Collection<Spot> spots;

    public SpotRepository() {

        spots = new ArrayList<>();
    }

    @Override
    public Collection getCollection() {
        return Collections.unmodifiableCollection(spots);
    }

    @Override
    public void add(Object entity) {
        spots.add((Spot) entity);
    }

    @Override
    public boolean remove(Object entity) {
        return spots.remove(entity);
    }

    @Override
    public Object byName(String name) {
        for (Spot spot : spots) {
            if (spot.getName().equals(name)) {
                return spot;
            }
        }

        return null;
    }
}

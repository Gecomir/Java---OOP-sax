package goldDigger.repositories;

import goldDigger.models.discoverer.BaseDiscoverer;
import goldDigger.models.discoverer.Discoverer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DiscovererRepository implements Repository{
    private Collection<Discoverer> discoverers;

    public DiscovererRepository() {
        discoverers = new ArrayList<>();
    }

    @Override
    public Collection<Discoverer> getCollection() {
        return Collections.unmodifiableCollection(discoverers);
    }

    @Override
    public void add(Object entity) {
        discoverers.add((BaseDiscoverer) entity);
    }

    @Override
    public boolean remove(Object entity) {
        return discoverers.remove(entity);
    }

    @Override
    public Object byName(String name) {
        return discoverers.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
    }
}

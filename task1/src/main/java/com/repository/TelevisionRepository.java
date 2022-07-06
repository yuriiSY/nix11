package com.repository;

import com.model.Phone;
import com.model.Tablet;
import com.model.Television;

import java.util.*;

public class TelevisionRepository implements TelevisionCrudRepository{

    private final List<Television> televisions;

    public TelevisionRepository() {
        this.televisions = new ArrayList<>();
    }


    @Override
    public void save(Television television) {
       televisions.add(television);
    }

    @Override
    public void saveAll(List<Television> televisions) {
        for (Television television : televisions) {
            save(television);
        }
    }

    @Override
    public boolean update(Television television) {
        final Optional<Television> result = findById(television.getId());
        if (result.isEmpty()) {
            return false;
        }
        final Television originTelevision = result.get();
        TelevisionRepository.TelevisionCopy.copy(television, originTelevision);
        return true;
    }

    @Override
    public boolean delete(String id) {
        final Iterator<Television> iterator = televisions.iterator();
        while (iterator.hasNext()) {
            final Television television = iterator.next();
            if (television.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Television> getAll() {
        if (televisions.isEmpty()) {
            return Collections.emptyList();
        }
        return televisions;
    }

    @Override
    public Optional<Television> findById(String id) {
        Television result = null;
        for (Television television : televisions) {
            if (television.getId().equals(id)) {
                result = television;
            }
        }
        return Optional.ofNullable(result);
    }

    private static class TelevisionCopy {
        private static void copy(final Television from, final Television to) {
            to.setCount(from.getCount());
            to.setPrice(from.getPrice());
            to.setTitle(from.getTitle());
        }
    }
}

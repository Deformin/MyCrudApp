package com.mycrudapp.dao.impl;

import com.mycrudapp.dao.PartDAO;
import com.mycrudapp.entity.Part;
import com.mycrudapp.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class PartDAOImpl implements PartDAO {
    private final HibernateUtil hibernateUtil;

    @Autowired
    public PartDAOImpl(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @Override
    public int createPart(Part part) {
        return (int) hibernateUtil.create(part);
    }

    @Override
    public Part updatePart(Part part) {
        return hibernateUtil.update(part);
    }

    @Override
    public void deletePart(int id) {
        Part part = new Part();
        part.setId(id);
        hibernateUtil.delete(part);
    }

    @Override
    public List<Part> getAllParts() {
        return hibernateUtil.fetchAll(Part.class);
    }

    @Override
    public Part getPart(int id) {
        return hibernateUtil.fetchById(id, Part.class);
    }

    @Override
    public Integer computerAmount() {
        List<Part> neededParts = getNeeded("true");
        if (neededParts.isEmpty()) return 0;
        List<Integer> amounts = new ArrayList<>();
        neededParts.forEach(part -> amounts.add(part.getAmount()));
        return Collections.min(amounts);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Part> getAllParts(String partName) {
        String query = "SELECT t.* FROM part t WHERE t.name like '%"+ partName +"%'";
        List<Object[]> partObjects = hibernateUtil.fetchAll(query);
        List<Part> parts = new ArrayList<>();
        setParts(partObjects, parts);
        return parts;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Part> getNeeded(String filterNeeded) {
        if (filterNeeded.isEmpty()) return getAllParts();
        String query = "SELECT t.* FROM part t WHERE t.isNeeded = " + filterNeeded;
        List<Object[]> partObjects = hibernateUtil.fetchAll(query);
        List<Part> parts = new ArrayList<>();
        setParts(partObjects, parts);
        return parts;
    }

    private void setParts(List<Object[]> partObjects, List<Part> parts) {
        for(Object[] partObject: partObjects) {
            Part part = new Part();
            int id = (int) partObject[0];
            String name = (String) partObject[1];
            boolean isNeeded = (boolean) partObject[2];
            int amount = (int) partObject[3];
            part.setId(id);
            part.setName(name);
            part.setNeeded(isNeeded);
            part.setAmount(amount);
            parts.add(part);
        }
    }
}

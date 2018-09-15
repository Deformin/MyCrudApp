package com.mycrudapp.service.impl;

import com.mycrudapp.dao.PartDAO;
import com.mycrudapp.entity.Part;
import com.mycrudapp.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PartServiceImpl implements PartService {
    private final PartDAO partDAO;

    @Autowired
    public PartServiceImpl(PartDAO partDAO) {
        this.partDAO = partDAO;
    }

    @Override
    public int createPart(Part part) {
        return partDAO.createPart(part);
    }

    @Override
    public Part updatePart(Part part) {
        return partDAO.updatePart(part);
    }

    @Override
    public void deletePart(int id) {
        partDAO.deletePart(id);
    }

    @Override
    public List<Part> getAllParts() {
        return partDAO.getAllParts();
    }

    @Override
    public Part getPart(int id) {
        return partDAO.getPart(id);
    }

    @Override
    public List<Part> getAllParts(String partName) {
        return partDAO.getAllParts(partName);
    }

    @Override
    public List<Part> getNeeded(String filterNeeded) {
        return partDAO.getNeeded(filterNeeded);
    }

    @Override
    public Integer computerAmount() {return partDAO.computerAmount();}
}
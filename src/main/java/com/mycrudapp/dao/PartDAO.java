package com.mycrudapp.dao;

import com.mycrudapp.entity.Part;

import java.util.List;

public interface PartDAO {
    int createPart(Part part);
    Part updatePart(Part part);
    void deletePart(int id);
    List<Part> getAllParts();
    Part getPart(int id);
    List<Part> getAllParts(String partName);
    List<Part> getNeeded(String filterNeeded);
    int computerAmount();
}
package com.mycrudapp.service;

import com.mycrudapp.entity.Part;

import java.util.List;

public interface PartService {
    void createPart(Part part);
    void updatePart(Part part);
    void deletePart(int id);
    List<Part> getAllParts();
    Part getPart(int id);
    List<Part> getAllParts(String partName);
    List<Part> getNeeded(String filterNeeded);
    int computerAmount();
}
package com.example.wastesorting.service;
import com.example.wastesorting.model.WasteCategory;
import com.example.wastesorting.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WasteCategoryService {
    List<WasteCategory> getAllWasteCategories();
    WasteCategory createWasteCategory(WasteCategory wasteCategory);
    WasteCategory updateWasteCategory(Long id, WasteCategory wasteCategory);
    void deleteWasteCategory(Long id);
}



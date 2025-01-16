package com.example.wastesorting.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.wastesorting.model.WasteCategory;
import com.example.wastesorting.repository.WasteCategoryRepository;

@Service
public class WasteCategoryServiceImpl implements WasteCategoryService {
    @Autowired
    private WasteCategoryRepository wasteCategoryRepository;
    @Override
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }
    @Override
    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }
    @Override
    public WasteCategory updateWasteCategory(Long id, WasteCategory wasteCategory) {
        WasteCategory existingCategory = wasteCategoryRepository.findById(id).orElseThrow();
        existingCategory.setName(wasteCategory.getName());
        existingCategory.setDisposalGuidelines(wasteCategory.getDisposalGuidelines());
        existingCategory.setRecyclingTips(wasteCategory.getRecyclingTips());
        return wasteCategoryRepository.save(existingCategory);
    }
    @Override
    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}

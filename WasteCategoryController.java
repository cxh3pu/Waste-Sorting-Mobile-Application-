package com.example.wastesorting.controller;

import com.example.wastesorting.model.WasteCategory;
import com.example.wastesorting.service.WasteCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-categories")
public class WasteCategoryController {

	@Autowired
    private WasteCategoryService wasteCategoryService;

    @GetMapping
    public ResponseEntity<List<WasteCategory>> getAllWasteCategories() {
        List<WasteCategory> categories = wasteCategoryService.getAllWasteCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
        //Retrieves all waste categories
    }

    @PostMapping
    public ResponseEntity<WasteCategory> createWasteCategory(@Validated @RequestBody WasteCategory wasteCategory) {
        WasteCategory createdCategory = wasteCategoryService.createWasteCategory(wasteCategory);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
        //Creates a new waste category, with input validation
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteCategory> updateWasteCategory(@PathVariable Long id, @Validated @RequestBody WasteCategory wasteCategory) {
        WasteCategory updatedCategory = wasteCategoryService.updateWasteCategory(id, wasteCategory);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        //Updates an existing waste category based on the provided ID
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWasteCategory(@PathVariable Long id) {
        wasteCategoryService.deleteWasteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        //Deletes a waste category by ID
    }
}
package com.example.wastesorting.repository;

import java.util.List;
import com.example.wastesorting.model.WasteCategory;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {
    // No additional methods needed for now
}


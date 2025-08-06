package com.example.blogsystem.Controller;

import com.example.blogsystem.Api.ApiResponse;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/CATEGORY")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/GET")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok().body(categoryService.getCategories());
    }

    @PostMapping("/POST")
    public ResponseEntity<?> addCategory(@Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        categoryService.addCategory(category);
        return ResponseEntity.ok().body(new ApiResponse("Category successfully added"));
    }

    @PutMapping("/UPDATE/{id}")
    public ResponseEntity<?> UpdateCategory(@PathVariable Integer id, @Valid @RequestBody Category category, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }

        categoryService.updateCategory(id, category);
        return ResponseEntity.ok().body(new ApiResponse("Category successfully updated"));
    }

    @DeleteMapping("/DELETE/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().body(new ApiResponse("Category successfully deleted"));
    }

}

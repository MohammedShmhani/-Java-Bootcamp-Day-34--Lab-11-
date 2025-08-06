package com.example.blogsystem.Service;

import com.example.blogsystem.Api.ApiException;
import com.example.blogsystem.Model.Category;
import com.example.blogsystem.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepository.findCategoryByCategoryId(categoryId);
        if (category == null)
            throw new ApiException("Category not found");
        categoryRepository.delete(category);

    }

    public void updateCategory(Integer id, Category category) {
        Category category1 = categoryRepository.findCategoryByCategoryId(id);
        if (category1 == null)
            throw new ApiException("Category not found");
        category1.setCategoryName(category.getCategoryName());
        categoryRepository.save(category1);
    }
}

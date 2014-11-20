package com.ami.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ami.dto.CategoryDTO;
import com.ami.exceptions.CustomException;
import com.ami.model.Category;
import com.ami.model.Status;
import com.ami.services.CategoryServices;

@Controller
@RequestMapping("/categories/{catguid}/subcategories")
public class SubCategoryController {

	@Autowired
	CategoryServices categoryServices;

	// static final Logger logger = Logger.getLogger(RestController.class);

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status createCategory(@RequestBody CategoryDTO category) {
		// CategoryServices categoryServices = new CategoryServicesImpl();
		// System.out.println("category Svc object is" + categoryServices);
		try {
			Category categoryDao = null;
			if (categoryServices.validateCategory(category)) {
				categoryDao = new Category();
				categoryDao.setCatId(category.getCatguid());
				categoryDao.setCategoryName(category.getCatName());
				categoryDao.setDesc(category.getCatDesc());

			}
			categoryServices.addCategory(categoryDao);
			return new Status(1, "Category added Successfully !");
		} catch (CustomException e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public @ResponseBody
	Category getCategory(@PathVariable("id") String id) {
		Category category = null;
		try {
			category = categoryServices.getCategoryById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<Category> getCategories() {

		List<Category> categoryList = null;
		try {
			categoryList = categoryServices.getCategoryList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryList;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Status deleteCategory(@PathVariable("id") String id) {

		try {
			categoryServices.deleteCategory(id);
			return new Status(1, "Category deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

}

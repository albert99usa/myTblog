package com.tangzq.controller;
	

	import com.tangzq.model.Category;
	import com.tangzq.service.CategoryService;
	import com.tangzq.vo.PageVo;
	import org.apache.commons.lang.StringUtils;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Page;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;
	

	

	

	import java.sql.Date;
	import java.util.List;
	

	/**
	 * 分類控制器
	 * @author tangzhiqiang
	 */
	@Controller
	@RequestMapping("/cat")
	public class CategoryController {
	

	    @Autowired
	    private CategoryService categoryService;
	

	

	    /**
	     * 分類列表
	     * @param model
	     * @return
	     */
	    @RequestMapping(value="/list",method = RequestMethod.GET)
	    public String listCategory(PageVo pageVo, ModelMap model){
	        Page<Category> category =categoryService.findByPage(pageVo.getPageNO(),pageVo.getPageSize());
	        model.addAttribute("pager",categoryService.findByPage(pageVo.getPageNO(),pageVo.getPageSize()));
	        return "category/cat_list";
	    }
	

	

	    /**
	     * 新增分類表單
	     * @return
	     */
	    @RequestMapping(value="/create",method = RequestMethod.GET)
	    public String createCategory(){
	        return "category/cat_add";
	    }
	

	    /**
	     * 新增分類
	     * @param cat
	     * @param model
	     * @param redirectAttributes
	     * @return
	     */
	    @RequestMapping(value = "/create",method = RequestMethod.POST)
	    public String doCreateCategory(Category cat,
	                                   ModelMap model,
	                                   RedirectAttributes redirectAttributes){
	        /*
	
	        if(null==cat||StringUtils.isEmpty(cat.getCatName())||StringUtils.isEmpty(cat.getcatdir())){
	            model.addAttribute("messageErr","分類名稱和目錄名不能為空");
	            model.addAttribute("cat",cat);
	            return "category/cat_add";
	        }
	*/
	

	        if(categoryService.isCategoryExisted(cat.getcatdir())){
	            model.addAttribute("messageErr","目錄名已經存在,請換成其他的");
	            model.addAttribute("cat",cat);
	            return "category/cat_add";
	        }
	

	     //   cat.setCreateAt((java.sql.Date) new Date());
	      //  cat.setUpdateAt(new Date());
	

	        cat.setParent_id(new Long("1"));
	        cat.setCreateat(new Date(System.currentTimeMillis()));
	

	        Category savedCat=categoryService.addCategory(cat);
	        if(null!=savedCat&&savedCat.getId()!=null){
	            redirectAttributes.addFlashAttribute("messageSuc","創建分類成功");
	            return "redirect:/cat/list";
	        }else{
	            redirectAttributes.addFlashAttribute("messageErr","分類創建失敗");
	            model.addAttribute("cat",cat);
	            return "category/cat_add";
	        }
	    }
	

	

	    /**
	     * 修改分類表單
	     * @param catID
	     * @param model
	     * @return
	     */
	    @RequestMapping(value="/edit/{catID}",method = RequestMethod.GET)
	    public String editCategory(@PathVariable("catID") String catID, ModelMap model){
	        model.addAttribute("cat",categoryService.findById(catID));
	        return "category/cat_edit";
	    }
	

	

	    /**
	     * 修改分類
	     * @param cat
	     * @param model
	     * @param redirectAttributes
	     * @return
	     */
	    @RequestMapping(value = "/edit/{catID}",method = RequestMethod.POST)
	    public String doEditCategory(@PathVariable("catID") String catID, Category cat,
	                                 ModelMap model,
	                                 RedirectAttributes redirectAttributes){
	        if(null==cat||StringUtils.isEmpty(cat.getName())||StringUtils.isEmpty(cat.getcatdir())){
	            model.addAttribute("messageErr","分類名稱和目錄名不能為空");
	            model.addAttribute("cat",cat);
	            return "category/cat_edit";
	        }
	

	      //  cat.setUpdateAt(new Date());
	        cat.setParent_id(new Long("1"));
	        cat.setCreateat(new Date(System.currentTimeMillis()));
	

	

	        Category savedCat=categoryService.updateById(cat,catID);
	        if(null!=savedCat&&savedCat.getId()!=null){
	            redirectAttributes.addFlashAttribute("messageSuc","更新分類成功");
	            return "redirect:/cat/list";
	        }else{
	            redirectAttributes.addFlashAttribute("messageErr","分類更新失敗");
	            model.addAttribute("cat",cat);
	            return "category/cat_edit";
	        }
	    }
	

	}


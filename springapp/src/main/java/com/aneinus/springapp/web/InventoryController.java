package com.aneinus.springapp.web;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.aneinus.springapp.service.ProductManager;

public class InventoryController implements Controller {

    protected final Log logger = LogFactory.getLog(getClass());
    
    private ProductManager productManager;

    public void	setProductManager(ProductManager p)
    {
    	this.productManager = p;
    }
    
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	String now = (new Date()).toString();
    	
    	Map<String, Object> myModel = new HashMap<String, Object>();
    	myModel.put("now", now);
    	myModel.put("products", this.productManager.getProducts());
    	
        logger.info("Returning hello view");

        return new ModelAndView("hello", "model", myModel);
    }
}
package com.mycrudapp.controller;

import com.mycrudapp.entity.Part;
import com.mycrudapp.service.PartService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PartController {
    private static final Logger logger = Logger.getLogger(PartController.class);
    private static final int MAX_ROWS_PER_PAGE = 10;
    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @RequestMapping("createPart")
    public ModelAndView createPart(@ModelAttribute Part part) {
        logger.info("Creating Part. Data: " + part);
        return new ModelAndView("partForm");
    }

    @RequestMapping("editPart")
    public ModelAndView editPart(@RequestParam int id, @ModelAttribute Part part) {
        logger.info("Updating the Part for the Id " + id + " and part " + part);
        part = partService.getPart(id);
        return new ModelAndView("partForm", "partObject", part);
    }

    @RequestMapping("savePart")
    public ModelAndView savePart(@ModelAttribute Part part) {
        logger.info("Saving the Part. Data : " + part);
        if (part.getId() == 0) { // if part id is 0 then creating part, otherwise updating part
            partService.createPart(part);
        } else {
            partService.updatePart(part);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("deletePart")
    public ModelAndView deletePart(@RequestParam int id) {
        logger.info("Deleting the Part. Id : " + id);
        partService.deletePart(id);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping("getAllParts")
    public ModelAndView getAllParts() {
        logger.info("Getting all Parts.");
        List<Part> partsList = partService.getAllParts();
        ModelAndView modelAndView = new ModelAndView("partList", "partList", partsList);
        modelAndView.addObject("computers", computers());
        return modelAndView;
    }

    @RequestMapping("searchPart")
    public ModelAndView searchPart(@RequestParam("searchName") String searchName) {
        logger.info("Searching the Part. Part Name(s): " + searchName);
        List<Part> partsList = partService.getAllParts(searchName);
        ModelAndView modelAndView = new ModelAndView("partList", "partList", partsList);
        modelAndView.addObject("computers", computers());
        return modelAndView;
    }

    @RequestMapping("/")
    public ModelAndView listOfParts(@RequestParam(required = false) Integer page) {
        logger.info("Getting all Parts.");
        ModelAndView modelAndView = new ModelAndView("partList");

        List<Part> parts = partService.getAllParts();
        PagedListHolder<Part> pagedListHolder = new PagedListHolder<>(parts);
        pagedListHolder.setPageSize(MAX_ROWS_PER_PAGE);
        modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

        if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
            page = 1;
            pagedListHolder.setPage(0);
            modelAndView.addObject("partList", pagedListHolder.getPageList());
        } else if (page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page - 1);
            modelAndView.addObject("partList", pagedListHolder.getPageList());
        }
        modelAndView.addObject("page", page);
        modelAndView.addObject("computers", computers());
        return modelAndView;
    }

    @RequestMapping("listNeeded")
    public ModelAndView listNeeded(@RequestParam("isNeeded") String filterNeeded) {
        logger.info("Getting Needed or Not Needed Parts.");
        List<Part> partsList = partService.getNeeded(filterNeeded);
        ModelAndView modelAndView = new ModelAndView("partList", "partList", partsList);
        modelAndView.addObject("computers", computers());
        return modelAndView;
    }

    private Integer computers() {
        logger.info("Getting Computer Amount.");
        System.out.println(partService.computerAmount());
        return partService.computerAmount();
    }
}
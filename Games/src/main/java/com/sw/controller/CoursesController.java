package com.sw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sw.model.Account;
import com.sw.model.AccountDB;
import com.sw.model.CourseDB;

import javassist.expr.NewArray;

@Controller
public class CoursesController {
	CourseDB coursedb = new CourseDB();
     Account account=new Account();
	@RequestMapping("/courses")
	public String ShowCOurses(Model model) {
		model.addAttribute("courses", coursedb.ShowCourses());
		return "showCourses";
	}

	// @RequestMapping("/showgames")
	// public String shoe(Model model){
	// return "ShowGamesinCourse";
	// }
	@RequestMapping("/showGames")
	public String ShowGames(Model model, @RequestParam("CourseName") String coursename) {
		model.addAttribute("Games", coursedb.showGamesInCourse(coursename));

		return "ShowGamesinCourse";
	}

	@RequestMapping("/AddCourse")
	public String AddCourse(Model model, @RequestParam("CourseName") String coursename) {
		boolean added = coursedb.AddCourse(coursename);
		if (!added) {
			model.addAttribute("added", "Failed To Add Course Maybe Exists!!");
		} else {
			model.addAttribute("added", "Course Added sussesfully");
		}
		return "teacher";
	}
}

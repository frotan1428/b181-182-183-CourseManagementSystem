package com.tpe.controller;

import com.tpe.domain.Course;
import com.tpe.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/courses")//http://localhost:8080/MvcPractice/courses
public class CourseController {


    @Autowired
    private CourseService courseService;

    @GetMapping("/form")//http://localhost:8080/MvcPractice/courses/form
    public String showCourseForm(@ModelAttribute("course") Course course){
        return "courseForm";

    }

    @PostMapping("/saveCourse")//http://localhost:8080/MvcPractice/courses/saveCourse
    public String createCourse(@Valid @ModelAttribute Course course , BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "courseForm";
        }
        courseService.saveCourse(course);
        return "redirect:/courses";//after save process to display all courses
    }

    @GetMapping
    public ModelAndView getCourse(){
       List<Course> courseList= courseService.getAllCourse();

       ModelAndView mav= new ModelAndView();
       mav.addObject("courses",courseList);
       mav.setViewName("courses");
       return  mav;
    }


    @GetMapping("/update")
    public String ShowUpdateForm(@RequestParam("id") Long id, Model model){
       Course course= courseService.findCourseById(id);
        model.addAttribute("course",course);
        return "courseForm";
    }


    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id){

        courseService.deleteCourse(id);
         return "redirect:/courses";//after save process to display all courses

    }





}

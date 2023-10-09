package com.tpe.service;

import com.tpe.domain.Course;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAll();
    }

    @Override
    public Course findCourseById(Long id) {
      Course course=  courseRepository.findById(id).
              orElseThrow(()-> new ResourceNotFoundException("Course is Not Found By id:   "+id));
      return course;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.delete(id);
    }

}

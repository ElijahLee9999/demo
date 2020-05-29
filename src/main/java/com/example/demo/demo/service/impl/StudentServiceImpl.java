package com.example.demo.demo.service.impl;

import com.example.demo.demo.entity.Student;
import com.example.demo.demo.mapper.StudentMapper;
import com.example.demo.demo.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 学生表 Service
 *
 * @author Elijah
 * @since 2020-05-28
 */
@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
